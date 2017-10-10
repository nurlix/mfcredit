package kg.gov.mf.loan.manage.service;

import java.util.List;

import kg.gov.mf.loan.manage.model.CreditOrderType;

public interface CreditOrderTypeService {
	
	CreditOrderType findById(long id);
	CreditOrderType findByName(String name);
	void save(CreditOrderType type);
	void update(CreditOrderType type);
	void deleteById(long id);
	List<CreditOrderType> findAll(); 
	boolean isTypeNameUnique(long id, String name);

}
