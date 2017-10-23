package kg.gov.mf.loan.admin.sys.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import kg.gov.mf.loan.admin.sys.model.Information;
import kg.gov.mf.loan.admin.sys.model.Role;
import kg.gov.mf.loan.admin.sys.service.RoleService;
 
@Component
public class RoleToStringConverter implements Converter<Role, String>{
 
    @Autowired
    RoleService roleService;
 
    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public String convert(Role role) 
    {
        String id = String.valueOf(role.getId());
        return id;
    }
    
     
}