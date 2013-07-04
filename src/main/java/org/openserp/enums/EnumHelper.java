package org.openserp.enums;

import java.io.Serializable;

public class EnumHelper {

	public static SingleValuedEnum<? extends Serializable> getEnum(
			String value, SingleValuedEnum<? extends Serializable>[] enumTypes) {

		for (SingleValuedEnum<? extends Serializable> item : enumTypes) {
			if (item.getValue().toString().equalsIgnoreCase(value)) {
				return item;
			}

		}
		return null;

	}
}
