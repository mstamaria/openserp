package org.openserp.service;

import java.util.List;

import org.openserp.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{

	/**
	 * Retrieves the user list by pages
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	List<User> getUserList(int firstResult, int maxResults);

}
