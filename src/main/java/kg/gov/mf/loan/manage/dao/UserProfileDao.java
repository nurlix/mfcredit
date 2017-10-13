package kg.gov.mf.loan.manage.dao;

import java.util.List;

import kg.gov.mf.loan.model.UserProfile;

public interface UserProfileDao {
	
	List<UserProfile> findAll();
    UserProfile findByType(String type);
    UserProfile findById(int id);
}
