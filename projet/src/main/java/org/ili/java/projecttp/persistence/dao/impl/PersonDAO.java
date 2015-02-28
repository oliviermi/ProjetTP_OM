package org.ili.java.projecttp.persistence.dao.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
  private Logger        logger;

  @Override
  public Integer countAll() {

    return ((BigInteger) (entityManager.createNativeQuery("SELECT count(*) FROM person").getSingleResult())).intValue();
  }

  @Override
  public void create(final PersonDo object) {

    logger.info("Starting persist");

    entityManager.persist(object);
    //entityManager.flush();
    logger.info("Finished persist");
  }

  @Override
  public PersonDo find(final Integer id) {
    return (PersonDo) entityManager.find(PersonDo.class, id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<PersonDo> findAll() {
    return (List<PersonDo>) entityManager.createQuery("SELECT * FROM person").getResultList();
  }

  @Override
  public void update(final PersonDo object) {
    entityManager.merge(object);
  }

  @Override
  public void delete(final PersonDo object) {
    entityManager.remove(object);
  }

  @Override
  public boolean exist(final PersonDo object) {
    return false;
  }
}
