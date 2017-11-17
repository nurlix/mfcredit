package kg.gov.mf.loan.manage.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kg.gov.mf.loan.manage.model.collateral.Collateral;
import kg.gov.mf.loan.manage.model.collateral.CollateralAgreement;
import kg.gov.mf.loan.manage.service.collateral.CollateralAgreementService;
import kg.gov.mf.loan.manage.service.collateral.CollateralService;

@Controller
public class CollateralAgreementController {
	
	@Autowired
	CollateralService collateralService;
	
	@Autowired
	CollateralAgreementService agreementService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(value = { "/manage/collateral/{collateralId}/agreement/save"})
    public String saveCollateralAgreement(CollateralAgreement agreement, @PathVariable("collateralId")Long collateralId,  ModelMap model)
    {
		Collateral collateral = collateralService.findById(collateralId);
		if(agreement != null && agreement.getId() == 0)
		{
			CollateralAgreement newAgreement = new CollateralAgreement(
					agreement.getAgreementNumber(), agreement.getAgreementDate(), agreement.getCollateralOfficeRegNumber(), 
					agreement.getCollateralOfficeRegDate(), agreement.getNotaryOfficeRegNumber(), agreement.getNotaryOfficeRegDate(), 
					agreement.getArrestRegNumber(), agreement.getArrestRegDate());
			newAgreement.setCollateral(collateral);
			agreementService.save(newAgreement);
		}
		
		if(agreement != null && agreement.getId() > 0)
		{
			agreementService.update(agreement);
		}
		
		return "redirect:" + "/manage/collateral/{collateralId}/view";
    }

	@RequestMapping(value = { "/manage/collateral/{collateralId}/agreement/delete"})
    public String deleteCollateralAgreement(long id, @PathVariable("collateralId")Long collateralId)
    {
		if(id > 0)
			agreementService.deleteById(id);
		
		return "redirect:" + "/manage/collateral/{collateralId}/view";
    }
	
}
