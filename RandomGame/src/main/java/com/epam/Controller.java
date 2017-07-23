package com.epam;

import java.util.Scanner;

public class Controller {

	View view;
	Model model;

	// Initializing model and view
	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	// Work method
	public void runGame() {
		Scanner scanner = new Scanner(System.in);
		view.displayMessage(view.INTRODUCTION_MESSAGE);

		if (!model.chooseGameRegime(inputGameRegime(scanner))) {
			model.setLowerBound(inputLowerDiapason(scanner));
			model.setUpperBound(inputHigherDiapason(scanner));
		}
		model.setRandomValue(model.random(model.getLowerBound(), model.getUpperBound()));

		guessNumber(scanner);
	}

	/**
	 * Method returns user`s value only if it in range and it`s integer else
	 * continue the loop
	 * 
	 * @param scanner
	 * @return tmp
	 */
	public int inputIntDiapasoneValue(Scanner sc) {
		while (true) {
			if (!sc.hasNextInt())
				view.displayMessage(view.WRONG_INT_INPUT);
			else {
				int tmp = sc.nextInt();
				if (model.checkRange(tmp))
					return tmp;
				else {
					view.displayOutOfRange(model);
				}
			}
			sc.nextLine();
		}
	}

	/**
	 * Method returns user`s int value only if lower bound entered correctly 
	 * else continuing the loop
	 * 
	 * @param scanner
	 * @return tmp
	 */
	public int inputLowerDiapason(Scanner sc) {
		view.displayMessage(view.INPUT_LOWER_BOUND);
		view.displayCurrentDiapason(model);

		while (true) {
			int tmp = inputIntDiapasoneValue(sc);
			if (model.checkLowerDifferance(tmp)) {
				return tmp;
			} else {
				view.displayOutOfRange(model);
				continue;
			}
		}
	}

	/**
	 * Method returns user`s int value only if higher bound entered correctly,
	 * else continue the loop
	 * 
	 * @param scanner
	 * @return tmp
	 */
	public int inputHigherDiapason(Scanner sc) {
		view.displayMessage(view.INPUT_UPPER_BOUND);
		view.displayCurrentDiapason(model);

		while (true) {
			int tmp = inputIntDiapasoneValue(sc);
			if (model.checkHigherDifferance(tmp)) {
				return tmp;
			} else {
				view.displayOutOfRange(model);
				continue;
			}
		}
	}

	/**
	 * Method to choose game regime correctly.
	 * 
	 * @param scanner
	 * @return tmp
	 */
	public String inputGameRegime(Scanner sc) {
		while (true) {
			String tmp = sc.nextLine();
			if (model.checkInputRegime(tmp))
				return tmp;
			else {
				view.displayMessage(view.WRONG_YES_NO_INPUT);
				continue;
			}
		}
	}

	/**
	 * Game play method where user try to guess thought of number.
	 * User get output prompts about where number is ("lower", "higher").
	 * 
	 * @param scanner
	 */
	public void guessNumber(Scanner sc) {
		view.displayMessage(view.START_GAME);
		view.displayCurrentDiapason(model);

		while (true) {
			int tmp = inputIntDiapasoneValue(sc);
			view.displayMessage(model.checkUserInput(tmp));
			view.displayHistory(model);
			if (model.isEndGame()) {
				break;
			}
			view.displayCurrentDiapason(model);
		}
	}
}
