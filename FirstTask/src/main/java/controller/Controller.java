package controller;

import java.util.Scanner;
import model.derivative.Derivative;
import model.derivative.DerivativeUtil;
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
		DerivativeUtil derivativeUtil = new DerivativeUtil(derivative);
		InputScanner inputScanner = new InputScanner(view, scanner);
		Menu menu = new Menu(derivativeUtil, inputScanner, view);
		menu.menuContext();
	}
}
