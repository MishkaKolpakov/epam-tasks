

import java.util.ArrayList;

public class Model{
	//lower
	private int lowerBound;
	private int upperBound;
	private int randomNumber;
	private ArrayList<Integer> history = new ArrayList<>();
	
	//Constants to determine range
	private final static int MAX_UPPER_BOUND = 100;
	private final static int MIN_LOWER_BOUND = 0;
	private final static int MIN_UPPER_BOUND = MAX_UPPER_BOUND - 1;	
	private final static int MAX_LOWER_BOUND = MIN_LOWER_BOUND + 1;
	
	public boolean gameRegime;
	private int counter = 0;
	private boolean endGame;
	
	public static int getMaxLowerBound() {
		return MAX_LOWER_BOUND;
	}
	
	public boolean isEndGame() {
		return endGame;
	}

	public static int getMIN_UPPER_BOUND() {
		return MIN_UPPER_BOUND;
	}
	
	public static int getMAX_UPPER_BOUND() {
		return MAX_UPPER_BOUND;
	}

	public static int getMIN_LOWER_BOUND() {
		return MIN_LOWER_BOUND;
	}

	public void setRandomNumber(int randomNumber) {
		this.randomNumber = randomNumber;
	}

	public int getUpperBound() {
		return upperBound;
	}
	
	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}
	
	public int getLowerBound() {
		return lowerBound;
	}
	
	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}
	
	/**
	 * This method returns randomize value in determined range
	 * @param min, max
	 * @return randomIntValue */
	public int rand(int min, int max) {
		max -= min;
		return (int) (Math.random() * ++max) + min;
	}
	
	public String processMaxValueDiapason() {
		return "(" + lowerBound + ", 100]";
	}
	
	/**
	 * This method determine the game regime using flag
	 * @param answer 
	 * @return gameRegime */
	public void chooseGameRegime(String answer) {
		if(answer.toUpperCase().equals("YES") || answer.toUpperCase().equals("Y")) gameRegime = true;
	}
		
	/**
	 * This method saves history, number of tries and generate prompt to user
	 * @param value 
	 * @return stringSentence */
	public String gameEngine(int value) {
		history.add(value);
		counter++;
		
		if(value == randomNumber) {
			endGame = true;
			return coungratulations() + "\n"+
					getHistory() + "\n" +
					triesCounter();
		}
		
		else if(value < randomNumber) {
			setLowerBound(value);
			return getHistory() + "\n" + higher();
		}
		
		else {
			setUpperBound(value);
			return getHistory() + "\n" + lower();
		}
		
	}
	
	public String higher() {
		return "The thought of number is higher";
	}
	
	public String lower() {
		return "The thought of number is lower";
	}
	
	public String getHistory() {
		return "The history of tries: " + history.toString();
	}
	
	public String currentDiapason() {
		return "Current diapason is [" + getLowerBound() + ", " + getUpperBound() + "]";
	}
	
	public String triesCounter() {
		return "You made \"" + counter +"\" tries";
	}
	
	public String coungratulations() {
		return "Congratulations you won!!! ";
	}
	
	/**
	 * Check if the value is inside the range
	 * @param tmp, lowerBound, upperBound
	 * @return true if value is in range*/
	public boolean checkRange(int tmp, int lowerBound, int upperBound) {
		return (tmp >= lowerBound) && (tmp <= upperBound);
	}
	
	/**
	 * Check if the sentence is one of determined
	 * @param validValue
	 * @return true if sentence equals to at least on of them*/
	public boolean checkRegime(String validValue) {
		return 	validValue.toUpperCase().equals("YES") || 
				validValue.toUpperCase().equals("Y") || 
				validValue.toUpperCase().equals("NO") || 
				validValue.toUpperCase().equals("N");
	}
	
}
