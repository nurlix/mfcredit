package kg.gov.mf.loan.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kg.gov.mf.loan.manage.model.order.CreditOrder;
import kg.gov.mf.loan.manage.model.orderdocument.OrderDocument;
import kg.gov.mf.loan.manage.model.orderdocument.OrderDocumentType;
import kg.gov.mf.loan.manage.model.orderdocumentpackage.OrderDocumentPackage;
import kg.gov.mf.loan.manage.service.order.CreditOrderService;
import kg.gov.mf.loan.manage.service.orderdocument.OrderDocumentTypeService;
import kg.gov.mf.loan.manage.service.orderdocumentpackage.OrderDocumentPackageService;
import kg.gov.mf.loan.util.Utils;

@Controller
public class OrderDocumentPackageController {
	
	@Autowired
	CreditOrderService orderService;
	
	@Autowired
	OrderDocumentPackageService oDPService;
	
	@Autowired
	OrderDocumentTypeService typeService;
	
	@RequestMapping(value = { "/manage/order/{orderId}/orderdocumentpackage/{oDPId}/view"})
    public String viewOrderDocumentPackage(ModelMap model, @PathVariable("orderId")Long orderId, @PathVariable("oDPId")Long oDPId) {

		OrderDocumentPackage oDP = oDPService.findById(oDPId);
        model.addAttribute("oDP", oDP);
        
        List<OrderDocumentType> types = typeService.findAll();
        model.addAttribute("types", types);
        model.addAttribute("emptyType", new OrderDocumentType());
        
        model.addAttribute("emptyDocument", new OrderDocument());
        model.addAttribute("documents", oDP.getOrderDocument());
        
        model.addAttribute("orderId", orderId);
        
        model.addAttribute("loggedinuser", Utils.getPrincipal());
        return "/manage/order/orderdocumentpackage/view";
    }
	
	@RequestMapping(value="/manage/order/{orderId}/orderdocumentpackage/save", method=RequestMethod.POST)
	public String saveOrderDocumentPackage(OrderDocumentPackage oDP, 
			@PathVariable("orderId")Long orderId, ModelMap model)
	{
		CreditOrder creditOrder = orderService.findById(orderId);
		if(oDP != null && oDP.getId() == 0)
		{
			OrderDocumentPackage newODP = new OrderDocumentPackage(oDP.getName());
			newODP.setCreditOrder(creditOrder);
			oDPService.save(newODP);
		}
			
		
		if(oDP != null && oDP.getId() > 0)
		{
			oDPService.update(oDP);
		}
			
		return "redirect:" + "/manage/order/{orderId}/view#tab_1";
	}
	
	@RequestMapping(value="/manage/order/{orderId}/orderdocumentpackage/delete", method=RequestMethod.POST)
    public String deleteOrderDocumentPackage(long id, @PathVariable("orderId")Long orderId) {
		if(id > 0)
			oDPService.deleteById(id);
		return "redirect:" + "/manage/order/{orderId}/view#tab_1";
    }

}
