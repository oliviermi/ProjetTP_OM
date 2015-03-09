package org.ili.java.projecttp.business.service;

import java.util.List;

/**
 * @author Olivier MICHALSKI
 *
 */
public interface IService<T> {

  /**
   * @param object
   */
  void addPerson(T object);

  /**
   * @return
   */
  Integer countAllPerson();

  /**
   * @param id
   * @return
   */
  T fetchPerson(Integer id);

  /**
   * @param object
   */
  void modifiyPerson(T object);

  /**
   * @return
   */
  List<T> fetchAllPersons();

  /**
   * @param object
   * @return
   */
  boolean existPerson(T object);

  /**
   * @param object
   */
  void removePerson(T object);

}
