package controller;

import java.util.Scanner;
import model.derivative.Derivative;
import model.derivative.DerivativeService;
import view.View;

public class Controller {
	Derivative derivative;
	View view;

	public Controller(Derivative derivative, View view) {
		this.derivative = derivative;
		this.view = view;
	}

	public void applicationEngine() {
		Scanner scanner = new Scanner(System.in);
		DerivativeService derivativeService = new DerivativeService(derivative);
		InputScanner inputScanner = new InputScanner(view, scanner);
		Menu menu = new Menu(derivativeService, inputScanner, view);
		menu.menuContext();
	}
}
