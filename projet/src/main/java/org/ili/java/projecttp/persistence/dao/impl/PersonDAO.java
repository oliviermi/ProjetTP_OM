package org.ili.java.projecttp.persistence.dao.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.ili.java.projecttp.persistence.dao.IDAO;
import org.ili.java.projecttp.persistence.dataobject.PersonDo;
import org.ili.java.projecttp.utils.logger.Loggable;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * @author Olivier MICHALSKI
 *
 */
@Repository("PersonDAO")
public class PersonDAO implements IDAO<PersonDo> {

  @PersistenceContext(unitName = "mypu")
  private EntityManager entityManager;

  @Loggable
  private static Logger        logger;

  @Override
  public Integer countAll() {
    return ((BigInteger) (entityManager.createNativeQuery("SELECT count(*) FROM person").getSingleResult())).intValue();
  }

  @Override
  public void create(final PersonDo object) {

    logger.info("Starting persist");

    entityManager.persist(object);

    logger.info("Finished persist");
  }

  @Override
  public PersonDo find(final Integer id) {
    
    logger.debug("********value for id =" + id);
    
    return (PersonDo) entityManager.find(PersonDo.class, id);
  }

  @Override
  public List<PersonDo> findAll() {
    final TypedQuery<PersonDo> query = entityManager.createNamedQuery("Person.findAll", PersonDo.class);
    
    final List<PersonDo> list2 = query.getResultList();
    
    for (PersonDo tmp : list2) {
     
      logger.debug("retrieved value = " + tmp.toString());

    }
    
    return query.getResultList();
  }

  @Override
  public void update(final PersonDo object) {
    entityManager.merge(object);
  }

  @Override
  public void delete(final PersonDo object) {
    entityManager.remove(entityManager.find(PersonDo.class, object.getIdperson()));
  }

  @Override
  public boolean exist(final PersonDo object) {
    return entityManager.find(PersonDo.class, object.getIdperson(), object.propertiesToMap()) != null;
  }
}
