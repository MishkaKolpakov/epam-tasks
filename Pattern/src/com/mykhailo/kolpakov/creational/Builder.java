package com.mykhailo.kolpakov.creational;

public class Builder {
	public static void main(String[] args) {
	/*	Car car = new CarBuilder().buildMark("Mercedes").buildTransmission(Transmission.AUTO).buildMaxSpeed(120)
				.build();
		System.out.println(car);
*/
		Director director = new Director();
		director.setBuilder(new SubaruBuilder());
		Car car = director.buildCar();
		System.out.println(car);
	}
}

enum Transmission {
	MANUAL, AUTO
}

class Car {
	String mark;
	Transmission transmission;
	int maxSpeed;

	public void setMark(String mark) {
		this.mark = mark;
	}

	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {

		return "Mark: " + mark + ", Transmission: " + transmission + ", maxspeed: " + maxSpeed;
	}

}

abstract class CarBuilder {
	Car car;

	void createCar() {
		car = new Car();
	}

	abstract void buildMark();

	abstract void buildTransmission();

	abstract void buildMaxSpeed();

	Car getCar() {
		return car;
	}
}

class FordMondeoBuilder extends CarBuilder {

	@Override
	void buildMark() {
		car.setMark("Ford Mondeo");

	}

	@Override
	void buildTransmission() {
		car.setTransmission(Transmission.AUTO);
	}

	@Override
	void buildMaxSpeed() {
		car.setMaxSpeed(120);
	}

}

class SubaruBuilder extends CarBuilder {

	@Override
	void buildMark() {
		car.setMark("Subaru");

	}

	@Override
	void buildTransmission() {
		car.setTransmission(Transmission.AUTO);
	}

	@Override
	void buildMaxSpeed() {
		car.setMaxSpeed(220);
	}

}

class Director {
	CarBuilder carBuilder;
	
	void setBuilder(CarBuilder carBuilder) {
		this.carBuilder = carBuilder;
	}
	
	Car buildCar() {
		carBuilder.createCar();
		carBuilder.buildMark();
		carBuilder.buildTransmission();
		carBuilder.buildMaxSpeed();
		Car car = carBuilder.getCar();
		return car;
	}
}
/*
 * class CarBuilder { String m = "Default"; Transmission t = Transmission.AUTO;
 * int s = 100;
 * 
 * public CarBuilder buildMark(String m) { this.m = m; return this; }
 * 
 * public CarBuilder buildTransmission(Transmission m) { this.t = m; return
 * this; }
 * 
 * public CarBuilder buildMaxSpeed(int speed) { this.s = speed; return this; }
 * 
 * Car build() { Car car = new Car(); car.setMark(m); car.setTransmission(t);
 * car.setMaxSpeed(s); return car; } }
 */
