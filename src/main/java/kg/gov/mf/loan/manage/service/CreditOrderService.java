package kg.gov.mf.loan.manage.service;

import java.util.List;

import kg.gov.mf.loan.manage.model.CreditOrder;

public interface CreditOrderService {

	CreditOrder findById(long id);
	CreditOrder findByRegNumber(String regNumber);
	void save(CreditOrder order);
	void update(CreditOrder order);
	void deleteById(long id);
	List<CreditOrder> findAll();
	
}
