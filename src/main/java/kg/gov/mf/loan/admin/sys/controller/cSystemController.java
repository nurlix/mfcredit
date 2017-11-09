package kg.gov.mf.loan.admin.sys.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import kg.gov.mf.loan.admin.sys.model.*;
import kg.gov.mf.loan.admin.sys.service.*;

@Controller
public class cSystemController {
	
	@Autowired
    private cSystemService cSystemService;
	
	public void setCSystemService(cSystemService rs)
    {
        this.cSystemService = rs;
    }

   
    
	@Autowired
    private InformationService informationService;
	
    public void setInformationService(InformationService rs)
    {
        this.informationService = rs;
    }

	@Autowired
    private ObjectTypeService objectTypeService;
	
    public void setObjectTypeService(ObjectTypeService rs)
    {
        this.objectTypeService = rs;
    }
    
	@Autowired
    private ObjectFieldService objectFieldService;
	
    public void setObjectFieldService(ObjectFieldService rs)
    {
        this.objectFieldService = rs;
    }
    

	@Autowired
    private ValidationTermService validationTermService;
	
    public void setValidationTermService(ValidationTermService rs)
    {
        this.validationTermService = rs;
    }
    
    
    
	@RequestMapping(value = "/cSystem/list", method = RequestMethod.GET)
	public String listCSystems(Model model) {
		
		
		model.addAttribute("openModal", "0");
		
		model.addAttribute("cSystem", new cSystem());
		model.addAttribute("cSystemList", this.cSystemService.findAll());
		return "admin/sys/cSystemList";
	}
	
	@RequestMapping("/cSystem/{id}/view")
	public String viewCSystemById(@PathVariable("id") long id, Model model) {

		cSystem cSystem = this.cSystemService.findById(id);
		
		model.addAttribute("cSystem", cSystem);
		model.addAttribute("informationList", this.informationService.findInformationBySystemObjectTypeIdAndSystemObjectId(1, cSystem.getId()));		

		return "admin/sys/cSystemView";
	}
	
	@RequestMapping("/cSystem/{id}/details")
	public String viewCSystemDetailsById(@PathVariable("id") long id, Model model) {

		cSystem cSystem = this.cSystemService.findById(id);
		
		model.addAttribute("cSystem", cSystem);
		model.addAttribute("informationList", this.informationService.findAll());		

		return "admin/sys/cSystemDetails";
	}	
    
	
	@RequestMapping(value = "/cSystem/add", method = RequestMethod.GET)
	public String getCSystemAddForm(Model model) {

		model.addAttribute("cSystem", new cSystem());
		model.addAttribute("cSystemList", this.cSystemService.findAll());		

		return "admin/sys/cSystemForm";
	}
	
	@RequestMapping("/cSystem/{id}/edit")
	public String getCSystemEditForm(@PathVariable("id") long id, Model model) {
		
		model.addAttribute("cSystem", this.cSystemService.findById(id));
		model.addAttribute("cSystemList", this.cSystemService.findAll());		
		
		return "admin/sys/cSystemForm";
	}

	@RequestMapping(value = "/cSystem/save", method = RequestMethod.POST)
	public String saveCSystemAndRedirectToCSystemList(@Validated @ModelAttribute("cSystem") cSystem cSystem, BindingResult result, Model model) {

		
		
		Set<ObjectField> objectTypeFieldList = new HashSet<ObjectField>();
		
		objectTypeFieldList = this.objectTypeService.findByCode(cSystem.getClass().getSimpleName()).getObjectField();
		
		for (ObjectField objectField : objectTypeFieldList) {
			
			
			for (ValidationTerm validationTerm : objectField.getValidationTerm()) {
			
				
				String sMethodName = "get"+objectField.getName().substring(0, 1).toUpperCase()+objectField.getName().substring(1, objectField.getName().length());
				
				Class objectClass = cSystem.getClass();
				
				
				try 
				{
					
					String objectToBeValidated = (cSystem.getClass().getMethod(sMethodName, null).invoke(cSystem)).toString();
					
					System.out.println(objectToBeValidated);
					
					if(validationTerm.getMax_length() >0)
					{
						if(objectToBeValidated.length()>validationTerm.getMax_length()) 
						{
							result.rejectValue(objectField.getName(), "error.cSystem.name.maxlength", "name must be < "+validationTerm.getMax_length());
						}
					}
					
					if(validationTerm.getMin_length() >0)
					{
						if(objectToBeValidated.length()<validationTerm.getMin_length()) 
						{
							result.rejectValue(objectField.getName(), "error.cSystem.name.mminlength", "name must be > "+validationTerm.getMin_length());
						}
					}
					
					
				} 
				catch 
				(	IllegalAccessException | 
					IllegalArgumentException | 
					InvocationTargetException | 
					NoSuchMethodException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				

			}
			
			
		}
		
		
		
		

		
		if (result.hasErrors()) {
			System.out.println(" ==== BINDING ERROR ====" + result.getAllErrors().toString());
			
//			model.addAttribute("error", result);	
			
			model.addAttribute("openModal", "1");
			
			model.addAttribute("cSystemList", this.cSystemService.findAll());
			
			return "admin/sys/cSystemList";
			
			
			
			
			
			
			
			
		} else if (cSystem.getId() == 0) {
			this.cSystemService.create(cSystem);
		} else {
			this.cSystemService.edit(cSystem);
		}

		return "redirect:/cSystem/list";

	}

	@RequestMapping("/cSystem/{id}/remove")
	public String removeCSystemAndRedirectToCSystemList(@PathVariable("id") long id) {

		this.cSystemService.deleteById(id);

		return "redirect:/cSystem/list";
	}

     

     

}
