package kg.gov.mf.loan.admin.org.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import kg.gov.mf.loan.admin.org.model.Village;
import kg.gov.mf.loan.admin.org.service.VillageService;
 
@Component
public class VillageConverter implements Converter<String, Village>{
 
    @Autowired
    VillageService villageService;
 
    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public Village convert(String element) 
    {
        Integer id = Integer.parseInt((String)element);
        Village village = villageService.findById((long)id);
        return village;
    }
     
}