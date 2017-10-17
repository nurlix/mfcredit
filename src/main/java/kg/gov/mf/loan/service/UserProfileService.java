package kg.gov.mf.loan.service;

import java.util.List;

import kg.gov.mf.loan.model.UserProfile;

public interface UserProfileService {

	UserProfile findById(int id);
	UserProfile findByType(String type);
	List<UserProfile> findAll();
	
}
