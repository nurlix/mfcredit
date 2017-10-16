package kg.gov.mf.loan.admin.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kg.gov.mf.loan.admin.org.model.*;
import kg.gov.mf.loan.admin.org.service.*;

@Controller
public class DistrictController {
	
	@Autowired
    private DistrictService districtService;
	
	@Autowired
    private RegionService regionService;	
     
    public void setDistrictService(DistrictService ds)
    {
        this.districtService = ds;
    }
    
    public void setRegionService(RegionService rs)
    {
        this.regionService = rs;
    }    
     
	@RequestMapping(value = "/district/list", method = RequestMethod.GET)
	public String listDistricts(Model model) {
		model.addAttribute("district", new District());
		model.addAttribute("districtList", this.districtService.findAll());

		return "admin/org/districtList";
	}
	
	
	@RequestMapping(value = "/district/table", method = RequestMethod.GET)
	public String showDistrictTable(Model model) {
		model.addAttribute("district", new District());
		model.addAttribute("districtList", this.districtService.findAll());

		return "admin/org/districtTable";
	}
	
	
	@RequestMapping("/district/{id}/view")
	public String viewDistrictById(@PathVariable("id") long id, Model model) {

		District district = this.districtService.findById(id);

		model.addAttribute("district", district);

		return "admin/org/districtView";
	}
	
	@RequestMapping("/district/{id}/details")
	public String viewDistrictDetailsById(@PathVariable("id") long id, Model model) {

		District district = this.districtService.findById(id);

		model.addAttribute("district", district);

		return "admin/org/districtDetails";
	}	
    
	
	@RequestMapping(value = "/region/{regionId}/district/add", method = RequestMethod.GET)
	public String getDistrictAddFormWithRegion(@PathVariable("regionId") long regionId,Model model) {

		District modelDistrict = new District();
		
		modelDistrict.setRegion(this.regionService.findById(regionId));
		model.addAttribute("regionList", this.regionService.findAll());		
		
		model.addAttribute("district",modelDistrict);

		return "admin/org/districtForm";
	}	

	
	@RequestMapping("/district/{id}/edit")
	public String getDistrictEditForm(@PathVariable("id") long id, Model model) {
		model.addAttribute("district", this.districtService.findById(id));
		model.addAttribute("regionList", this.regionService.findAll());
		
		return "admin/org/districtForm";

	}
	
	@RequestMapping(value = "/district/save", method = RequestMethod.POST)
	public ModelAndView saveDistrictAndRedirectToRegionDetails(@Validated @ModelAttribute("district") District district, BindingResult result,ModelMap model) {

		if (result.hasErrors()) {
			System.out.println(" ==== BINDING ERROR ====" + result.getAllErrors().toString());
		} else if (district.getId() == 0) {
			district.setRegion(this.regionService.findById(district.getRegion().getId()));
			this.districtService.create(district);
		} else {
			district.setRegion(this.regionService.findById(district.getRegion().getId()));
			this.districtService.edit(district);
		}

		String url = "/region/"+district.getRegion().getId()+"/details";

        return new ModelAndView("redirect:"+url, model);

	}	
	
	@RequestMapping("/district/{id}/remove")
	public String removeDistrictAndRedirectToDistrictList(@PathVariable("id") long id) {

		this.districtService.deleteById(id);

		return "redirect:/region/list";
	}

     

     

}
