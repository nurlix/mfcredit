package kg.gov.mf.loan.admin.org.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import kg.gov.mf.loan.admin.org.model.Region;
import kg.gov.mf.loan.admin.org.service.RegionService;
 
@Component
public class RegionConverter implements Converter<String, Region>{
 
    @Autowired
    RegionService regionService;
 
    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public Region convert(String element) 
    {
        Integer id = Integer.parseInt((String)element);
        Region region = regionService.findById((long)id);
        return region;
    }
     
}