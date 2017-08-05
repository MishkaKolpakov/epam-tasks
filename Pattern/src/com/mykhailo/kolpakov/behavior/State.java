package com.mykhailo.kolpakov.behavior;

public class State {

	public static void main(String[] args) {
		Radio radio = new Radio();
		radio.setStation(new VestiFM());
		radio.play();

		radio.nextStation();
		radio.play();

		radio.nextStation();
		radio.play();

		radio.nextStation();
		radio.play();

		Human human = new Human();
		Activity activity = new Work();
		human.setState(activity);
		human.doSomething();
		human.doSomething();
	}
}

class Human {
	Activity activity;

	void setState(Activity activity) {
		this.activity = activity;
	}

	void doSomething() {
		activity.doSomething(this);
	}

}

interface Activity {
	void doSomething(Human human);
}

class Work implements Activity {

	@Override
	public void doSomething(Human human) {
		System.out.println("Working !!!");// TODO Auto-generated method stub
		human.setState(new Weekend());
	}

}

class Weekend implements Activity {

	@Override
	public void doSomething(Human human) {
		System.out.println("Resting zzZZZz");// TODO Auto-generated method stub
		human.setState(new Work());
	}

}

interface Station {
	void play();
}

class Radio7 implements Station {
	@Override
	public void play() {
		System.out.println("Radio 7 playing...");
	}
}

class RadioFM implements Station {
	@Override
	public void play() {
		System.out.println("RadioFM playing...");
	}
}

class VestiFM implements Station {
	@Override
	public void play() {
		System.out.println("VestiFM playing...");
	}
}

class Radio {
	Station state;

	void setStation(Station state) {
		this.state = state;
	}

	void nextStation() {
		if (state instanceof Radio7)
			setStation(new RadioFM());
		else if (state instanceof RadioFM) {
			setStation(new VestiFM());
		} else if (state instanceof VestiFM) {
			setStation(new Radio7());
		}
	}

	void play() {
		state.play();
	}
}
