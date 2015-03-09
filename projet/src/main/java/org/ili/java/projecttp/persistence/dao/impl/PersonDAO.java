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
  private static Logger myLogger;

  /* (non-Javadoc)
   * @see org.ili.java.projecttp.persistence.dao.IDAO#countAll()
   */
  @Override
  public Integer countAll() {
    return ((BigInteger) (entityManager.createNativeQuery("SELECT count(*) FROM person").getSingleResult())).intValue();
  }

  /* (non-Javadoc)
   * @see org.ili.java.projecttp.persistence.dao.IDAO#create(java.lang.Object)
   */
  @Override
  public void create(final PersonDo object) {

    entityManager.persist(object);
  }

  /* (non-Javadoc)
   * @see org.ili.java.projecttp.persistence.dao.IDAO#find(java.lang.Integer)
   */
  @Override
  public PersonDo find(final Integer id) {

    return (PersonDo) entityManager.find(PersonDo.class, id);
  }

  /* (non-Javadoc)
   * @see org.ili.java.projecttp.persistence.dao.IDAO#findAll()
   */
  @Override
  public List<PersonDo> findAll() {

    final TypedQuery<PersonDo> query = entityManager.createNamedQuery("Person.findAll", PersonDo.class);

    return (List<PersonDo>) query.getResultList();
  }

  /* (non-Javadoc)
   * @see org.ili.java.projecttp.persistence.dao.IDAO#update(java.lang.Object)
   */
  @Override
  public void update(final PersonDo object) {
    entityManager.merge(object);
  }

  /* (non-Javadoc)
   * @see org.ili.java.projecttp.persistence.dao.IDAO#delete(java.lang.Object)
   */
  @Override
  public void delete(final PersonDo object) {
    entityManager.remove(entityManager.find(PersonDo.class, object.getIdperson()));
  }

  /* (non-Javadoc)
   * @see org.ili.java.projecttp.persistence.dao.IDAO#exist(java.lang.Object)
   */
  @Override
  public boolean exist(final PersonDo object) {
    return entityManager.find(PersonDo.class, object.getIdperson(), object.propertiesToMap()) != null;
  }
}
