package dao;

public interface DAOSearchable<T> {
	T findByLastName(String lastName);
}
