package kg.gov.mf.loan.manage.dao;

import java.util.List;

import kg.gov.mf.loan.manage.model.AppliedEntityList;

public interface AppliedEntityListDao {
	
	List<AppliedEntityList> findAll();
	AppliedEntityList findById(long id);
	AppliedEntityList findByListNumber(String listNumber);
    void save(AppliedEntityList list);
    void deleteById(long id);

}
