package com.mykhailo.kolpakov.creational;

import java.util.Date;

public class FactoryMethod {

	public static void main(String[] args) {
		WatchMaker maker = getMakerByName("Digital");
		Watch watch = maker.createWatch();
		watch.showTime();
	}
	
	public static WatchMaker getMakerByName(String watchName){
		if(watchName.equals("Digital"))
			return new DigitalWatchMaker();
		else if(watchName.equals("Rome"))
			return new RomeWatchMaker();
		throw new RuntimeException("не поддерживаемый производитель " + watchName);
	}

}

interface Watch {
	void showTime();
}

class DigitalWatch implements Watch {
	public void showTime() {
		System.out.println(new Date());
	}
}

class RomeWatch implements Watch {
	public void showTime() {
		System.out.println("XYII");
	}
}

interface WatchMaker {
	Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker {
	public Watch createWatch() {
		return new DigitalWatch();
	}
}

class RomeWatchMaker implements WatchMaker {
	public Watch createWatch() {
		return new RomeWatch();
	}
}
