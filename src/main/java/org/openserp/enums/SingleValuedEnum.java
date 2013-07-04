package org.openserp.enums;

import java.io.Serializable;

/**
 * Generic Interface for Enum that defines methods for getting values of the
 * enum and parsing values to convert to enum.
 * 
 * Applicable only to single valued enums
 * 
 * @author michaelstamaria
 * 
 * @param <EnumType>
 * @param <ValueType>
 */
public interface SingleValuedEnum<ValueType extends Serializable> {
	/**
	 * Retrieves the Enum value
	 * 
	 * @return
	 */
	public ValueType getValue();

}
