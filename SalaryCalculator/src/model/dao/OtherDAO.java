package model.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import model.entity.employee.Other;
import model.entity.employee.WorkerBuilder;

public class OtherDAO extends ArrayList<Other> {

	private static final long serialVersionUID = 1L;

	public OtherDAO() {
		this.add(new Other(new WorkerBuilder().setFirstName("Alina").setMiddleName("Petrovna").setLastName("Seryabkina")
				.setBirthdayDate(LocalDate.of(1994, 4, 5)).setHireJobDate(LocalDate.of(2016, 8, 22))
				.setSalaryRate(2000L).buildWorker(), "Secretary ..."));
		this.add(new Other(new WorkerBuilder().setFirstName("Anton").setMiddleName("Grigorievych")
				.setLastName("Vasylev").setBirthdayDate(LocalDate.of(1980, 8, 12))
				.setHireJobDate(LocalDate.of(2008, 8, 22)).setSalaryRate(6000L).buildWorker(), "Director ..."));
	}
}
