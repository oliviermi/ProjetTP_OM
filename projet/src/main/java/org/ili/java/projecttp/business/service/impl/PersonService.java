package org.ili.java.projecttp.business.service.impl;

import java.util.List;

import org.ili.java.projecttp.business.service.IService;
import org.ili.java.projecttp.persistence.dao.impl.PersonDAO;
import org.ili.java.projecttp.persistence.dataobject.PersonDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService implements IService<PersonDo> {

  @Autowired
  private PersonDAO personDAO;

  @Transactional(propagation = Propagation.MANDATORY)
  @Override
  public void addPerson(final PersonDo p) {
    personDAO.create(p);
  }

  @Transactional
  @Override
  public void modifiyPerson(final PersonDo p) {
    personDAO.update(p);
  }

  @Transactional(readOnly = true)
  @Override
  public Integer countAllPerson() {
    return personDAO.countAll();
  }

  @Transactional(readOnly = true)
  @Override
  public PersonDo fetchPerson(final Integer id) {
    return personDAO.find(id);
  }

  @Transactional(readOnly = true)
  @Override
  public List<PersonDo> fetchAllPersons() {

    return personDAO.findAll();
  }

}
