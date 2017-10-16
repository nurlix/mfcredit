package kg.gov.mf.loan.manage.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import kg.gov.mf.loan.manage.model.AppliedEntityList;
import kg.gov.mf.loan.manage.model.AppliedEntityListState;
import kg.gov.mf.loan.manage.model.AppliedEntityListType;
import kg.gov.mf.loan.manage.model.CreditOrder;
import kg.gov.mf.loan.manage.model.CreditOrderState;
import kg.gov.mf.loan.manage.model.CreditOrderType;
import kg.gov.mf.loan.manage.service.AppliedEntityListStateService;
import kg.gov.mf.loan.manage.service.AppliedEntityListTypeService;
import kg.gov.mf.loan.manage.service.CreditOrderService;
import kg.gov.mf.loan.manage.service.CreditOrderStateService;
import kg.gov.mf.loan.manage.service.CreditOrderTypeService;
import kg.gov.mf.loan.util.Utils;

@Controller
@SessionAttributes("roles")
public class CreditOrderController {
	
	@Autowired
	CreditOrderStateService creditOrderStateService;
	
	@Autowired
	CreditOrderTypeService creditOrderTypeService;
	
	@Autowired
	CreditOrderService creditOrderService;
	
	static final Logger loggerOrder = LoggerFactory.getLogger(CreditOrder.class);
	
	@Autowired
	AppliedEntityListStateService elStateService;
	
	@Autowired
	AppliedEntityListTypeService elTypeService;
	
	static final Logger loggerEntityList = LoggerFactory.getLogger(AppliedEntityList.class);
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(value = { "/manage/order/{orderId}/view"})
    public String viewOrder(ModelMap model, @PathVariable("orderId")Long orderId) {

		CreditOrder order = creditOrderService.findById(orderId);
        model.addAttribute("order", order);
        
        List<AppliedEntityListState> states = elStateService.findAll();
        model.addAttribute("states", states);
		model.addAttribute("emptyState", new CreditOrderState());
		
		List<AppliedEntityListType> types = elTypeService.findAll();
        model.addAttribute("types", types);
        model.addAttribute("emptyType", new CreditOrderType());
        
        model.addAttribute("emptyList", new AppliedEntityList());
        model.addAttribute("entityList", order.getAppliedEntityList());
        
        model.addAttribute("loggedinuser", Utils.getPrincipal());
        return "/manage/order/view";
    }
	
	@RequestMapping(value = { "/manage/order/", "/manage/order/list" }, method = RequestMethod.GET)
    public String listOrders(ModelMap model) {
 
		List<CreditOrderState> states = creditOrderStateService.findAll();
		model.addAttribute("states", states);
		model.addAttribute("emptyState", new CreditOrderState());
		
        List<CreditOrderType> types = creditOrderTypeService.findAll();
        model.addAttribute("types", types);
        model.addAttribute("emptyType", new CreditOrderType());
        
        List<CreditOrder> orders = creditOrderService.findAll();
        model.addAttribute("orders", orders);
        model.addAttribute("emptyOrder", new CreditOrder());
        
        model.addAttribute("loggedinuser", Utils.getPrincipal());
        return "/manage/order/list";
    }
	
	@RequestMapping(value="/manage/order/save", method=RequestMethod.POST)
	public String saveCreditOrder(CreditOrder creditOrder, long stateId, long typeId)
	{
		loggerOrder.info("Order : {}", creditOrder);
		if(creditOrder != null && creditOrder.getId() == 0)
		{
			CreditOrder newOrder = new CreditOrder(creditOrder.getRegNumber(), creditOrder.getRegDate(), 
					creditOrder.getDescription(), creditOrderStateService.findById(stateId), creditOrderTypeService.findById(typeId));
			creditOrderService.save(newOrder);
		}
			
		
		if(creditOrder != null && creditOrder.getId() > 0)
			creditOrder.setCreditOrderState(creditOrderStateService.findById(stateId));
			creditOrder.setCreditOrderType(creditOrderTypeService.findById(typeId));
			creditOrderService.update(creditOrder);
		
		return "redirect:" + "/manage/order/list";
	}
	
	@RequestMapping(value="/manage/order/delete", method=RequestMethod.POST)
    public String deleteCreditOrder(long id) {
		if(id > 0)
			creditOrderService.deleteById(id);
        return "redirect:" + "/manage/order/list";
    }
	
	@RequestMapping(value="/manage/order/state/save", method=RequestMethod.POST)
    public String saveCreditOrderState(CreditOrderState state, ModelMap model) {
		if(state != null && state.getId() == 0)
			creditOrderStateService.save(new CreditOrderState(state.getName()));
		
		if(state != null && state.getId() > 0)
			creditOrderStateService.update(state);
		
		model.addAttribute("loggedinuser", Utils.getPrincipal());
        return "redirect:" + "/manage/order/list";
    }
	
	@RequestMapping(value="/manage/order/type/save", method=RequestMethod.POST)
    public String saveCreditOrderType(CreditOrderType type,  ModelMap model) {
		if(type != null && type.getId() == 0)
			creditOrderTypeService.save(new CreditOrderType(type.getName()));
		
		if(type != null && type.getId() > 0)
			creditOrderTypeService.update(type);
		
		model.addAttribute("loggedinuser", Utils.getPrincipal());
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
}
