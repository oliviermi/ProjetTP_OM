/**
 * 
 */
package org.ili.java.projecttp.business.service;

import java.util.List;

/**
 * @author Olivier MICHALSKI
 *
 */
public interface IService<T> {

  
  void addPerson(T object);

  Integer countAllPerson();

  T fetchPerson(Integer id);

  void modifiyPerson(T object);

  List<T> fetchAllPersons();

}
