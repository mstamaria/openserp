package org.openserp.service;

public interface PasswordEncoderTool {

	/**
	 * Tool for encoding password and salt values.
	 * @param password
	 * @param salt
	 * @return
	 */
	String encode(String password, String salt);

}
