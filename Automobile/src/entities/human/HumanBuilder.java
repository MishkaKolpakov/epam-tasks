package entities.human;

import java.time.LocalDate;

import entities.human.Human.BloodGroup;
import entities.human.Human.Gender;

public class HumanBuilder {

	private String name;
	private LocalDate birthDay;
	private Gender gender;
	private BloodGroup bloodGroup;

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

	public Human buildHuman() {
		return new Human(this);
	}

	public String getName() {
		return name;
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
