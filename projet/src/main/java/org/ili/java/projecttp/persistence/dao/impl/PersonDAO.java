package org.ili.java.projecttp.persistence.dao.impl;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.ili.java.projecttp.persistence.dao.IDAO;
import org.ili.java.projecttp.persistence.dataobject.PersonDo;
import org.ili.java.projecttp.utils.logger.Loggable;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Olivier MICHALSKI
 *
 */
@Repository
public class PersonDAO implements IDAO<PersonDo> {

	
	@PersistenceContext(unitName = "mypu")
	private EntityManager entityManager;

	@Loggable
	private Logger logger;
	
	@Override
	public Integer countAll() {
		
		return ((BigInteger) (entityManager.createNativeQuery("SELECT count(*) FROM person").getSingleResult())).intValue();
	}
	
	@Override
	@Transactional
	public void create(final PersonDo object) {
		entityManager.persist(object);
	}

	@Override
	@Transactional(readOnly = true)
	public PersonDo find(final Integer id) {
		
		return (PersonDo) entityManager.find(PersonDo.class, id);
	}

	@Override
	public PersonDo[] findAll() {
		
		return null;
	}
	
	@Override
	public void update(final PersonDo object) {
		
		
	}

	@Override
	public void delete(final Integer id) {
		
		
	}

	@Override
	public boolean exist(final PersonDo object) {
	
		return false;
	}
}
