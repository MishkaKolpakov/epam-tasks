package controller;

import java.util.Scanner;

import model.Model;
import view.View;

public class Controller {
	View view;
	Model model;

	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;

	}

	public void proccessUser() {
		Scanner scanner = new Scanner(System.in);
		InviteRegexMap irm = new InviteRegexMap();
		InputScanner inputScanner = new InputScanner(view, model);
		inputScanner.inputEngine(scanner, irm);
	}
}
