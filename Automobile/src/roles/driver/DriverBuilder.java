package roles.driver;


import entities.car.DriverLicense;
import entities.human.Human;

public class DriverBuilder {
	Human human;
	DriverLicense driverLicense;

	public Human getHuman() {
		return human;
	}

	public DriverLicense getDriverLicense() {
		return driverLicense;
	}

	public DriverBuilder addHuman(Human human) {
		this.human = human;
		return this;
	}

	public DriverBuilder addDriverCategory(DriverLicense driverLicense) {
		this.driverLicense = driverLicense;
		return this;
	}

	public Driver buildDriver() {
		return new Driver(this);
	}
}
