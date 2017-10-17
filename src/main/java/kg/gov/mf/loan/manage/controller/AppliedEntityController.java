package kg.gov.mf.loan.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kg.gov.mf.loan.manage.model.entity.AppliedEntity;
import kg.gov.mf.loan.manage.model.entity.AppliedEntityState;
import kg.gov.mf.loan.manage.model.entitylist.AppliedEntityList;
import kg.gov.mf.loan.manage.service.entity.AppliedEntityService;
import kg.gov.mf.loan.manage.service.entity.AppliedEntityStateService;
import kg.gov.mf.loan.manage.service.entitylist.AppliedEntityListService;
import kg.gov.mf.loan.util.Utils;

@Controller
public class AppliedEntityController {
	
	@Autowired
	AppliedEntityStateService entityStateService;
	
	@Autowired
	AppliedEntityService entityService;
	
	@Autowired
	AppliedEntityListService listService;
	
	@RequestMapping(value="/manage/order/{orderId}/entitylist/{listId}/entity/save", method=RequestMethod.POST)
	public String saveAppliedEntityList(
			AppliedEntity entity, 
			long stateId, 
			@PathVariable("orderId")Long orderId, 
			@PathVariable("listId")Long listId, 
			ModelMap model)
	{
		AppliedEntityList list = listService.findById(listId);
		
		if(entity != null && entity.getId() == 0)
		{
			AppliedEntity newEntity = new AppliedEntity(entity.getName(), entityStateService.findById(stateId));
			newEntity.setAppliedEntityList(list);
			entityService.save(newEntity);
		}
			
		if(entity != null && entity.getId() > 0)
			entity.setAppliedEntityState(entityStateService.findById(stateId));
			entityService.update(entity);
		
			return "redirect:" + "/manage/order/{orderId}/entitylist/{listId}/view";
	}
	
	@RequestMapping(value="/manage/order/{orderId}/entitylist/{listId}/entity/delete", method=RequestMethod.POST)
    public String deleteAppliedEntityList(long id, @PathVariable("orderId")Long orderId, @PathVariable("listId")Long listId) {
		if(id > 0)
			entityService.deleteById(id);
		return "redirect:" + "/manage/order/{orderId}/entitylist/{listId}/view";
    }
	
	@RequestMapping(value="/manage/order/{orderId}/entitylist/{listId}/entity/state/save", method=RequestMethod.POST)
    public String saveAppliedEntityState(AppliedEntityState state, @PathVariable("orderId")Long orderId, @PathVariable("listId")Long listId, ModelMap model) {
		if(state != null && state.getId() == 0)
			entityStateService.save(new AppliedEntityState(state.getName()));
		
		if(state != null && state.getId() > 0)
			entityStateService.update(state);
		
		model.addAttribute("loggedinuser", Utils.getPrincipal());
        return "redirect:" + "/manage/order/{orderId}/entitylist/{listId}/view";
    }
	
	@RequestMapping(value="/manage/order/{orderId}/entitylist/{listId}/entity/state/delete", method=RequestMethod.POST)
    public String deleteAppliedEntityState(long id, @PathVariable("orderId")Long orderId, @PathVariable("listId")Long listId) {
		if(id > 0)
			entityStateService.deleteById(id);
		return "redirect:" + "/manage/order/{orderId}/entitylist/{listId}/view";
    }

}
