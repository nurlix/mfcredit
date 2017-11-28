package kg.gov.mf.loan.admin.org.converter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import kg.gov.mf.loan.admin.org.model.*;
import kg.gov.mf.loan.admin.org.service.*;
 
@Service
public class DistrictFormatter implements Formatter<District> {

    @Autowired
    DistrictService districtService;//Service -> DB

    @Override
    public String print(District object, Locale locale) {
    	
        return (object != null ? (String.valueOf(object.getId())) : "");
    }

	@Override
	public District parse(String text, Locale locale) throws ParseException {
		
		Integer id = Integer.valueOf(text);
		
        return this.districtService.findById(id);
		
		
	}
}