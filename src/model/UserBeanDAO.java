package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class UserBeanDAO implements UserBeanDAOInterface {

	private SessionFactory sessionFactory;

	@Autowired
	public UserBeanDAO(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean insertUser(UserBean insertThisUser) {
		// Create new Session
		System.out.println("BEGIN: UserBeanDAO.insertUser(UserBean insertThisUser)");
		Session session = sessionFactory.getCurrentSession();
		// Test if passed UserBean is not empty
		if (insertThisUser != null) {
			System.out.println("insertThisUser != null");
			// Insert the passed UserBean
			session.save(insertThisUser);
			System.out.println("UserBean Inserted:");
			System.out.println("userEmail: "+insertThisUser.getUserEmail());
			System.out.println("userPwd: "+insertThisUser.getUserPwd());
			System.out.println("FINISH: UserBeanDAO.insertUser(UserBean insertThisUser)");
			// Return True, for SUCCESSFUL INSERT
			return true;
		}
		System.out.println("ERROR: Insert UserBean FAILED; UserBean insertThisUser == null.");
		System.out.println("FINISH: UserBeanDAO.insertUser(UserBean insertThisUser)");
		// Return False, for FAILED INSERT
		return false;
	}

	@Override
	public UserBean selectUser(UserBean selectThisUser) {
		
		return null;
	}
	
	// Override tag is only used if supertype UserBeanDAOInterface also has this method
	// @Override
	public List<UserBean> selectAll() {
		// Get current Session
		Session session = sessionFactory.getCurrentSession();
		// Get all rows from UsersTable
		Query query = session.createQuery("From UserBean"); // This 'From' references UserBean.java
		// Store query results into List results
		List<UserBean> results = (List<UserBean>) query.list();
		System.out.println("SelectAll: "+results.get(0).getClass());
		// Print List results into console (for debugging)
		for (int index=0;index<results.size();index++) {
			System.out.println(results.get(index).getUserID());
			System.out.println(results.get(index).getUserEmail());
			System.out.println(results.get(index).getUserPwd());
			System.out.println(results.get(index).getAdmin());
		}
		// Return List results
		return results;
	}

	@Override
	public boolean updateEmail(UserBean updateThisUser, String newEmail) {
		
		return false;
	}

	@Override
	public boolean updatePwd(UserBean updateThisUser, String newPwd) {
		
		return false;
	}

	@Override
	public boolean deleteUser(UserBean deleteThisUser) {
		
		return false;
	}

}
