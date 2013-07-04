package org.openserp.dao.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.openserp.dao.UserDao;
import org.openserp.entity.User;
import org.openserp.entity.UserRole;
import org.openserp.enums.UserType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration(locations = { "classpath:applicationContext-main.xml" })
public class UserDaoImplTest extends
		AbstractTransactionalTestNGSpringContextTests {

	@Resource(name = "userDao")
	private UserDao userDao;

	@Test
	public void testSave() {
		User entity = new User();
		entity.setFailedCount(0);
		entity.setPassword("password");
		entity.setUsername("username");
		User user = userDao.saveUpdate(entity);
		Assert.assertEquals(entity, user);
	}

	@Test
	public void testSaveFind() {
		// save
		UserRole userRole = new UserRole();
		userRole.setRole("ROLE_USER");
		List<UserRole> roles = Arrays.asList(userRole);
		
		User entity = new User();
		entity.setFailedCount(0);
		entity.setPassword("password");
		entity.setUsername("username");
		entity.setRoles(roles);
		entity.setUserType(UserType.ADMIN);
		
		userRole.setUser(entity);

		User user = userDao.saveUpdate(entity);
		Assert.assertEquals(entity, user);

		// find
		User queryResult = userDao.findById("username");
		Assert.assertEquals(user, queryResult);
		List<UserRole> roles2 = queryResult.getRoles();
		Assert.assertEquals(roles.size(), roles2.size());
		Assert.assertEquals(roles.get(0), roles2.get(0));
	}
}
