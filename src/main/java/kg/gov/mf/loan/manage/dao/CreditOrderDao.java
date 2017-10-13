package kg.gov.mf.loan.manage.dao;

import java.util.List;

import kg.gov.mf.loan.manage.model.CreditOrder;

public interface CreditOrderDao {
	List<CreditOrder> findAll();
	CreditOrder findById(long id);
	CreditOrder findByRegNumber(String regNumber);
    void save(CreditOrder order);
    void deleteById(long id);
}
