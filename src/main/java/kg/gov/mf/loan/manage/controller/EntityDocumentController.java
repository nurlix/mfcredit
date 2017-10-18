package kg.gov.mf.loan.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kg.gov.mf.loan.manage.model.entitydocument.EntityDocumentRegisteredBy;
import kg.gov.mf.loan.manage.model.entitydocument.EntityDocumentState;
import kg.gov.mf.loan.manage.service.entitydocument.EntityDocumentRegisteredByService;
import kg.gov.mf.loan.manage.service.entitydocument.EntityDocumentStateService;
import kg.gov.mf.loan.util.Utils;

@Controller
public class EntityDocumentController {
	
	@Autowired
	EntityDocumentStateService edStateService;
	
	@Autowired
	EntityDocumentRegisteredByService edRBService;

	@RequestMapping(value="/manage/order/{orderId}/entitylist/{listId}/entity/{entityId}/documentpackage/{dpId}/entitydocument/state/save", method=RequestMethod.POST)
    public String saveEntityDocumentState(
    		EntityDocumentState state, 
    		@PathVariable("orderId")Long orderId, 
    		@PathVariable("listId")Long listId,
    		@PathVariable("entityId")Long entityId,
    		@PathVariable("dpId")Long dpId,
    		ModelMap model) {
		if(state != null && state.getId() == 0)
			edStateService.save(new EntityDocumentState(state.getName()));
		
		if(state != null && state.getId() > 0)
			edStateService.update(state);
		
		model.addAttribute("loggedinuser", Utils.getPrincipal());
        return "redirect:" + "/manage/order/{orderId}/entitylist/{listId}/entity/{entityId}/documentpackage/{dpId}/view";
    }
	
	@RequestMapping(value="/manage/order/{orderId}/entitylist/{listId}/entity/{entityId}/documentpackage/{dpId}/entitydocument/state/delete", method=RequestMethod.POST)
    public String deleteEntityDocumentState(
    		long id, 
    		@PathVariable("orderId")Long orderId, 
    		@PathVariable("listId")Long listId,
    		@PathVariable("entityId")Long entityId,
    		@PathVariable("dpId")Long dpId) {
		if(id > 0)
			edStateService.deleteById(id);
		return "redirect:" + "/manage/order/{orderId}/entitylist/{listId}/entity/{entityId}/documentpackage/{dpId}/view";
    }
	
	@RequestMapping(value="/manage/order/{orderId}/entitylist/{listId}/entity/{entityId}/documentpackage/{dpId}/entitydocument/registeredby/save", method=RequestMethod.POST)
    public String saveEntityDocumentRegisteredBy(
    		EntityDocumentRegisteredBy rb, 
    		@PathVariable("orderId")Long orderId, 
    		@PathVariable("listId")Long listId,
    		@PathVariable("entityId")Long entityId,
    		@PathVariable("dpId")Long dpId,
    		ModelMap model) {
		if(rb != null && rb.getId() == 0)
			edRBService.save(new EntityDocumentRegisteredBy(rb.getName()));
		
		if(rb != null && rb.getId() > 0)
			edRBService.update(rb);
		
		model.addAttribute("loggedinuser", Utils.getPrincipal());
        return "redirect:" + "/manage/order/{orderId}/entitylist/{listId}/entity/{entityId}/documentpackage/{dpId}/view";
    }
	
	@RequestMapping(value="/manage/order/{orderId}/entitylist/{listId}/entity/{entityId}/documentpackage/{dpId}/entitydocument/registeredby/delete", method=RequestMethod.POST)
    public String deleteEntityDocumentRegisteredBy(
    		long id, 
    		@PathVariable("orderId")Long orderId, 
    		@PathVariable("listId")Long listId,
    		@PathVariable("entityId")Long entityId,
    		@PathVariable("dpId")Long dpId) {
		if(id > 0)
			edRBService.deleteById(id);
		return "redirect:" + "/manage/order/{orderId}/entitylist/{listId}/entity/{entityId}/documentpackage/{dpId}/view";
    }
	
}
