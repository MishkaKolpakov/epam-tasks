package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Address;

public interface AddressDAO {
	void add(Address address);

	List<Address> getAll() throws SQLException;

	Address getById(Long id);

	void update(Address address);

	void remove(Address address);
}
