package entity;

import java.time.LocalDate;

import entity.Human.BloodGroup;
import entity.Human.Gender;

public class HumanBuilder {

	private String name;
	private LocalDate birthDay;
	private Gender gender;
	private BloodGroup bloodGroup;
	private String workPlace;

	public HumanBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public HumanBuilder setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
		return this;
	}

	public HumanBuilder setGender(Gender gender) {
		this.gender = gender;
		return this;
	}

	public HumanBuilder setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
		return this;
	}

	public HumanBuilder setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
		return this;
	}

	public Human buildHuman() {
		return new Human(this);
	}

	public String getName() {
		return name;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public Gender getGender() {
		return gender;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

}
