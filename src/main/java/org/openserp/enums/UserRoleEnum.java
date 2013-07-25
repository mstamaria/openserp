package org.openserp.enums;


public enum UserRoleEnum implements SingleValuedEnum<String> {
	SYSADMIN("SYSADMIN");

	private String type;

	@Override
	public String getValue() {
		return this.type;
	}

	private UserRoleEnum(String type) {
		this.type = type;
	}

	public static UserRoleEnum getEnum(String value) {
		return (UserRoleEnum) EnumHelper.getEnum(value, UserRoleEnum.values());
	}

}
