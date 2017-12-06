package kg.gov.mf.loan.manage.service.collateral;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.manage.dao.collateral.ConditionTypeDao;
import kg.gov.mf.loan.manage.model.collateral.ConditionType;

@Service("conditionTypeService")
@Transactional
public class ConditionTypeServiceImpl implements ConditionTypeService{
	
	@Autowired
	private ConditionTypeDao typeDao;

	@Override
	public ConditionType findById(long id) {
		return this.typeDao.findById(id);
	}

	@Override
	public ConditionType findByName(String name) {
		return this.typeDao.findByName(name);
	}

	@Override
	public void save(ConditionType type) {
		this.typeDao.save(type);
	}

	@Override
	public void update(ConditionType type) {
		ConditionType entity = this.typeDao.findById(type.getId());
        if(entity!=null){
            entity.setName(type.getName());
        }
	}

	@Override
	public void deleteById(long id) {
		this.typeDao.deleteById(id);
	}

	@Override
	public List<ConditionType> findAll() {
		return this.typeDao.findAll();
	}

}
