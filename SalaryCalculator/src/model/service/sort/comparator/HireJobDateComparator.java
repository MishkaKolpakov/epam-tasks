package model.service.sort.comparator;

import java.util.Comparator;

import model.entity.employee.Worker;

public class HireJobDateComparator implements Comparator<Worker> {

	@Override
	public int compare(Worker worker1, Worker worker2) {
		return worker1.getHireJobDate().compareTo(worker2.getHireJobDate());
	}

}
