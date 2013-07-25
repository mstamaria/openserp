package org.openserp.enums;


public enum UserTypeEnum implements SingleValuedEnum<String> {
	ADMIN("ADMIN");

	private String type;

	@Override
	public String getValue() {
		return this.type;
	}

	private UserTypeEnum(String type) {
		this.type = type;
	}

	public static UserTypeEnum getEnum(String value) {
		return (UserTypeEnum) EnumHelper.getEnum(value, UserTypeEnum.values());
	}

}
