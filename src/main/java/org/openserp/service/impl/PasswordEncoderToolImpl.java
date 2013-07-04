package org.openserp.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.openserp.service.PasswordEncoderTool;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.authentication.encoding.PasswordEncoder;

public class PasswordEncoderToolImpl implements PasswordEncoderTool {

	private PasswordEncoder passwordEncoder;

	@Required
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public String encode(String rawPassword, String salt) {
		if (StringUtils.isBlank(rawPassword) || StringUtils.isBlank(salt)) {
			throw new IllegalArgumentException("Password or Salt for encoding is not provided");
		}
		return passwordEncoder.encodePassword(rawPassword, salt);
	}
	
}
