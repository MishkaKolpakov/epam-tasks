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
			model.setLowerBound(inputDiapasone(scanner, view.INPUT_LOWER_BOUND));
			model.setUpperBound(inputDiapasone(scanner, view.INPUT_UPPER_BOUND));
		}
		model.setRandomValue(model.random(model.getLowerBound(), model.getUpperBound()));

		inputUserNumber(scanner);
	}

	public int inputDiapasone(Scanner sc, String invitation) {
		view.displayMessage(invitation);
		view.displayCurrentDiapasone(model);

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

	public void inputUserNumber(Scanner sc) {
		view.displayMessage(view.START_GAME);
		view.displayCurrentDiapasone(model);

		while (true) {
			if (!sc.hasNextInt()) {
				view.displayMessage(view.WRONG_INT_INPUT);
			} else {
				int tmp = sc.nextInt();
				if (model.checkRange(tmp)) {
					view.displayMessage(model.checkUserInput(tmp));
					view.displayHistory(model);
					if (model.endGame) {
						break;
					}
					view.displayCurrentDiapasone(model);
				} else {
					view.displayOutOfRange(model);
				}
			}
		}
	}
}
