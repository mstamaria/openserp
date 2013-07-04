package org.openserp.enums;


public enum UserType implements SingleValuedEnum<String> {
	ADMIN("ADMIN");

	private String type;

	@Override
	public String getValue() {
		return this.type;
	}

	private UserType(String type) {
		this.type = type;
	}

	public static UserType getEnum(String value) {
		return (UserType) EnumHelper.getEnum(value, UserType.values());
	}

}
