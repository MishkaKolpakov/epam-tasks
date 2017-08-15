package controller;

import java.util.Scanner;

import view.View;

public class InputScanner {
	View view = null;
	Scanner scanner = null;

	public InputScanner(View view, Scanner scanner) {
		this.view = view;
		this.scanner = scanner;
	}

	public int inputIntData(Scanner scanner, String invitation, String warning) {
		do {
			view.displayMessage(invitation);
			if (scanner.hasNextInt())
				break;
			view.displayMessage(warning);
			scanner.next();
		} while (true);
		return scanner.nextInt();
	}

	public long inputLongData(Scanner scanner, String invitation, String warning) {
		do {
			view.displayMessage(invitation);
			if (scanner.hasNextLong())
				break;
			view.displayMessage(warning);
			scanner.next();
		} while (true);
		return scanner.nextLong();
	}

	public char inputCommand(Scanner scanner) {
		while (!scanner.hasNext()) {
			scanner.next();
		}
		return scanner.next().charAt(0);
	}

}
