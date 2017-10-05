package dao;

import java.util.List;

public interface EmplProj {
	
	void add(EmplProj emplProj);

	List<EmplProj> getAll();

	EmplProj getById(Long employeeId, Long projectId);

	void update(EmplProj emplProj);

	void remove(EmplProj emplProj);
}
