package model.service.sort.comparator;

import java.util.Comparator;

import model.entity.employee.Worker;

public class LastNameComparator implements Comparator<Worker> {

	@Override
	public int compare(Worker worker1, Worker worker2) {
		return worker2.getLastName().compareTo(worker1.getLastName());
	}
}
