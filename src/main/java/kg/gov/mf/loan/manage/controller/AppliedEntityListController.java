package kg.gov.mf.loan.manage.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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

import kg.gov.mf.loan.manage.model.AppliedEntityList;
import kg.gov.mf.loan.manage.model.AppliedEntityListState;
import kg.gov.mf.loan.manage.model.AppliedEntityListType;
import kg.gov.mf.loan.manage.model.CreditOrder;
import kg.gov.mf.loan.manage.service.AppliedEntityListService;
import kg.gov.mf.loan.manage.service.AppliedEntityListStateService;
import kg.gov.mf.loan.manage.service.AppliedEntityListTypeService;
import kg.gov.mf.loan.manage.service.CreditOrderService;
import kg.gov.mf.loan.util.Utils;

@Controller
public class AppliedEntityListController {
	
	@Autowired
	AppliedEntityListService listService;

	@Autowired
	AppliedEntityListStateService elStateService;
	
	@Autowired
	AppliedEntityListTypeService elTypeService;
	
	@Autowired
	CreditOrderService orderService;
	
	static final Logger loggerEntityList = LoggerFactory.getLogger(AppliedEntityList.class);
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(value="/manage/order/{orderId}/entitylist/save", method=RequestMethod.POST)
	public String saveAppliedEntityList(AppliedEntityList list, long stateId, long typeId, 
			@PathVariable("orderId")Long orderId, ModelMap model)
	{
		CreditOrder creditOrder = orderService.findById(orderId);
		loggerEntityList.info("Entity List : {}", list);
		if(list != null && list.getId() == 0)
		{
			AppliedEntityList newList = new AppliedEntityList(list.getListNumber(), list.getListDate(), 
					elStateService.findById(stateId), elTypeService.findById(typeId));
			newList.setCreditOrder(creditOrder);
			listService.save(newList);
		}
			
		
		if(list != null && list.getId() > 0)
			list.setAppliedEntityListState(elStateService.findById(stateId));
			list.setAppliedEntityListType(elTypeService.findById(typeId));
			listService.update(list);
		
		return "redirect:" + "/manage/order/{orderId}/view";
	}
	
	@RequestMapping(value="/manage/order/{orderId}/entitylist/delete", method=RequestMethod.POST)
    public String deleteAppliedEntityList(long id, @PathVariable("orderId")Long orderId) {
		if(id > 0)
			listService.deleteById(id);
		return "redirect:" + "/manage/order/{orderId}/view";
    }
	
	@RequestMapping(value="/manage/order/{orderId}/entitylist/state/save", method=RequestMethod.POST)
    public String saveAppliedEntityListState(AppliedEntityListState state, @PathVariable("orderId")Long orderId, ModelMap model) {
		if(state != null && state.getId() == 0)
			elStateService.save(new AppliedEntityListState(state.getName()));
		
		if(state != null && state.getId() > 0)
			elStateService.update(state);
		
		model.addAttribute("loggedinuser", Utils.getPrincipal());
        return "redirect:" + "/manage/order/{orderId}/view";
    }
	
	@RequestMapping(value="/manage/order/{orderId}/entitylist/type/save", method=RequestMethod.POST)
    public String saveAppliedEntityListType(AppliedEntityListType type, @PathVariable("orderId")Long orderId, ModelMap model) {
		if(type != null && type.getId() == 0)
			elTypeService.save(new AppliedEntityListType(type.getName()));
		
		if(type != null && type.getId() > 0)
			elTypeService.update(type);
		
		model.addAttribute("loggedinuser", Utils.getPrincipal());
		return "redirect:" + "/manage/order/{orderId}/view";
    }
	
	@RequestMapping(value="/manage/order/{orderId}/entitylist/state/delete", method=RequestMethod.POST)
    public String deleteAppliedEntityListState(long id, @PathVariable("orderId")Long orderId) {
		if(id > 0)
			elStateService.deleteById(id);
		return "redirect:" + "/manage/order/{orderId}/view";
    }
	
	@RequestMapping(value="/manage/order/{orderId}/entitylist/type/delete", method=RequestMethod.POST)
    public String deleteAppliedEntityListType(long id, @PathVariable("orderId")Long orderId) {
		if(id > 0)
			elTypeService.deleteById(id);
		return "redirect:" + "/manage/order/{orderId}/view";
    }
	
}
