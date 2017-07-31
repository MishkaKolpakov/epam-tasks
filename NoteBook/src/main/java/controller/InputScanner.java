package controller;

import java.util.Map;
import java.util.Scanner;

import exceptions.UniqueNicknameException;
import model.Model;
import view.View;

public class InputScanner {
	View view;
	Model model;

	// Initialization of view and model
	public InputScanner(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	/**
     * Check the regex and input
     * return true if matche and false if not
     * @param input, value
     * @return boolean
     */
	public static boolean regexCheck(String input, String regex) {
		return input.matches(regex);
	}

	public String userDataInput(Scanner scanner, String invitation, String regex) {
		view.displayMessage(invitation);
		String input;
		while (true) {
			input = scanner.nextLine();
			if (regexCheck(input, regex)) {
				return input;
			} else {
				view.displayMessage(View.WRONG_INPUT);
				view.displayMessage(invitation);
				continue;
			}
		}
	}

	
	public String userTryAgain(Scanner scanner, String invitation) {
		view.displayMessage(invitation);
		String input;
		while (true) {
			input = scanner.nextLine();
			if (model.checkTryAgainInput(input)) {
				return input;
			} else {
				view.displayMessage(View.WRONG_TRY_AGAIN_INPUT);
				view.displayMessage(invitation);
				continue;
			}
		}
	}

	public void inputEngine(Scanner scanner, InviteRegexMap irm) throws UniqueNicknameException {
		int i = 0;
		irm.inviteRegexSaver();

		for (Map.Entry<String, String> m : irm.inviteRegex.entrySet()) {
			model.setUserData(i, userDataInput(scanner, m.getKey(), m.getValue()));
			i++;
		}

	}

}
