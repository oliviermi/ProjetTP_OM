package org.ili.java.projecttp.persistence.dao;

import java.util.List;

/**
 * @author Olivier MICHALSKI
 *
 * @param <T>
 */
/**
 * @author Olivier MICHALSKI
 *
 * @param <T>
 */
public interface IDAO<T> {

  /**
   * @param object
   */
  void create(final T object);

  /**
   * @param id
   * @return
   */
  T find(final Integer id);

  /**
   * @param object
   */
  void update(final T object);

  /**
   * @param object
   */
  void delete(final T object);

  /**
   * @param object
   * @return
   */
  boolean exist(final T object);

  /**
   * @return
   */
  Integer countAll();

  /**
   * @return
   */
  List<T> findAll();
}
