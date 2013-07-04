package org.openserp.enums;


public enum LoginStatus implements SingleValuedEnum<String> {
	ENABLED("1"), DISABLED("0");

	private String status;

	@Override
	public String getValue() {
		return status;
	}

	private LoginStatus(String status) {
		this.status = status;
	}

	public static LoginStatus getEnum(String value) {
		return (LoginStatus) EnumHelper.getEnum(value, LoginStatus.values());
	}

}
