package com.epam;

import java.util.ArrayList;
import com.epam.interfaces.Constants;

public class Model {
	private int lowerBound = Constants.LOWER_BOUND;
	private int upperBound = Constants.UPPER_BOUND;
	private int randomValue;
	boolean endGame;
	private ArrayList<Integer> triesHistory = new ArrayList<>();

	public ArrayList<Integer> getTriesHistory() {
		return triesHistory;
	}

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

	public int random(int lowerBound, int upperBound) {
		int tmp = (int) (Math.random() * (upperBound - lowerBound)) + lowerBound;
		if (tmp == lowerBound) {
			tmp++;
		}
		return tmp;
	}

	public boolean checkRange(int userNumber) {
		return (userNumber > lowerBound) && (userNumber < upperBound);
	}

	public boolean checkInputRegime(String regime) {
		return regime.toUpperCase().equals("YES") || regime.toUpperCase().equals("Y")
				|| regime.toUpperCase().equals("NO") || regime.toUpperCase().equals("N");
	}

	public boolean chooseGameRegime(String regime) {
		if (regime.toUpperCase().equals("YES") || regime.toUpperCase().equals("Y")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkLowerDifferance(int value) {
		return (value < Constants.UPPER_BOUND - Constants.DIFFERANCE);
	}

	public boolean checkHigherDifferance(int value) {
		return (value >= lowerBound + Constants.DIFFERANCE);
	}

	public String checkUserInput(int number) {
		triesHistory.add(number);
		if (number == randomValue) {
			endGame = true;
			return Constants.CONGRATULATIONS;
		} else {
			if (number > randomValue) {
				upperBound = number;
				return Constants.LOWER;
			} else {
				lowerBound = number;
				return Constants.HIGHER;
			}
		}
	}
}
