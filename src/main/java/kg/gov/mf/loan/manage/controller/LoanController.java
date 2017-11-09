package kg.gov.mf.loan.manage.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kg.gov.mf.loan.manage.model.debtor.Debtor;
import kg.gov.mf.loan.manage.model.loan.CreditTerm;
import kg.gov.mf.loan.manage.model.loan.Loan;
import kg.gov.mf.loan.manage.model.loan.LoanState;
import kg.gov.mf.loan.manage.model.loan.LoanType;
import kg.gov.mf.loan.manage.model.loan.SupervisorPlan;
import kg.gov.mf.loan.manage.model.loan.WriteOff;
import kg.gov.mf.loan.manage.model.orderterm.OrderTermDaysMethod;
import kg.gov.mf.loan.manage.model.orderterm.OrderTermFloatingRateType;
import kg.gov.mf.loan.manage.model.orderterm.OrderTermRatePeriod;
import kg.gov.mf.loan.manage.model.orderterm.OrderTermTransactionOrder;
import kg.gov.mf.loan.manage.service.debtor.DebtorService;
import kg.gov.mf.loan.manage.service.loan.LoanService;
import kg.gov.mf.loan.manage.service.loan.LoanStateService;
import kg.gov.mf.loan.manage.service.loan.LoanTypeService;
import kg.gov.mf.loan.manage.service.order.CreditOrderService;
import kg.gov.mf.loan.manage.service.orderterm.OrderTermCurrencyService;
import kg.gov.mf.loan.manage.service.orderterm.OrderTermDaysMethodService;
import kg.gov.mf.loan.manage.service.orderterm.OrderTermFloatingRateTypeService;
import kg.gov.mf.loan.manage.service.orderterm.OrderTermRatePeriodService;
import kg.gov.mf.loan.manage.service.orderterm.OrderTermTransactionOrderService;
import kg.gov.mf.loan.manage.util.Utils;

@Controller
public class LoanController {
	
	@Autowired
	DebtorService debtorService;
	
	@Autowired
	OrderTermCurrencyService currService;
	
	@Autowired
	LoanTypeService loanTypeService;
	
	@Autowired
	LoanStateService loanStateService;
	
	@Autowired
	LoanService loanService;
	
	@Autowired
	CreditOrderService orderService;
	
	@Autowired
	OrderTermRatePeriodService ratePeriodService;
	
	@Autowired
	OrderTermFloatingRateTypeService rateTypeService;
	
	@Autowired
	OrderTermTransactionOrderService txOrderService;
	
	@Autowired
	OrderTermDaysMethodService daysMethodService;

	static final Logger loggerLoan = LoggerFactory.getLogger(Loan.class);
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(value = { "/manage/debtor/{debtorId}/loan/{loanId}/view"})
    public String viewLoan(ModelMap model, @PathVariable("debtorId")Long debtorId, @PathVariable("loanId")Long loanId) {

		Loan loan = loanService.findById(loanId);
        model.addAttribute("loan", loan);
        
        model.addAttribute("terms", loan.getCreditTerm());
        model.addAttribute("emptyTerm", new CreditTerm());
        
        model.addAttribute("WOs", loan.getWriteOff());
        model.addAttribute("emptyWO", new WriteOff());
        
        model.addAttribute("SPs", loan.getSupervisorPlan());
        model.addAttribute("emptySP", new SupervisorPlan());
        
        List<OrderTermRatePeriod> ratePeriods = ratePeriodService.findAll();
        model.addAttribute("ratePeriods", ratePeriods);
        
        List<OrderTermFloatingRateType> rateTypes = rateTypeService.findAll();
        model.addAttribute("rateTypes", rateTypes);
        model.addAttribute("popots", rateTypes);
        model.addAttribute("poiots", rateTypes);
        
        List<OrderTermTransactionOrder> txOrders = txOrderService.findAll();
        model.addAttribute("tXs", txOrders);
        
        List<OrderTermDaysMethod> daysMethods = daysMethodService.findAll();
        model.addAttribute("dimms", daysMethods);
        model.addAttribute("diyms", daysMethods);
        
        model.addAttribute("debtorId", debtorId);
        
        model.addAttribute("loggedinuser", Utils.getPrincipal());
        return "/manage/debtor/loan/view";
    }
	
	@RequestMapping(value="/manage/debtor/{debtorId}/loan/save", method=RequestMethod.POST)
	public String saveLoan(Loan loan,
			long currencyId,
			long typeId,
			long stateId,
			long creditOrderId,
			@RequestParam(required=false) Long parentLoanId,
			@PathVariable("debtorId")Long debtorId, 
			ModelMap model)
	{
		
		Debtor debtor = debtorService.findById(debtorId);
		if(loan != null && loan.getId() == 0)
		{
			Loan newLoan = new Loan(loan.getRegNumber(), 
					loan.getRegDate(), 
					loan.getAmount(), 
					currService.findById(currencyId),
					loanTypeService.findById(typeId),
					loanStateService.findById(stateId),
					loan.getSupervisorId(),
					false,
					orderService.findById(creditOrderId));
			
			if(parentLoanId > 0)
			{
				Loan parentLoan = loanService.findById(parentLoanId);
				newLoan.setParentLoan(parentLoan);
				parentLoan.setHasSubLoan(true);
				loanService.update(parentLoan);
			}
				
			
			newLoan.setDebtor(debtor);
			
			loggerLoan.info("createLoan : {}", newLoan);
			
			loanService.save(newLoan);
		}
			
		if(loan != null && loan.getId() > 0)
		{
			loan.setCurrency(currService.findById(currencyId));
			loan.setLoanType(loanTypeService.findById(typeId));
			loan.setLoanState(loanStateService.findById(stateId));
			loan.setCreditOrder(orderService.findById(creditOrderId));
			loan.setParentLoan(loanService.findById(loan.getId()).getParentLoan());
			
			loggerLoan.info("updateLoan : {}", loan);
			
			loanService.update(loan);
		}
			
		return "redirect:" + "/manage/debtor/{debtorId}/view";
	}
	
	@RequestMapping(value="/manage/debtor/{debtorId}/loan/delete", method=RequestMethod.POST)
    public String deleteLoan(long id, @PathVariable("debtorId")Long debtorId) {
		if(id > 0)
			loanService.deleteById(id);
		return "redirect:" + "/manage/debtor/{debtorId}/view";
    }
	
	@RequestMapping(value="/manage/debtor/{debtorId}/loan/state/save", method=RequestMethod.POST)
    public String saveLoanState(LoanState state, @PathVariable("debtorId")Long debtorId, ModelMap model) {
		if(state != null && state.getId() == 0)
			loanStateService.save(new LoanState(state.getName()));
		
		if(state != null && state.getId() > 0)
			loanStateService.update(state);
		
		model.addAttribute("loggedinuser", Utils.getPrincipal());
        return "redirect:" + "/manage/debtor/{debtorId}/view";
    }
	
	@RequestMapping(value="/manage/debtor/{debtorId}/loan/type/save", method=RequestMethod.POST)
    public String saveLoanType(LoanType type, @PathVariable("debtorId")Long debtorId, ModelMap model) {
		if(type != null && type.getId() == 0)
			loanTypeService.save(new LoanType(type.getName()));
		
		if(type != null && type.getId() > 0)
			loanTypeService.update(type);
		
		model.addAttribute("loggedinuser", Utils.getPrincipal());
		return "redirect:" + "/manage/debtor/{debtorId}/view";
    }
	
	@RequestMapping(value="/manage/debtor/{debtorId}/loan/state/delete", method=RequestMethod.POST)
    public String deleteLoanState(long id, @PathVariable("debtorId")Long debtorId) {
		if(id > 0)
			loanStateService.deleteById(id);
		return "redirect:" + "/manage/debtor/{debtorId}/view";
    }
	
	@RequestMapping(value="/manage/debtor/{debtorId}/loan/type/delete", method=RequestMethod.POST)
    public String deleteLoanType(long id, @PathVariable("debtorId")Long debtorId) {
		if(id > 0)
			loanTypeService.deleteById(id);
		return "redirect:" + "/manage/debtor/{debtorId}/view";
    }

}