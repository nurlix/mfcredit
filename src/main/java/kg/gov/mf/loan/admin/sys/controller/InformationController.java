package kg.gov.mf.loan.admin.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kg.gov.mf.loan.admin.org.model.District;
import kg.gov.mf.loan.admin.sys.model.*;
import kg.gov.mf.loan.admin.sys.service.*;

@Controller
public class InformationController {
	
	@Autowired
    private InformationService informationService;
	
    public void setInformationService(InformationService rs)
    {
        this.informationService = rs;
    }

    
	@Autowired
    private cSystemService cSystemService;
	
    public void setSystemObjectTypeService(cSystemService rs)
    {
        this.cSystemService = rs;
    }
    
    
	@RequestMapping(value = "/information/list", method = RequestMethod.GET)
	public String listInformations(Model model) {
		
		model.addAttribute("information", new Information());
		model.addAttribute("informationList", this.informationService.findAll());
		return "admin/sys/informationList";
	}
	
	
	@RequestMapping(value = "/information/table", method = RequestMethod.GET)
	public String showInformationTable(Model model) {
		model.addAttribute("information", new Information());
		model.addAttribute("informationList", this.informationService.findAll());

		return "admin/sys/informationTable";
	}	
	
	@RequestMapping("/information/{id}/view")
	public String viewInformationById(@PathVariable("id") long id, Model model) {

		Information information = this.informationService.findById(id);

		model.addAttribute("information", information);


		return "admin/sys/informationView";
	}
    
	
	@RequestMapping("/information/{id}/details")
	public String viewInformationDetailsById(@PathVariable("id") long id, Model model) {

		Information information = this.informationService.findById(id);

		model.addAttribute("information", information);


		return "admin/sys/informationDetails";
	}
	
	
	
	@RequestMapping(value = "/information/add", method = RequestMethod.GET)
	public String getInformationAddForm(Model model) {

		model.addAttribute("information", new Information());
		model.addAttribute("informationList", this.informationService.findAll());		

		
		return "admin/sys/informationForm";
	}
	
	@RequestMapping(value = "/information/{informationId}/information/add", method = RequestMethod.GET)
	public String getInformationAddFormWithParentInformation(@PathVariable("informationId") long informationId,Model model) {

		Information modelInformation = new Information();
		
		modelInformation.setParentInformation(this.informationService.findById(informationId));
		modelInformation.setSystemObjectId(this.informationService.findById(informationId).getSystemObjectId());
		modelInformation.setSystemObjectTypeId(this.informationService.findById(informationId).getSystemObjectTypeId());
		
		model.addAttribute("information",modelInformation);

		return "admin/sys/informationForm";
	}
	
	
	@RequestMapping(value = "/{systemObjectTypeId}/{systemObjectId}/information/add", method = RequestMethod.GET)
	public String getInformationAddFormWithSystemObjectType(@PathVariable("systemObjectTypeId") long systemObjectTypeId,@PathVariable("systemObjectId") long systemObjectId,Model model) {

		Information modelInformation = new Information();
		
		modelInformation.setSystemObjectTypeId(systemObjectTypeId);
		modelInformation.setSystemObjectId(systemObjectId);
		modelInformation.setParentInformation(null);
		
		model.addAttribute("information",modelInformation);

		return "admin/sys/informationForm";
	}	
	
	

	@RequestMapping("/information/{id}/edit")
	public String getInformationEditForm(@PathVariable("id") long id, Model model) {
		model.addAttribute("information", this.informationService.findById(id));
		model.addAttribute("informationList", this.informationService.findAll());		
	
		
		return "admin/sys/informationForm";

	}

	@RequestMapping(value = "/information/{informationId}/information/save", method = RequestMethod.POST)
	public String saveInformationAndRedirectToInformationList(@Validated @ModelAttribute("information") Information information, @PathVariable("informationId") long informationId, BindingResult result) {

		
		if (result.hasErrors()) 
		{
			System.out.println(" ==== BINDING ERROR ====" + result.getAllErrors().toString());
		} 
		else if (information.getId() == 0) 
		{
			if(information.getParentInformation().getName()==null)
			{
				information.setParentInformation(this.informationService.findById(informationId));
			}
			
			this.informationService.create(information);
		} 
		else 
		{
			this.informationService.edit(information);
		}

		return "redirect:/information/list";

	}
	
	
	@RequestMapping(value = "/information/save", method = RequestMethod.POST)
	public String saveInformation(@Validated @ModelAttribute("information") Information information, BindingResult result) {


		
		if (result.hasErrors()) 
		{
			System.out.println(" ==== BINDING ERROR ====" + result.getAllErrors().toString());
		} 
		else if (information.getId() == 0) 
		{
			if(information.getParentInformation().getId()==0)
			{
				information.setParentInformation(null);
			}
			else
			{
				information.setParentInformation(this.informationService.findById(information.getParentInformation().getId()));
			}
			
			this.informationService.create(information);
		} 
		else 
		{
			this.informationService.edit(information);
		}

		return "redirect:/information/list";

	}

	@RequestMapping("/information/{id}/remove")
	public String removeInformationAndRedirectToInformationList(@PathVariable("id") long id) {

		this.informationService.deleteById(id);

		return "redirect:/information/list";
	}

     

     

}
