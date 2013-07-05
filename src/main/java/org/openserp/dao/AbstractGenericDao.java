package org.openserp.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractGenericDao<Entity, PK extends Serializable>
		implements GenericDao<Entity, PK> {
	private Class<?> entityClass;

	@PersistenceContext
	protected EntityManager entityManager;

	public AbstractGenericDao() {

		ParameterizedType genericSuperClass = (ParameterizedType) getClass()
				.getGenericSuperclass();

		this.entityClass = (Class<?>) genericSuperClass
				.getActualTypeArguments()[0];

	}

	@Override
	public void flush(){
		entityManager.flush();
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public Entity saveUpdate(final Entity entity) {
		return entityManager.merge(entity);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void delete(final Entity entity) {
		entityManager.remove(entity);

	}

	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	@Override
	@SuppressWarnings("unchecked")
	public Entity findById(final PK id) {
		return (Entity) entityManager.find(entityClass, id);
	}
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	@Override
	public List<Entity> findAll() {
		Query query = entityManager
				.createQuery("FROM " + entityClass.getName());
		return findByCriteria(0, 0, query);

	}
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	@Override
	@SuppressWarnings("unchecked")
	public List<Entity> findByCriteria(final int firstResult,
			final int maxResults, final Query query) {
        
		if (firstResult > 0) {
			query.setFirstResult(firstResult);
		}

		if (maxResults > 0) {
			query.setMaxResults(maxResults);
		}

		List<Entity> result = (List<Entity>)query.getResultList();
		return result;
	}
	

}
