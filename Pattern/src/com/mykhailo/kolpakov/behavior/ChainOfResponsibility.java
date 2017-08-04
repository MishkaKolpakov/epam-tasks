package com.mykhailo.kolpakov.behavior;

public class ChainOfResponsibility {
	public static void main(String[] args) {

	}
}

class Level {
	public final static int ERROR = 1;
	public final static int DEBUG = 2;
	public final static int INFO = 3;

}

interface Logger {
	void writeMessage(String message, int level);
}
