package kg.gov.mf.loan.admin.sys.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.sys.model.*;
 
@Repository
public class SystemFileDaoImpl implements SystemFileDao {
     
    private static final Logger logger = LoggerFactory.getLogger(SystemFileDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public SystemFileDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(SystemFile systemFile) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(systemFile);
		
		logger.info("SystemFile added == "+systemFile);
		
	} 


	@Override
	public void edit(SystemFile systemFile) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(systemFile);
		
		logger.info("SystemFile edited == "+systemFile);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		SystemFile systemFile = (SystemFile) session.load(SystemFile.class, new Long (id));
		if(systemFile!=null)
		{
			session.delete(systemFile);
		}
		
		logger.info("SystemFile deleted == "+systemFile);
		
	}


	@Override
	public SystemFile findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		SystemFile systemFile = (SystemFile) session.load(SystemFile.class, new Long (id));
		
		logger.info("SystemFile get by id == "+systemFile);

		return systemFile ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<SystemFile> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<SystemFile> systemFilesList = session.createQuery("from SystemFile").list();
        return systemFilesList;
    }
    
}