package com.mykhailo.kolpakov.behavior;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Observer {
	public static void main(String[] args) {
		MeteoStation meteoStation = new MeteoStation();
		meteoStation.addObserver(new ConsoleObserver());

		meteoStation.setMeasurements(20, 760);

		meteoStation.addObserver(new ConsoleObserver());
		meteoStation.addObserver(new FileObserver());
		meteoStation.setMeasurements(14, 564);
	}

}

interface Observed {
	void addObserver(ObserverIF o);

	void removeObserver(ObserverIF o);

	void notifyObservers();
}

interface ObserverIF {
	void handleEvent(int tmp, int presser);
}

class MeteoStation implements Observed {

	int temperature;
	int pressure;

	List<ObserverIF> observers = new ArrayList<>();

	public void setMeasurements(int t, int p) {
		temperature = t;
		pressure = p;
		notifyObservers();
	}

	@Override
	public void addObserver(ObserverIF o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(ObserverIF o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for (ObserverIF o : observers)
			o.handleEvent(temperature, pressure);
	}
}

class ConsoleObserver implements ObserverIF {

	@Override
	public void handleEvent(int tmp, int presser) {
		System.out.println("The weather changed. Temperature = " + tmp + ", pressure = " + presser);
	}
}

class FileObserver implements ObserverIF {

	@Override
	public void handleEvent(int tmp, int presser) {
		java.io.File file;

		try {
			file = java.io.File.createTempFile("TempPressure", "_txt");
			PrintWriter pw = new PrintWriter(file);
			pw.print("The weather changed. Temperature = " + tmp + ", Pressure = " + presser + ".");
			pw.println();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}