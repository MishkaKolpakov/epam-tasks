package com.mykhailo.kolpakov.structural;

public class Bridge {
	public static void main(String[] args) {
		Car car = new Hatchback(new Skoda());
		car.showDetails();
	}
}

abstract class Car {
	Make make;

	public Car(Make make) {
		this.make = make;
	}
	
	abstract void showType();
	
	void showDetails() {
		showType();
		make.setMake();
	}
}

class Sedan extends Car {
	public Sedan(Make m) {
		super(m);
	}

	@Override
	void showType() {
		System.out.println("Sedan");
		
	}

	
}

class Hatchback extends Car {

	public Hatchback(Make make) {
		super(make);
	}

	@Override
	void showType() {
		System.out.println("Hatchback");
	}

	

}

interface Make {
	void setMake();
}

class Kia implements Make {
	@Override
	public void setMake() {
		System.out.println("Kia");
	}
}

class Skoda implements Make {
	@Override
	public void setMake() {
		System.out.println("Skoda");
	}
}