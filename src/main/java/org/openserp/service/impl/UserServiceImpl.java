package org.openserp.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.openserp.dao.UserDao;
import org.openserp.entity.User;
import org.openserp.entity.UserRole;
import org.openserp.enums.LoginStatus;
import org.openserp.service.UserService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Required
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userDao.findById(username);
		if (user == null) {
			throw new UsernameNotFoundException("user '" + username
					+ "' not found...");
		}
		return createUserDetails(user);
	}

	private UserDetails createUserDetails(User userEntity) {

		String username = userEntity.getUsername();
		String password = userEntity.getPassword();
		boolean enabled = checkAccountEnabled(userEntity);
		boolean accountNonExpired = checkAccountEnabled(userEntity);
		boolean credentialsNonExpired = checkAccountEnabled(userEntity);
		boolean accountNonLocked = checkAccountEnabled(userEntity);

		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		if (CollectionUtils.isNotEmpty(userEntity.getRoles())) {
			for (UserRole userRole : userEntity.getRoles()) {
				authorities.add(new SimpleGrantedAuthority(userRole.getRole()));
			}
		}

		org.springframework.security.core.userdetails.User springUserEntity = new org.springframework.security.core.userdetails.User(
				username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);

		return springUserEntity;
	}

	private boolean checkAccountEnabled(User userEntity) {
		return (LoginStatus.ENABLED.equals(userEntity.getEnabled())
				&& (userEntity.getFailedCount() == null || userEntity
						.getFailedCount() < 10));
	}
	
	
	public List<User> getUserList(int firstResult, int maxResults){
		List<User> resultList = userDao.findAllByPage(firstResult, maxResults);
		return resultList;
	}

}
