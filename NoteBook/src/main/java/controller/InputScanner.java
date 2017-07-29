package controller;

import java.util.Map;
import java.util.Scanner;

import model.Model;
import view.View;

public class InputScanner {
	View view;
	Model model;

	public InputScanner(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	private boolean regexCheck(String input, String regex) {
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

	public void inputEngine(Scanner scanner, InviteRegexMap irm) {
		irm.inviteRegexSaver();
		for (Map.Entry<String, String> m : irm.inviteRegex.entrySet())
			userDataInput(scanner, m.getKey(), m.getValue());

	}

}
