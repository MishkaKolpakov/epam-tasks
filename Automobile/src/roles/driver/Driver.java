package roles.driver;

import entities.car.Car;
import entities.car.DriverLicense;
import entities.human.Human;
import roles.driver.Drive;

public class Driver implements Drive {
	Human human;
	DriverLicense driverLicense;
	Car car;

	Driver(DriverBuilder driverBuilder) {
		this.human = driverBuilder.getHuman();
		this.driverLicense = driverBuilder.getDriverLicense();
		this.car = driverBuilder.getCar();
	}

	public Human getHuman() {
		return human;
	}

	public void setHuman(Human human) {
		this.human = human;
	}

	public DriverLicense getDriverLicense() {
		return driverLicense;
	}

	public void setDriverLicense(DriverLicense driverLicense) {
		this.driverLicense = driverLicense;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public void drive() {
		if (driverLicense.categories.contains(car.getCategory())) {
			System.out.println("Driver is driving " + car);
		} else {
			System.out.println("Driver category doesn`t match to this type of car");
		}
	}

}
