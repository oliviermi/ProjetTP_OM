package org.ili.java.projecttp.persistence.dao;

import java.util.List;

public interface IDAO<T> {

  void create(final T object);

  T find(final Integer id);

  void update(final T object);

  void delete(final T object);

  boolean exist(final T object);

  Integer countAll();

  List<T> findAll();
}
