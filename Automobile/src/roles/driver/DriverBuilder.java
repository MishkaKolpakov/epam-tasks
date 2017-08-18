package roles.driver;

import entities.car.Car;
import entities.car.DriverLicense;
import entities.human.Human;

public class DriverBuilder {
	Human human;
	DriverLicense driverLicense;
	Car car;

	public Human getHuman() {
		return human;
	}

	public DriverLicense getDriverLicense() {
		return driverLicense;
	}

	public Car getCar() {
		return car;
	}

	public DriverBuilder addHuman(Human human) {
		this.human = human;
		return this;
	}

	public DriverBuilder addDriverCategory(DriverLicense driverLicense) {
		this.driverLicense = driverLicense;
		return this;
	}

	public DriverBuilder addCar(Car car) {
		this.car = car;
		return this;
	}

	public Driver buildDriver() {
		return new Driver(this);
	}
}
