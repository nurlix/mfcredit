package kg.gov.mf.loan.manage.service.documentpackage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.manage.dao.documentpackage.DocumentPackageDao;
import kg.gov.mf.loan.manage.model.documentpackage.DocumentPackage;

@Service("documentPackageService")
@Transactional
public class DocumentPackageServiceImpl implements DocumentPackageService{
	
	@Autowired
	private DocumentPackageDao dpDao;

	@Override
	public DocumentPackage findById(long id) {
		return this.dpDao.findById(id);
	}

	@Override
	public void save(DocumentPackage dp) {
		this.dpDao.save(dp);
	}

	@Override
	public void update(DocumentPackage dp) {
		DocumentPackage entity = this.dpDao.findById(dp.getId());
        if(entity!=null){
        	entity.setCompletedDate(dp.getCompletedDate());
        	entity.setApprovedDate(dp.getApprovedDate());
        	entity.setCompletedRatio(dp.getCompletedRatio());
        	entity.setApprovedRatio(dp.getApprovedRatio());
        	entity.setRegisteredRatio(dp.getRegisteredRatio());
        	entity.setDocumentPackageState(dp.getDocumentPackageState());
        	entity.setDocumentPackageType(dp.getDocumentPackageType());
        }
	}

	@Override
	public void deleteById(long id) {
		this.dpDao.deleteById(id);
	}

	@Override
	public List<DocumentPackage> findAll() {
		return this.dpDao.findAll();
	}

}
