package kg.gov.mf.loan.admin.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import kg.gov.mf.loan.admin.org.model.*;
import kg.gov.mf.loan.admin.org.service.*;

@Controller
public class BankDataController {
	
	@Autowired
    private BankDataService bankDataService;
     
    public void setBankDataService(BankDataService rs)
    {
        this.bankDataService = rs;
    }
    
    
	@Autowired
    private OrganizationService organizationService;
     
    public void setOrganizationService(OrganizationService rs)
    {
        this.organizationService = rs;
    }


    
	@RequestMapping(value = "/bankData/list", method = RequestMethod.GET)
	public String listBankDatas(Model model) {
		model.addAttribute("bankData", new BankData());
		model.addAttribute("bankDataList", this.bankDataService.findAll());

		return "admin/org/bankDataList";
	}
	
	
	@RequestMapping(value = "/bankData/table", method = RequestMethod.GET)
	public String showBankDataTable(Model model) {
		model.addAttribute("bankData", new BankData());
		model.addAttribute("bankDataList", this.bankDataService.findAll());

		return "admin/org/bankDataTable";
	}	
	
	@RequestMapping("/bankData/{id}/view")
	public String viewBankDataById(@PathVariable("id") long id, Model model) {

		BankData bankData = this.bankDataService.findById(id);

		model.addAttribute("bankData", bankData);

		return "admin/org/bankDataView";
	}
    
	
	@RequestMapping(value = "/bankData/add", method = RequestMethod.GET)
	public String getBankDataAddForm(Model model) {

		model.addAttribute("bankData", new BankData());

		return "admin/org/bankDataForm";
	}

	
	@RequestMapping(value = "/organization/{organizationId}/bankData/add", method = RequestMethod.GET)
	public String getBankDataAddFormWithOrganization(@PathVariable("organizationId") long organizationId,Model model) {

		BankData modelBankData = new BankData();
		
		modelBankData.setOrganization(this.organizationService.findById(organizationId));
		model.addAttribute("bankData",modelBankData);


		return "admin/org/bankDataForm";
	}	
	
	
	
	@RequestMapping("/bankData/{id}/edit")
	public String getBankDataEditForm(@PathVariable("id") long id, Model model) {
		model.addAttribute("bankData", this.bankDataService.findById(id));
		return "admin/org/bankDataForm";

	}

	@RequestMapping(value = "/bankData/save", method = RequestMethod.POST)
	public String saveBankDataAndRedirectToBankDataList(@Validated @ModelAttribute("bankData") BankData bankData, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println(" ==== BINDING ERROR ====" + result.getAllErrors().toString());
		} else if (bankData.getId() == 0) {
			this.bankDataService.create(bankData);
		} else {
			this.bankDataService.edit(bankData);
		}

		return "redirect:/organization/list";

	}

	@RequestMapping("/bankData/{id}/remove")
	public String removeBankDataAndRedirectToBankDataList(@PathVariable("id") long id) {

		this.bankDataService.deleteById(id);

		return "redirect:/organization/list";
	}

     

     

}
