package kg.gov.mf.loan.manage.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kg.gov.mf.loan.manage.model.debtor.Debtor;
import kg.gov.mf.loan.manage.model.debtor.DebtorType;
import kg.gov.mf.loan.manage.model.debtor.OrganizationForm;
import kg.gov.mf.loan.manage.model.debtor.WorkSector;
import kg.gov.mf.loan.manage.service.debtor.DebtorService;
import kg.gov.mf.loan.manage.service.debtor.DebtorTypeService;
import kg.gov.mf.loan.manage.service.debtor.OrganizationFormService;
import kg.gov.mf.loan.manage.service.debtor.WorkSectorService;
import kg.gov.mf.loan.manage.util.Utils;

@Controller
public class DebtorController {
	
	@Autowired
	DebtorTypeService typeService;
	
	@Autowired
	OrganizationFormService formService;
	
	@Autowired
	WorkSectorService sectorService;

	@Autowired
	DebtorService debtorService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(value = { "/manage/debtor/", "/manage/debtor/list" }, method = RequestMethod.GET)
    public String listDebtors(ModelMap model) {
 
		List<DebtorType> types = typeService.findAll();
		model.addAttribute("types", types);
		model.addAttribute("emptyType", new DebtorType());
		
		List<OrganizationForm> forms = formService.findAll();
		model.addAttribute("forms", forms);
		model.addAttribute("emptyForm", new OrganizationForm());
		
		List<WorkSector> sectors = sectorService.findAll();
		model.addAttribute("sectors", sectors);
		model.addAttribute("emptySector", new WorkSector());
		
        List<Debtor> debtors = debtorService.findAll();
        model.addAttribute("debtors", debtors);
        model.addAttribute("emptyDebtor", new Debtor());
        
        model.addAttribute("loggedinuser", Utils.getPrincipal());
        return "/manage/debtor/list";
    }
	
	@RequestMapping(value="/manage/debtor/save", method=RequestMethod.POST)
	public String saveDebtor(Debtor debtor, long typeId, long orgFormId, long workSectorId)
	{
		if(debtor != null && debtor.getId() == 0)
		{
			Debtor newDebtor = new Debtor(debtor.getName(), typeService.findById(typeId), formService.findById(orgFormId), sectorService.findById(workSectorId));
			debtorService.save(newDebtor);
		}
			
		
		if(debtor != null && debtor.getId() > 0)
		{
			debtor.setDebtorType(typeService.findById(typeId));
			debtor.setOrgForm(formService.findById(orgFormId));
			debtor.setWorkSector(sectorService.findById(workSectorId));
			debtorService.update(debtor);
		}
			
		return "redirect:" + "/manage/debtor/list";
	}
	
	@RequestMapping(value="/manage/debtor/delete", method=RequestMethod.POST)
    public String deleteDebtor(long id) {
		if(id > 0)
			debtorService.deleteById(id);
        return "redirect:" + "/manage/debtor/list";
    }
	
	@RequestMapping(value="/manage/debtor/type/save", method=RequestMethod.POST)
    public String saveDebtorType(DebtorType type,  ModelMap model) {
		if(type != null && type.getId() == 0)
			typeService.save(new DebtorType(type.getName()));
		
		if(type != null && type.getId() > 0)
			typeService.update(type);
		
		model.addAttribute("loggedinuser", Utils.getPrincipal());
        return "redirect:" + "/manage/debtor/list";
    }
	
	@RequestMapping(value="/manage/debtor/type/delete", method=RequestMethod.POST)
    public String deleteDebtorType(long id) {
		if(id > 0)
			typeService.deleteById(id);
        return "redirect:" + "/manage/debtor/list";
    }
	
	@RequestMapping(value="/manage/debtor/orgform/save", method=RequestMethod.POST)
    public String saveOrgForm(OrganizationForm form,  ModelMap model) {
		if(form != null && form.getId() == 0)
			formService.save(new OrganizationForm(form.getName()));
		
		if(form != null && form.getId() > 0)
			formService.update(form);
		
		model.addAttribute("loggedinuser", Utils.getPrincipal());
        return "redirect:" + "/manage/debtor/list";
    }
	
	@RequestMapping(value="/manage/debtor/orgform/delete", method=RequestMethod.POST)
    public String deleteOgrForm(long id) {
		if(id > 0)
			formService.deleteById(id);
        return "redirect:" + "/manage/debtor/list";
    }
	
	@RequestMapping(value="/manage/debtor/worksector/save", method=RequestMethod.POST)
    public String saveWorkSector(WorkSector sector,  ModelMap model) {
		if(sector != null && sector.getId() == 0)
			sectorService.save(new WorkSector(sector.getName()));
		
		if(sector != null && sector.getId() > 0)
			sectorService.update(sector);
		
		model.addAttribute("loggedinuser", Utils.getPrincipal());
        return "redirect:" + "/manage/debtor/list";
    }
	
	@RequestMapping(value="/manage/debtor/worksector/delete", method=RequestMethod.POST)
    public String deleteWorkSector(long id) {
		if(id > 0)
			sectorService.deleteById(id);
        return "redirect:" + "/manage/debtor/list";
    }
	
}
