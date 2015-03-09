package org.ili.java.projecttp.business.service.impl;

import java.util.List;

import org.ili.java.projecttp.business.service.IService;
import org.ili.java.projecttp.persistence.dao.IDAO;
import org.ili.java.projecttp.persistence.dataobject.PersonDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Olivier MICHALSKI
 *
 */
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Service("PersonService")
public class PersonService implements IService<PersonDo> {

  @Autowired
  @Qualifier("PersonDAO")
  private IDAO<PersonDo> personDAO;

  /* (non-Javadoc)
   * @see org.ili.java.projecttp.business.service.IService#addPerson(java.lang.Object)
   */
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  @Override
  public void addPerson(final PersonDo p) {

    personDAO.create(p);
  }

  /* (non-Javadoc)
   * @see org.ili.java.projecttp.business.service.IService#modifiyPerson(java.lang.Object)
   */
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  @Override
  public void modifiyPerson(final PersonDo p) {

    personDAO.update(p);
  }

  /* (non-Javadoc)
   * @see org.ili.java.projecttp.business.service.IService#countAllPerson()
   */
  @Transactional(readOnly = true)
  @Override
  public Integer countAllPerson() {

    return personDAO.countAll();
  }

  /* (non-Javadoc)
   * @see org.ili.java.projecttp.business.service.IService#fetchPerson(java.lang.Integer)
   */
  @Transactional(readOnly = true)
  @Override
  public PersonDo fetchPerson(final Integer id) {

    return personDAO.find(id);
  }

  /* (non-Javadoc)
   * @see org.ili.java.projecttp.business.service.IService#fetchAllPersons()
   */
  @Transactional(readOnly = true)
  @Override
  public List<PersonDo> fetchAllPersons() {

    return personDAO.findAll();
  }

  /* (non-Javadoc)
   * @see org.ili.java.projecttp.business.service.IService#existPerson(java.lang.Object)
   */
  @Override
  public boolean existPerson(final PersonDo object) {

    return personDAO.exist(object);
  }

  /* (non-Javadoc)
   * @see org.ili.java.projecttp.business.service.IService#removePerson(java.lang.Object)
   */
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  @Override
  public void removePerson(final PersonDo object) {

    personDAO.delete(object);
  }

}
