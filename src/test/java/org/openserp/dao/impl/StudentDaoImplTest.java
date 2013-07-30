package org.openserp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.openserp.dao.StudentDao;
import org.openserp.entity.Student;
import org.openserp.test.common.AbstractDBUnitTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.CollectionUtils;
import org.testng.annotations.Test;

@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration(locations = { "classpath:applicationContext-main-test.xml" })
//@AbstractDBUnitTest.FlatXMLDataSet(locations = { "daoTesting/StudentDao.xml" })
public class StudentDaoImplTest extends AbstractDBUnitTest {

	@Resource(name = "studentDao")
	private StudentDao studentDao;
	
	@Test
	public void testSaveFind(){
		List<Student> resultList = studentDao.findAll();
		Assert.assertTrue(CollectionUtils.isEmpty(resultList));
	}
}
