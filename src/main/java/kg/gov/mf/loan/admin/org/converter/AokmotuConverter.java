package kg.gov.mf.loan.admin.org.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import kg.gov.mf.loan.admin.org.model.Aokmotu;
import kg.gov.mf.loan.admin.org.service.AokmotuService;
 
@Component
public class AokmotuConverter implements Converter<String, Aokmotu>{
 
    @Autowired
    AokmotuService aokmotuService;
 
    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public Aokmotu convert(String element) 
    {
        Integer id = Integer.parseInt((String)element);
        Aokmotu aokmotu = aokmotuService.findById((long)id);
        return aokmotu;
    }
     
}