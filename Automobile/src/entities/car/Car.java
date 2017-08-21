package entities.car;

import entities.details.Motor;

import entities.details.Chassis;

public class Car {
	public enum MarkType {
		Audi, Porsche, Mazda
	};

	Chassis chassis;
	Motor motor;
	MarkType mark;
	DriverLicense.Category category;

	public Car(CarBuilder carBuilder) {
		this.chassis = carBuilder.getChassis();
		this.motor = carBuilder.getMotor();
		this.mark = carBuilder.getMark();
		this.category = carBuilder.getCategory();
	}

	public Chassis getChassis() {
		return chassis;
	}

	public void setChassis(Chassis chassis) {
		this.chassis = chassis;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public MarkType getMark() {
		return mark;
	}

	public void setMark(MarkType mark) {
		this.mark = mark;
	}

	public DriverLicense.Category getCategory() {
		return category;
	}

	public void setCategory(DriverLicense.Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Car [chassis=" + chassis + ", motor=" + motor + ", mark=" + mark + ", category=" + category + "]";
	}

}
