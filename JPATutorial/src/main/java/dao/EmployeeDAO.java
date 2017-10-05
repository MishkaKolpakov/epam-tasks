package dao;

import java.util.List;

import entity.Employee;

public interface EmployeeDAO {
	void add(Employee employee);

	List<Employee> getAll();

	Employee getById(Long id);

	void update(Employee employee);

	void remove(Employee employee);
}
