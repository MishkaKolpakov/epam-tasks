package entities.car;

import entities.car.Car.MarkType;
import entities.details.Chassis;
import entities.details.Motor;

public class CarBuilder {
	Chassis chassis;
	Motor motor;
	MarkType mark;
	DriverLicense.Category category;

	public CarBuilder addMarkType(MarkType mark) {
		this.mark = mark;
		return this;
	}

	public CarBuilder addChassis(Chassis chassis) {
		this.chassis = chassis;
		return this;
	}

	public CarBuilder addMotor(Motor motor) {
		this.motor = motor;
		return this;
	}

	public CarBuilder addCategory(DriverLicense.Category category) {
		this.category = category;
		return this;
	}

	public Car build() {
		return new Car(this);
	}

	public Chassis getChassis() {
		return chassis;
	}

	public Motor getMotor() {
		return motor;
	}

	public MarkType getMark() {
		return mark;
	}

	public DriverLicense.Category getCategory() {
		return category;
	}

}
