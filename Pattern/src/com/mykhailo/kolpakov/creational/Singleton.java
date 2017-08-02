package com.mykhailo.kolpakov.creational;

public class Singleton {
	public static void main(String[] args) {
			int MAX_SIZE = 1000;
			Single[] singles = new Single[MAX_SIZE];
			
			for(int i = 0; i < MAX_SIZE; i++) {
				singles[i] = Single.getInstance();
			}
			System.out.println(Single.counter);
	}
}

class Single {
	private Single() { counter++;};

	public static int counter = 0;
	private static Single instance;

	
	public static Single getInstance() {
		if (instance == null)
			instance = new Single();
		return instance;
	}
}
