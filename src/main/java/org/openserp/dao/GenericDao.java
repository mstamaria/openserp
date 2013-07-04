package org.openserp.dao;

import java.io.Serializable;

public interface GenericDao<Entity, PK extends Serializable> {

	/**
	 * Performs a save or update of the entity
	 * @param entity
	 * @return updated entity
	 */
	Entity saveUpdate(Entity entity);

	/**
	 * Deletes the entity
	 * @param entity
	 */
	void delete(Entity entity);

	/**
	 * Retrieves the entity by the PK
	 * @param id
	 * @return
	 */
	Entity findById(PK id);

	/**
	 * Flush
	 */
	void flush();

	
}
