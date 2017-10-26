package kg.gov.mf.loan.admin.org.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;

@Repository
public interface EmploymentHistoryDao {

	public void create(EmploymentHistory employmentHistory);
	
	public void edit(EmploymentHistory employmentHistory);
	
	public void deleteById(long id);
	
	public EmploymentHistory findById (long id);
	
	public List<EmploymentHistory> findAll();

}
