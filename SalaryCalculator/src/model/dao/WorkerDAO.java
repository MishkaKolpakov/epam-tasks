package model.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import model.entity.employee.Worker;
import model.entity.employee.WorkerBuilder;

public class WorkerDAO extends ArrayList<Worker> implements WorkerSearchable {

	private static final long serialVersionUID = 1L;

	public WorkerDAO() {
		this.add(new WorkerBuilder().setFirstName("Mykhailo").setMiddleName("Oleksiyovych").setLastName("Kolpakov")
				.setBirthdayDate(LocalDate.of(1995, 11, 14)).setHireJobDate(LocalDate.of(2017, 9, 15))
				.setSalaryRate(2500L).buildWorker());

		this.add(new WorkerBuilder().setFirstName("Oleksiy").setMiddleName("Stepanovych").setLastName("Stepanenko")
				.setBirthdayDate(LocalDate.of(1993, 8, 21)).setHireJobDate(LocalDate.of(2016, 8, 5))
				.setSalaryRate(2300L).buildWorker());

		this.add(new WorkerBuilder().setFirstName("Vasiliy").setMiddleName("Petrovych").setLastName("Hvalko")
				.setBirthdayDate(LocalDate.of(1997, 4, 5)).setHireJobDate(LocalDate.of(2014, 8, 12))
				.setSalaryRate(2800L).buildWorker());
		this.add(new WorkerBuilder().setFirstName("Petr").setMiddleName("Sergeevych").setLastName("Ivanov")
				.setBirthdayDate(LocalDate.of(1992, 8, 23)).setHireJobDate(LocalDate.of(2012, 4, 22))
				.setSalaryRate(3000L).buildWorker());

		this.add(new WorkerBuilder().setFirstName("Sergey").setMiddleName("Vladimirovych").setLastName("Vasilenko")
				.setBirthdayDate(LocalDate.of(1990, 4, 11)).setHireJobDate(LocalDate.of(2017, 4, 27))
				.setSalaryRate(2000L).buildWorker());
	}

	@Override
	public Worker findWorkerByLastName(String lastName) {
		for (Worker worker : this) {
			if (worker.getLastName().equalsIgnoreCase(lastName)) {
				return worker;
			}
		}
		throw new RuntimeException("Not found worker");
	}

}
