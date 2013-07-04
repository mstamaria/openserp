package org.openserp.service.impl;

import javax.annotation.Resource;

import org.junit.Assert;
import org.openserp.service.PasswordEncoderTool;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@ContextConfiguration(locations = { "classpath:applicationContext-main.xml" })
public class PasswordEncoderToolTest extends
		AbstractTransactionalTestNGSpringContextTests {

	@Resource(name = "passwordEncoderTool")
	private PasswordEncoderTool passwordEncoderTool;

	@Test
	public void testPasswordEncoderTool() {
		String encoded = passwordEncoderTool.encode("password", "salt");
		Assert.assertEquals(
				"9db71705edaf605996315d16ba692d3a6a26d08905a22618841e6bda87bb9d3d",
				encoded);
		
		System.out.println(passwordEncoderTool.encode("BimHent8", "sysadmin"));
	}

	@DataProvider(name = "emptyStringValues")
	public Object[][] emptyStringValuesDataProvider() {
		return new Object[][] { { null }, { "" }, { "  " } };
	}

	@Test(dataProvider = "emptyStringValues", expectedExceptions = { IllegalArgumentException.class })
	public void testPasswordEncoderToolEmptyPassword(String emptyValues) {
		passwordEncoderTool.encode(emptyValues, "salt");

	}
}
