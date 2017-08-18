package entities.human;

import java.time.LocalDate;

public class Human {
	private String name;
	private LocalDate birthDay;

	public enum Gender {
		MALE, FEMALE
	};

	public enum BloodGroup {
		FIRST, SECOND, THIRD, FOURTH
	};

	private Gender gender;
	private BloodGroup bloodGroup;

	public Human(HumanBuilder humanBuilder) {
		this.name = humanBuilder.getName();
		this.birthDay = humanBuilder.getBirthDay();
		this.bloodGroup = humanBuilder.getBloodGroup();
		this.gender = humanBuilder.getGender();
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", birthDay=" + birthDay + ", gender=" + gender + ", bloodGroup=" + bloodGroup
				+ "]";
	}

}
