package kg.gov.mf.loan.manage.dao;

import java.util.List;

import kg.gov.mf.loan.manage.model.User;

public interface UserDao {

	User findById(int id);
    User findBySSO(String sso);
    void save(User user);
    void deleteBySSO(String sso);
    List<User> findAllUsers();
    
}