package org.ili.java.projecttp.persistence.dao;

public interface IDAO<T> {

	void create(final T object);

	T find(final Integer id);

	void update(final T object);

	void delete(final Integer id);

	boolean exist(final T object);

	Integer countAll();

	T[] findAll();
}
