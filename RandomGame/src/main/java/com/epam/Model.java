package com.epam;

import java.util.ArrayList;
import com.epam.interfaces.Constants;

public class Model {
	private int lowerBound = Constants.LOWER_BOUND;
	private int upperBound = Constants.UPPER_BOUND;
	private int randomValue;
	private boolean endGame;

	public boolean isEndGame() {
		return endGame;
	}

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

	/**
	 * Random method uses to generate random value in determined range
	 * To exclude lower bound value makes increment operation
	 * @param lowerBound, upperBound
	 * @return tmp
	 */
	public int random(int lowerBound, int upperBound) {
		int tmp = (int) (Math.random() * (upperBound - lowerBound)) + lowerBound;
		if (tmp == lowerBound) {
			tmp++;
		}
		return tmp;
	}
	
	/**
	 * Method check the entered value if it`s in range
	 * @param userNumber
	 * @return boooleanValue
	 */
	public boolean checkRange(int userNumber) {
		return (userNumber > lowerBound) && (userNumber < upperBound);
	}

	/**
	 * Method used to made user input of values ("yes", "no", "y", "n")
	 * @param regime
	 * @return boooleanValue
	 */
	public boolean checkInputRegime(String regime) {
		return regime.toUpperCase().equals("YES") || regime.toUpperCase().equals("Y")
				|| regime.toUpperCase().equals("NO") || regime.toUpperCase().equals("N");
	}
	
	/**
	 * Method checks which game regime user chosen
	 * @param regime
	 * @return boooleanValue
	 */
	public boolean chooseGameRegime(String regime) {
		if (regime.toUpperCase().equals("YES") || regime.toUpperCase().equals("Y")) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Method exclude input of lower bound that makes impossible range of 10 numbers
	 * @param inputValue
	 * @return boooleanValue
	 */
	public boolean checkLowerDifferance(int inputValue) {
		return (inputValue < Constants.UPPER_BOUND - Constants.DIFFERENCE);
	}
	
	/**
	 * Method exclude input of upper bound to make at least range of 10 numbers
	 * @param inputValue
	 * @return boooleanValue
	 */
	public boolean checkHigherDifferance(int inputValue) {
		return (inputValue >= lowerBound + Constants.DIFFERENCE);
	}
	
	/**
	 * Method return prompts to user where number is
	 * if user guessed number the game ends;
	 * @param number
	 * @return stringContant
	 */
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
