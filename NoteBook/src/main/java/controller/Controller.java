package controller;

import java.util.Scanner;

import exceptions.UniqueNicknameException;
import model.Model;
import view.StringConstants;
import view.View;

public class Controller {
	View view;
	Model model;

	// Initialization of view and model
	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	// Work method
	public void proccessUser() {
		Scanner scanner = new Scanner(System.in);
		InviteRegexMap irm = new InviteRegexMap();
		InputScanner inputScanner = new InputScanner(view, model);
		
		do {
			try {
				inputScanner.inputEngine(scanner, irm);
			} catch (UniqueNicknameException e) {
				view.displayMessage(StringConstants.UNIQUE_NAME_EXCEPTION);
			}
		} while (model.isTryAgain());
		
		view.displayNotes(model);
	}
}
