package com.epam;

import java.util.ArrayList;

import com.epam.interfaces.Constants;

public class Model {
	private int lowerBound = Constants.LOWER_BOUND;
	private int upperBound = Constants.UPPER_BOUND;
	private int randomValue;
	ArrayList<Integer> triesHistory = new ArrayList<>();

	public int getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}

	public int getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}

	public int getRandomValue() {
		return randomValue;
	}

	public void setRandomValue(int randomValue) {
		this.randomValue = randomValue;
	}
	
	public boolean checkRange(int userNumber) {
		return (userNumber > lowerBound) && (userNumber < upperBound);
	}

}
