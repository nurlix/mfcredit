package kg.gov.mf.loan.manage.service;

import java.util.List;

import kg.gov.mf.loan.manage.model.AppliedEntityListState;

public interface AppliedEntityListStateService {

	AppliedEntityListState findById(long id);
	AppliedEntityListState findByName(String name);
	void save(AppliedEntityListState state);
	void update(AppliedEntityListState state);
	void deleteById(long id);
	List<AppliedEntityListState> findAll(); 
	boolean isStateNameUnique(long id, String name);
	
}
