package kg.gov.mf.loan.manage.service;

import java.util.List;

import kg.gov.mf.loan.manage.model.CreditOrderState;

public interface CreditOrderStateService {
	
	CreditOrderState findById(long id);
	CreditOrderState findByName(String name);
	void save(CreditOrderState state);
	void update(CreditOrderState state);
	void deleteById(long id);
	List<CreditOrderState> findAll(); 
	boolean isTypeNameUnique(long id, String name);

}
