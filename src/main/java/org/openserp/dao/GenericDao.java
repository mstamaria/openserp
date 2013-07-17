package org.openserp.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

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

	/**
	 * Generic find all.
	 * 
	 * Please note that using this on a large dataset may slow down the
	 * application, and cause out of memory problem
	 * 
	 * @return
	 */
	List<Entity> findAll();

	/**
	 * Uses pagination in the query
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param query
	 * @return
	 */
	List<Entity> findByCriteria(int firstResult, int maxResults, Query query);

	/**
	 * Retrieves all records by page
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	List<Entity> findAllByPage(int firstResult, int maxResults);

	
}
