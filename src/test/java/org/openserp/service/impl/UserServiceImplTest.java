package org.openserp.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.openserp.dao.UserDao;
import org.openserp.entity.User;
import org.openserp.entity.UserRole;
import org.openserp.enums.LoginStatus;
import org.openserp.enums.UserRoleEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@ContextConfiguration(locations = { "classpath:applicationContext-main-test.xml" })
public class UserServiceImplTest extends
		AbstractTransactionalTestNGSpringContextTests {

	private static final String SYSADMIN = "SYSADMIN";

	private UserServiceImpl userServiceImpl;

	@Mock
	private UserDao mockedUserDao;

	@BeforeClass
	public void beforeClass() {
		MockitoAnnotations.initMocks(this);
		userServiceImpl = new UserServiceImpl();
		userServiceImpl.setUserDao(mockedUserDao);
	}

	@AfterMethod
	public void afterMethod() {
		Mockito.reset(mockedUserDao);
	}

	@Test
	public void testLoadUserByName() {

		User user = createUser("username");
		Mockito.when(mockedUserDao.findById(Mockito.anyString())).thenReturn(
				user);

		UserDetails userDetails = userServiceImpl.loadUserByUsername(user
				.getUsername());
		
		Mockito.verify(mockedUserDao).findById(Mockito.anyString());

		Assert.assertNotNull(userDetails);
		Assert.assertEquals(userDetails.getUsername(), user.getUsername());
		Assert.assertEquals(userDetails.getPassword(), user.getPassword());
		Assert.assertEquals(userDetails.isAccountNonExpired(),true);
		Assert.assertEquals(userDetails.isAccountNonLocked(),true);
		Assert.assertEquals(userDetails.isCredentialsNonExpired(),true);
		Assert.assertEquals(userDetails.isEnabled(),true);
		Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
		Assert.assertEquals(authorities.size(), 1);
		GrantedAuthority authority = authorities.iterator().next();
		Assert.assertEquals(authority.getAuthority(),SYSADMIN);
	
	}

	@Test(expectedExceptions = { UsernameNotFoundException.class })
	public void testLoadUserByNameException() {

		Mockito.when(mockedUserDao.findById(Mockito.anyString())).thenReturn(
				null);
		
		userServiceImpl.loadUserByUsername("username");
		
		Mockito.verify(mockedUserDao).findById(Mockito.anyString());
	}

	private User createUser(String username) {
		User user = new User();
		user.setUsername(username);
		user.setPassword("password");
		user.setEnabled(LoginStatus.ENABLED);
		user.setFailedCount(0);
		List<UserRole> roles = createUserRoles(user);
		user.setRoles(roles);
		return user;
	}

	private List<UserRole> createUserRoles(User user) {
		UserRole userRole = createUserRole(user, SYSADMIN);
		return Arrays.asList(userRole);
	}

	private UserRole createUserRole(User user, String string) {
		UserRole userRole = new UserRole();
		userRole.setRole(UserRoleEnum.SYSADMIN);
		userRole.setUser(user);
		return userRole;
	}
}
