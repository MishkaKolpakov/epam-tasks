package com.epam;

public class Controller {

	View view;
	Model model;

	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	public void runGame() {
		view.displayMessage(message);
	}
}
