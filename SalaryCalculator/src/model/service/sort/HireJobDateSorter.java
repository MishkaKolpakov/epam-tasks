package model.service.sort;

import java.util.Collections;
import java.util.List;

import model.entity.employee.Worker;
import model.service.sort.comparator.HireJobDateComparator;

public class HireJobDateSorter implements Sortable {

	@Override
	public List<Worker> sort(List<Worker> workers) {
		Collections.sort(workers, new HireJobDateComparator());
		return workers;
	}
}
