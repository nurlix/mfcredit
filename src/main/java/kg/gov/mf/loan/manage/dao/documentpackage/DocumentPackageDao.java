package kg.gov.mf.loan.manage.dao.documentpackage;

import java.util.List;

import kg.gov.mf.loan.manage.model.documentpackage.DocumentPackage;

public interface DocumentPackageDao {

	List<DocumentPackage> findAll();
	DocumentPackage findById(long id);
    void save(DocumentPackage dp);
    void deleteById(long id);
	
}
