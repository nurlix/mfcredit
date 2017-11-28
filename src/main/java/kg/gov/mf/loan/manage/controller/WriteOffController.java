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
import kg.gov.mf.loan.manage.model.loan.WriteOff;
import kg.gov.mf.loan.manage.service.loan.LoanService;
import kg.gov.mf.loan.manage.service.loan.WriteOffService;

@Controller
public class WriteOffController {
	
	@Autowired
	LoanService loanService;
	
	@Autowired
	WriteOffService woService;

	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(value = { "/manage/debtor/{debtorId}/loan/{loanId}/wo/save"})
    public String saveWriteOff(WriteOff wo, @PathVariable("debtorId")Long debtorId, @PathVariable("loanId")Long loanId, ModelMap model)
    {
		Loan loan = loanService.findById(loanId);
		if(wo != null && wo.getId() == 0)
		{
			WriteOff newWO = new WriteOff(
					wo.getDate(), 
					wo.getTotalAmount(),
					wo.getPrincipal(),
					wo.getInterest(), 
					wo.getPenalty(),
					wo.getFee(), 
					wo.getDescription());
			newWO.setLoan(loan);
			woService.save(newWO);
		}
		
		if(wo != null && wo.getId() > 0)
		{
			woService.update(wo);
		}
		
		return "redirect:" + "/manage/debtor/{debtorId}/loan/{loanId}/view#tab_1";
    }
	
	@RequestMapping(value="/manage/debtor/{debtorId}/loan/{loanId}/wo/delete", method=RequestMethod.POST)
    public String deleteWriteOff(long id, @PathVariable("debtorId")Long debtorId, @PathVariable("loanId")Long loanId) {
		if(id > 0)
			woService.deleteById(id);
		return "redirect:" + "/manage/debtor/{debtorId}/loan/{loanId}/view#tab_1";
    }
	
}
