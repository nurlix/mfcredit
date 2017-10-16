package kg.gov.mf.loan.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.manage.dao.AppliedEntityListStateDao;
import kg.gov.mf.loan.manage.model.AppliedEntityListState;

@Service("appliedEntityListStateService")
@Transactional
public class AppliedEntityListStateServiceImpl implements AppliedEntityListStateService {
	
	@Autowired
	private AppliedEntityListStateDao stateDao;

	@Override
	public AppliedEntityListState findById(long id) {
		return this.stateDao.findById(id);
	}

	@Override
	public AppliedEntityListState findByName(String name) {
		return this.stateDao.findByName(name);
	}

	@Override
	public void save(AppliedEntityListState state) {
		this.stateDao.save(state);
	}

	@Override
	public void update(AppliedEntityListState state) {
		AppliedEntityListState entity = this.stateDao.findById(state.getId());
        if(entity!=null){
            entity.setName(state.getName());
        }
	}

	@Override
	public void deleteById(long id) {
		this.stateDao.deleteById(id);
	}

	@Override
	public List<AppliedEntityListState> findAll() {
		return this.stateDao.findAll();
	}

	@Override
	public boolean isStateNameUnique(long id, String name) {
		AppliedEntityListState state = findById(id);
        return (state == null || ((id != 0L) && (state.getId() == id)));
	}

}
