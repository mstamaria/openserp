package org.openserp.dao.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.openserp.dao.UserDao;
import org.openserp.entity.User;
import org.openserp.entity.UserRole;
import org.openserp.enums.UserRoleEnum;
import org.openserp.enums.UserTypeEnum;
import org.openserp.test.common.AbstractDBUnitTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration(locations = { "classpath:applicationContext-main-test.xml" })
@AbstractDBUnitTest.FlatXMLDataSet(locations = { "daoTesting/UserDao.xml" })
public class UserDaoImplTest extends AbstractDBUnitTest {

	@Resource(name = "userDao")
	private UserDao userDao;

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
		userEntity.setUserType(UserTypeEnum.ADMIN);
		return userEntity;
	}

	private List<UserRole> createUserRoleList() {
		UserRole userRole = new UserRole();
		userRole.setRole(UserRoleEnum.SYSADMIN);
		List<UserRole> userRoleList = Arrays.asList(userRole);
		return userRoleList;
	}

	@Test
	public void testSaveFindAll() {

		// initial find
		List<User> queryResult = userDao.findAll();
		Assert.assertEquals(queryResult.size(), 2);

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
		Assert.assertEquals(queryResult.size(), 3);
	}
}
