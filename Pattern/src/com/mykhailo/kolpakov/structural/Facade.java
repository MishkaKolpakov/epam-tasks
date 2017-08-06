package com.mykhailo.kolpakov.structural;

public class Facade {
	public static void main(String[] args) {
//		Power power = new Power();
//		power.on();
//		DVDRom dvdRom = new DVDRom();
//		// dvdRom.load();
//		HDD hdd = new HDD();
//		hdd.copyFromDVD(dvdRom);
		Computer computer = new Computer();
		computer.copy();

	}
}

class Computer {
	Power power = new Power();
	DVDRom dvdRom = new DVDRom();
	HDD hdd = new HDD();

	void copy() {
		power.on();
		dvdRom.load();
		hdd.copyFromDVD(dvdRom);
	}
}

class Power {
	void on() {
		System.out.println("On power");
	}

	void off() {
		System.out.println("Off power");
	}
}

class DVDRom {
	private boolean data;

	public boolean hasData() {
		return data;
	}

	void load() {
		System.out.println("Disk loaded");
		data = true;
	}

	void unload() {
		System.out.println("Disk unloaded");
		data = false;
	}
}

class HDD {
	void copyFromDVD(DVDRom dvd) {
		if (dvd.hasData()) {
			System.out.println("Copying data from disk!");
		} else {
			System.out.println("Insert disk with data");
		}
	}
}