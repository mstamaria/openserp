package org.openserp.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	public Entity saveUpdate(Entity entity) {
		return entityManager.merge(entity);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void delete(Entity entity) {
		entityManager.remove(entity);

	}

	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	@Override
	@SuppressWarnings("unchecked")
	public Entity findById(PK id) {
		return (Entity) entityManager.find(entityClass, id);
	}

}
