package kg.gov.mf.loan.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kg.gov.mf.loan.manage.model.orderdocument.OrderDocument;
import kg.gov.mf.loan.manage.model.orderdocument.OrderDocumentType;
import kg.gov.mf.loan.manage.model.orderdocumentpackage.OrderDocumentPackage;
import kg.gov.mf.loan.manage.service.orderdocument.OrderDocumentService;
import kg.gov.mf.loan.manage.service.orderdocument.OrderDocumentTypeService;
import kg.gov.mf.loan.manage.service.orderdocumentpackage.OrderDocumentPackageService;
import kg.gov.mf.loan.util.Utils;

@Controller
public class OrderDocumentController {
	
	@Autowired
	OrderDocumentPackageService oDPService;
	
	@Autowired
	OrderDocumentTypeService oDTypeService;
	
	@Autowired
	OrderDocumentService odService;

	@RequestMapping(value="/manage/order/{orderId}/orderdocumentpackage/{oDPId}/orderdocument/save", method=RequestMethod.POST)
	public String saveOrderDocument(
			OrderDocument doc, 
			long typeId, 
			@PathVariable("orderId")Long orderId, 
			@PathVariable("oDPId")Long oDPId, 
			ModelMap model)
	{
		OrderDocumentPackage oDP = oDPService.findById(oDPId);
		
		if(doc != null && doc.getId() == 0)
		{
			OrderDocument newOD = new OrderDocument(doc.getName(), oDTypeService.findById(typeId));
			newOD.setOrderDocumentPackage(oDP);
			odService.save(newOD);
		}
			
		if(doc != null && doc.getId() > 0)
		{
			doc.setOrderDocumentType(oDTypeService.findById(typeId));
			odService.update(doc);
		}
			
			return "redirect:" + "/manage/order/{orderId}/orderdocumentpackage/{oDPId}/view";
	}
	
	@RequestMapping(value="/manage/order/{orderId}/orderdocumentpackage/{oDPId}/orderdocument/delete", method=RequestMethod.POST)
    public String deleteOrderDocument(long id, @PathVariable("orderId")Long orderId, @PathVariable("oDPId")Long oDPId) {
		if(id > 0)
			odService.deleteById(id);
		return "redirect:" + "/manage/order/{orderId}/orderdocumentpackage/{oDPId}/view";
    }
	
	@RequestMapping(value="/manage/order/{orderId}/orderdocumentpackage/{oDPId}/orderdocument/type/save", method=RequestMethod.POST)
    public String saveOrderDocumentType(OrderDocumentType type, @PathVariable("orderId")Long orderId, @PathVariable("oDPId")Long oDPId, ModelMap model) {
		if(type != null && type.getId() == 0)
			oDTypeService.save(new OrderDocumentType(type.getName()));
		
		if(type != null && type.getId() > 0)
			oDTypeService.update(type);
		
		model.addAttribute("loggedinuser", Utils.getPrincipal());
        return "redirect:" + "/manage/order/{orderId}/orderdocumentpackage/{oDPId}/view";
    }
	
	@RequestMapping(value="/manage/order/{orderId}/orderdocumentpackage/{oDPId}/orderdocument/type/delete", method=RequestMethod.POST)
    public String deleteOrderDocumentType(long id, @PathVariable("orderId")Long orderId, @PathVariable("oDPId")Long oDPId) {
		if(id > 0)
			oDTypeService.deleteById(id);
		return "redirect:" + "/manage/order/{orderId}/orderdocumentpackage/{oDPId}/view";
    }
	
}
