package kg.gov.mf.loan.admin.org.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import kg.gov.mf.loan.admin.org.model.OrgForm;
import kg.gov.mf.loan.admin.org.service.OrgFormService;
 
@Component
public class OrgFormConverter implements Converter<String, OrgForm>{
 
    @Autowired
    OrgFormService orgFormService;
 
    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public OrgForm convert(String element) 
    {
        Integer id = Integer.parseInt((String)element);
        OrgForm orgForm = orgFormService.findById((long)id);
        return orgForm;
    }
     
}