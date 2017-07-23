package com.epam;

import java.util.Scanner;

public class Controller {

	View view;
	Model model;

	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	public void runGame() {
		Scanner scanner = new Scanner(System.in);
		view.displayMessage(view.INTRODUCTION_MESSAGE);

		if (!model.chooseGameRegime(inputGameRegime(scanner))) {
			model.setLowerBound(inputLowerDiapasone(scanner));
			model.setUpperBound(inputHigherDiapasone(scanner));
		}
		model.setRandomValue(model.random(model.getLowerBound(), model.getUpperBound()));

		guessNumber(scanner);
	}

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

	public int inputLowerDiapasone(Scanner sc) {
		view.displayMessage(view.INPUT_LOWER_BOUND);
		view.displayCurrentDiapasone(model);

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

	public int inputHigherDiapasone(Scanner sc) {
		view.displayMessage(view.INPUT_UPPER_BOUND);
		view.displayCurrentDiapasone(model);

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

	public void guessNumber(Scanner sc) {
		view.displayMessage(view.START_GAME);
		view.displayCurrentDiapasone(model);

		while (true) {
			int tmp = inputIntDiapasoneValue(sc);
			view.displayMessage(model.checkUserInput(tmp));
			view.displayHistory(model);
			if (model.isEndGame()) {
				break;
			}
			view.displayCurrentDiapasone(model);
		}
	}
}
