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
		// create user roles
		List<UserRole> userRoleList = createUserRoleList();
		// create the user
		User userEntity = createUserEntity();
		// set the bidirectional association
		setBidirectionalAssociation(userRoleList, userEntity);

		User user = userDao.saveUpdate(userEntity);
		Assert.assertEquals(userEntity, user);

		// find
		User queryResult = userDao.findById("username");
		Assert.assertEquals(user, queryResult);
		List<UserRole> roles2 = queryResult.getRoles();
		Assert.assertEquals(userRoleList.size(), roles2.size());
		Assert.assertEquals(userRoleList.get(0), roles2.get(0));
	}

	private void setBidirectionalAssociation(List<UserRole> userRoleList,
			User userEntity) {
		userEntity.setRoles(userRoleList);
		for (UserRole userRole : userRoleList) {
			userRole.setUser(userEntity);
		}
	}

	private User createUserEntity() {
		User userEntity = new User();
		userEntity.setFailedCount(0);
		userEntity.setPassword("password");
		userEntity.setUsername("username");
		userEntity.setUserType(UserType.ADMIN);
		return userEntity;
	}

	private List<UserRole> createUserRoleList() {
		UserRole userRole = new UserRole();
		userRole.setRole("ROLE_USER");
		List<UserRole> userRoleList = Arrays.asList(userRole);
		return userRoleList;
	}
	
	@Test
	public void testSaveFindAll(){
		
		//initial find
		List<User> queryResult = userDao.findAll();
		Assert.assertEquals(queryResult.size(), 1);
		
		// create user roles
		List<UserRole> userRoleList = createUserRoleList();
		// create the user
		User userEntity = createUserEntity();
		// set the bidirectional association
		setBidirectionalAssociation(userRoleList, userEntity);

		User user = userDao.saveUpdate(userEntity);
		Assert.assertEquals(userEntity, user);
		
		// find after saving
		queryResult = userDao.findAll();
		Assert.assertEquals(queryResult.size(), 2);
	}
}
