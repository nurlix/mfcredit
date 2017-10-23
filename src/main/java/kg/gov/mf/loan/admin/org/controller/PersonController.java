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

import kg.gov.mf.loan.admin.sys.model.*;
import kg.gov.mf.loan.admin.sys.service.*;

@Controller
public class PersonController {
	
	@Autowired
    private PersonService personService;
	
    public void setPersonService(PersonService rs)
    {
        this.personService = rs;
    }

    
	@Autowired
    private AddressService addressService;
	
    public void setAddressService(AddressService rs)
    {
        this.addressService = rs;
    }
    
	@Autowired
    private RegionService regionService;
	
    public void setRegionService(RegionService rs)
    {
        this.regionService = rs;
    }    
    

	@Autowired
    private DistrictService districtService;
	
    public void setDistrictService(DistrictService ds)
    {
        this.districtService = ds;
    }    
    
    
	@Autowired
    private AokmotuService aokmotuService;
	
    public void setAokmotuService(AokmotuService ds)
    {
        this.aokmotuService = ds;
    }    
    
	@Autowired
    private VillageService villageService;
	
    public void setVillageService(VillageService ds)
    {
        this.villageService = ds;
    }
    
    
	@Autowired
    private IdentityDocTypeService identityDocTypeService;
	
    public void setIdentityDocTypeService(IdentityDocTypeService rs)
    {
        this.identityDocTypeService = rs;
    }
    
	@Autowired
    private IdentityDocService identityDocService;
	
    public void setIdentityDocService(IdentityDocService rs)
    {
        this.identityDocService = rs;
    }    
    
	@Autowired
    private IdentityDocGivenByService identityDocGivenByService;
	
    public void setIdentityDocGivenByService(IdentityDocGivenByService rs)
    {
        this.identityDocGivenByService = rs;
    }    
    
    
	@Autowired
    private OrgFormService orgFormService;
     
    public void setOrgFormService(OrgFormService rs)
    {
        this.orgFormService = rs;
    }    
    
    
	@Autowired
    private PositionService positionService;
     
    public void setPositionService(PositionService rs)
    {
        this.positionService = rs;
    }
    
    
    
	@Autowired
    private InformationService informationService;
	
    public void setInformationService(InformationService rs)
    {
        this.informationService = rs;
    } 
    
    
	@RequestMapping(value = "/person/list", method = RequestMethod.GET)
	public String listPersons(Model model) {
		
		model.addAttribute("person", new Person());
		model.addAttribute("personList", this.personService.findAll());
		return "admin/org/personList";
	}
	
	
	@RequestMapping(value = "/person/table", method = RequestMethod.GET)
	public String showPersonTable(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("personList", this.personService.findAll());

		return "admin/org/personTable";
	}	
	
	@RequestMapping("/person/{id}/view")
	public String viewPersonById(@PathVariable("id") long id, Model model) {

		Person person = this.personService.findById(id);

		model.addAttribute("person", person);
		model.addAttribute("positionList", this.positionService.findAll());
		model.addAttribute("informationList", this.informationService.findInformationBySystemObjectTypeIdAndSystemObjectId(2, person.getId()));		
		

		return "admin/org/personView";
	}
    
	
	@RequestMapping(value = "/person/add", method = RequestMethod.GET)
	public String getPersonAddForm(Model model) {

		
		Person modelPerson = new Person();
		
		Address modelAddress = new Address();
		modelAddress.setId(0);
		
		Region modelRegion = new Region();
		modelRegion.setId(1);

		District modelDistrict = new District();
		modelDistrict.setId(1);

		Aokmotu modelAokmotu = new Aokmotu();
		modelAokmotu.setId(1);
		
		Village modelVillage = new Village();
		modelVillage.setId(1);
		
		modelAddress.setRegion(modelRegion);
		modelAddress.setDistrict(modelDistrict);
		modelAddress.setAokmotu(modelAokmotu);
		modelAddress.setVillage(modelVillage);

		
		
		modelPerson.setAddress(modelAddress);

		IdentityDoc modelIdentityDoc = new IdentityDoc();
		modelIdentityDoc.setId(0);
		
		IdentityDocType modelIdentityDocType = new IdentityDocType();
		modelIdentityDocType.setId(1);
		modelIdentityDoc.setIdentityDocType(modelIdentityDocType);
		
		IdentityDocGivenBy modelIdentityDocGivenBy = new IdentityDocGivenBy();
		modelIdentityDocGivenBy.setId(1);
		modelIdentityDoc.setIdentityDocGivenBy(modelIdentityDocGivenBy);

		modelPerson.setIdentityDoc(modelIdentityDoc);
		

		
		model.addAttribute("person", modelPerson);
		
		model.addAttribute("regionList", this.regionService.findAll());
		model.addAttribute("districtList", this.districtService.findAll());			
		model.addAttribute("aokmotuList", this.aokmotuService.findAll());			
		model.addAttribute("villageList", this.villageService.findAll());	
		model.addAttribute("identityDocTypeList", this.identityDocTypeService.findAll());
		model.addAttribute("identityDocGivenByList", this.identityDocGivenByService.findAll());		
		model.addAttribute("orgFormList", this.orgFormService.findAll());
		
		return "admin/org/personForm";
	}
	
	

	@RequestMapping("/person/{id}/edit")
	public String getPersonEditForm(@PathVariable("id") long id, Model model) {
		model.addAttribute("person", this.personService.findById(id));
		model.addAttribute("regionList", this.regionService.findAll());
		model.addAttribute("districtList", this.districtService.findAll());			
		model.addAttribute("aokmotuList", this.aokmotuService.findAll());			
		model.addAttribute("villageList", this.villageService.findAll());
		model.addAttribute("identityDocTypeList", this.identityDocTypeService.findAll());
		model.addAttribute("identityDocGivenByList", this.identityDocGivenByService.findAll());		
		model.addAttribute("orgFormList", this.orgFormService.findAll());		
		
		return "admin/org/personForm";

	}

	@RequestMapping(value = "/person/save", method = RequestMethod.POST)
	public String savePersonAndRedirectToPersonList(@Validated @ModelAttribute("person") Person person, BindingResult result) {

		
		if (result.hasErrors()) {
			System.out.println(" ==== BINDING ERROR ====" + result.getAllErrors().toString());
		} else if (person.getId() == 0) {
			
//			person.setAddress(this.addressService.findById(person.getAddress().getId()));
//			person.setIdentityDoc(this.identityDocService.findById(person.getIdentityDoc().getId()));
			
			//person.setOrgForm(this.orgFormService.findById(person.getOrgForm().getId()));
			
			this.personService.create(person);
		} else {
			this.personService.edit(person);
		}

		return "redirect:/person/list";

	}

	@RequestMapping("/person/{id}/remove")
	public String removePersonAndRedirectToPersonList(@PathVariable("id") long id) {

		this.personService.deleteById(id);

		return "redirect:/person/list";
	}

     

     

}
