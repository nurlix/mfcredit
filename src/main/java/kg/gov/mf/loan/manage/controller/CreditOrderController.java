package kg.gov.mf.loan.manage.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import kg.gov.mf.loan.manage.model.CreditOrderState;
import kg.gov.mf.loan.manage.model.CreditOrderType;
import kg.gov.mf.loan.manage.service.CreditOrderStateService;
import kg.gov.mf.loan.manage.service.CreditOrderTypeService;

@Controller
@SessionAttributes("roles")
public class CreditOrderController {
	
	@Autowired
	CreditOrderStateService creditOrderStateService;
	
	@Autowired
	CreditOrderTypeService creditOrderTypeService;
	
	@RequestMapping(value = { "/manage/order/", "/manage/order/list" }, method = RequestMethod.GET)
    public String listOrders(ModelMap model) {
 
		List<CreditOrderState> states = creditOrderStateService.findAll();
		model.addAttribute("states", states);
		model.addAttribute("emptyState", new CreditOrderState());
		
        List<CreditOrderType> types = creditOrderTypeService.findAll();
        model.addAttribute("types", types);
        model.addAttribute("emptyType", new CreditOrderType());
        
        //TODO: Add orders
        
        model.addAttribute("loggedinuser", getPrincipal());
        return "/manage/order/list";
    }
	
	@RequestMapping(value="/manage/order/state/save", method=RequestMethod.POST)
    public String saveCreditOrderState(@Valid CreditOrderState state, BindingResult result, ModelMap model) {
		if(state != null && state.getId() == 0)
			creditOrderStateService.save(new CreditOrderState(state.getName()));
		
		if(state != null && state.getId() > 0)
			creditOrderStateService.update(state);
		
		model.addAttribute("loggedinuser", getPrincipal());
        return "redirect:" + "/manage/order/list";
    }
	
	@RequestMapping(value="/manage/order/type/save", method=RequestMethod.POST)
    public String saveCreditOrderType(CreditOrderType type) {
		if(type != null && type.getId() == 0)
			creditOrderTypeService.save(new CreditOrderType(type.getName()));
		
		if(type != null && type.getId() > 0)
			creditOrderTypeService.update(type);
        return "redirect:" + "/manage/order/list";
    }
	
	@RequestMapping(value="/manage/order/state/delete", method=RequestMethod.POST)
    public String deleteCreditOrderState(long id) {
		if(id > 0)
			creditOrderStateService.deleteById(id);
        return "redirect:" + "/manage/order/list";
    }
	
	@RequestMapping(value="/manage/order/type/delete", method=RequestMethod.POST)
    public String deleteCreditOrderType(long id) {
		if(id > 0)
			creditOrderTypeService.deleteById(id);
        return "redirect:" + "/manage/order/list";
    }
	
	/**
     * This method returns the principal[user-name] of logged-in user.
     */
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

}
