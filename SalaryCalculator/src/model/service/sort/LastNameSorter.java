package model.service.sort;

import java.util.Collections;
import java.util.List;

import model.entity.employee.Worker;
import model.service.sort.comparator.LastNameComparator;

public class LastNameSorter implements Sortable {

	@Override
	public List<Worker> sort(List<Worker> workers) {
		Collections.sort(workers, new LastNameComparator());

		return workers;
	}
}
