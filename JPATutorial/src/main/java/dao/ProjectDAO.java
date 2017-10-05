package dao;

import java.util.List;

import entity.Project;


public interface ProjectDAO {
	void add(Project project);

	List<Project> getAll();

	Project getById(Long id);

	void update(Project project);

	void remove(Project project);
}
