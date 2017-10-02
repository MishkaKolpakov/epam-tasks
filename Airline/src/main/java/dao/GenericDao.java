package dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> extends AutoCloseable{

	List<T> findAll();

	boolean update(T item);

	boolean delete(Long id);

	Optional<T> findElementById(Long id);

	long insert(T item);
}
