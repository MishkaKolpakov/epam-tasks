package com.mykhailo.kolpakov.creational;

public class Singleton {
	public static void main(String[] args) throws InterruptedException {
		int MAX_SIZE = 1000;
		Thread[] threads = new Thread[MAX_SIZE];
		for (int i = 0; i < MAX_SIZE; i++) {
			threads[i] = new Thread(new R());
			threads[i].start();
		}
		for (int i = 0; i < MAX_SIZE; i++) {
			threads[i].join();
		}
		System.out.println(Single.counter);
	}
}

class R implements Runnable {

	@Override
	public void run() {
		Single.getInstance();
	}

}

class Single {
	private Single() {
		counter++;
	};

	public static int counter = 0;
	private static volatile Single instance = null;

	/*
	 * public static Single getInstance() { return instance; }
	 */
	/*
	 * public static Single getInstance() { if (instance == null) instance = new
	 * Single(); return instance; }
	 */
	/*
	 * public static synchronized Single getInstance() { if (instance == null)
	 * instance = new Single();
	 * 
	 * return instance; }
	 */

	public static Single getInstance() {
		if (instance == null) {
			synchronized (Single.class) {
				if (instance == null) {
					instance = new Single();
				}
			}
		}
		return instance;
	}

}
