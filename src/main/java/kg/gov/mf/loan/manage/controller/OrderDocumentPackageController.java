package kg.gov.mf.loan.manage.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kg.gov.mf.loan.manage.model.documentpackage.DocumentPackage;
import kg.gov.mf.loan.manage.model.documentpackage.DocumentPackageState;
import kg.gov.mf.loan.manage.model.documentpackage.DocumentPackageType;
import kg.gov.mf.loan.manage.model.entity.AppliedEntity;
import kg.gov.mf.loan.manage.model.entitylist.AppliedEntityList;
import kg.gov.mf.loan.manage.model.order.CreditOrder;
import kg.gov.mf.loan.manage.model.orderdocument.OrderDocument;
import kg.gov.mf.loan.manage.model.orderdocument.OrderDocumentType;
import kg.gov.mf.loan.manage.model.orderdocumentpackage.OrderDocumentPackage;
import kg.gov.mf.loan.manage.service.documentpackage.DocumentPackageService;
import kg.gov.mf.loan.manage.service.documentpackage.DocumentPackageStateService;
import kg.gov.mf.loan.manage.service.documentpackage.DocumentPackageTypeService;
import kg.gov.mf.loan.manage.service.order.CreditOrderService;
import kg.gov.mf.loan.manage.service.orderdocument.OrderDocumentTypeService;
import kg.gov.mf.loan.manage.service.orderdocumentpackage.OrderDocumentPackageService;
import kg.gov.mf.loan.manage.util.Utils;

@Controller
public class OrderDocumentPackageController {
	
	@Autowired
	CreditOrderService orderService;
	
	@Autowired
	OrderDocumentPackageService oDPService;
	
	@Autowired
	OrderDocumentTypeService typeService;
	
	@Autowired
	DocumentPackageService dpService;
	
	@Autowired
	DocumentPackageStateService dpStateService;
	
	@Autowired
	DocumentPackageTypeService dpTypeService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
	    binder.registerCustomEditor(Date.class, editor);
	}
	
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
			
			//add this document package to all entities under this credit
			//addToEntities(creditOrder, oDP, newODP);
		}
			
		
		if(oDP != null && oDP.getId() > 0)
		{
			oDPService.update(oDP);
			//updateInEntities(creditOrder, oDP);
		}
			
		return "redirect:" + "/manage/order/{orderId}/view#tab_1";
	}
	
	@RequestMapping(value="/manage/order/{orderId}/orderdocumentpackage/delete", method=RequestMethod.POST)
    public String deleteOrderDocumentPackage(long id, @PathVariable("orderId")Long orderId) {
		if(id > 0) {
			oDPService.deleteById(id);
			//deleteInEntities(id);
		}
			
		return "redirect:" + "/manage/order/{orderId}/view#tab_1";
    }
	
	private void addToEntities(CreditOrder creditOrder, OrderDocumentPackage oDP, OrderDocumentPackage newODP) {
		Set<AppliedEntityList> lists = creditOrder.getAppliedEntityList();
		for (AppliedEntityList list : lists) {
			Set<AppliedEntity> entities = list.getAppliedEntity();
			for (AppliedEntity entity : entities) {
				DocumentPackage dp = new DocumentPackage(oDP.getName(), 
						new Date(0), 
						new Date(0), 
						0.0, 
						0.0, 
						0.0, 
						getDummyState(), 
						getDummyType());
				dp.setOrderDocumentPackageId(newODP.getId());
				dp.setAppliedEntity(entity);
				dpService.save(dp);
			}
		}
	}
	
	private void updateInEntities(CreditOrder creditOrder, OrderDocumentPackage oDP) {
		List<DocumentPackage> dps = dpService.findByOrderDocumentPackageId(oDP.getId());
		for (DocumentPackage documentPackage : dps) {
			documentPackage.setName(oDP.getName());
			dpService.update(documentPackage);
		}
	}
	
	private void deleteInEntities(long id) {
		List<DocumentPackage> dps = dpService.findByOrderDocumentPackageId(id);
		for (DocumentPackage documentPackage : dps) {
			dpService.deleteById(documentPackage.getId());
		}
	}
	
	private DocumentPackageState getDummyState() {
		DocumentPackageState result = dpStateService.findByName("Dummy State");
		if(result == null) {
			result = new DocumentPackageState("Dummy State");
			dpStateService.save(result);
		}
		
		return result;
	}
	
	private DocumentPackageType getDummyType() {
		DocumentPackageType result = dpTypeService.findByName("Dummy Type");
		if(result == null) {
			result = new DocumentPackageType("Dummy Type");
			dpTypeService.save(result);
		}
		
		return result;
	}
}
