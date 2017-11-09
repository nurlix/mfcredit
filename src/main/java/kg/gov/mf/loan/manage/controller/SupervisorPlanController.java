package kg.gov.mf.loan.manage.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kg.gov.mf.loan.manage.model.loan.Loan;
import kg.gov.mf.loan.manage.model.loan.SupervisorPlan;
import kg.gov.mf.loan.manage.service.loan.LoanService;
import kg.gov.mf.loan.manage.service.loan.SupervisorPlanService;

@Controller
public class SupervisorPlanController {
	
	@Autowired
	LoanService loanService;
	
	@Autowired
	SupervisorPlanService spService;

	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(value = { "/manage/debtor/{debtorId}/loan/{loanId}/sp/save"})
    public String saveSupervisorPlan(SupervisorPlan sp, @PathVariable("debtorId")Long debtorId, @PathVariable("loanId")Long loanId, ModelMap model)
    {
		Loan loan = loanService.findById(loanId);
		if(sp != null && sp.getId() == 0)
		{
			SupervisorPlan newSP = new SupervisorPlan(sp.getDate(), sp.getAmount(), sp.getPrincipal(), sp.getInterest(), sp.getPenalty(), sp.getFee(), sp.getDescription());
			newSP.setLoan(loan);
			spService.save(newSP);
		}
		
		if(sp != null && sp.getId() > 0)
		{
			spService.update(sp);
		}
		
		return "redirect:" + "/manage/debtor/{debtorId}/loan/{loanId}/view#tab_4";
    }
	
	@RequestMapping(value="/manage/debtor/{debtorId}/loan/{loanId}/sp/delete", method=RequestMethod.POST)
    public String deleteCreditTerm(long id, @PathVariable("debtorId")Long debtorId, @PathVariable("loanId")Long loanId) {
		if(id > 0)
			spService.deleteById(id);
		return "redirect:" + "/manage/debtor/{debtorId}/loan/{loanId}/view#tab_4";
    }
}
