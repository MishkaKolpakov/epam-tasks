package controller;

import model.derivative.DerivativeService;
import view.StringConstants;
import view.View;

public class Menu {
	private DerivativeService derivativeService = null;
	private InputScanner inputScanner = null;
	private View view = null;

	public Menu(DerivativeService derivativeService, InputScanner inputScanner, View view) {
		this.inputScanner = inputScanner;
		this.derivativeService = derivativeService;
		this.view = view;
	}

	// Main menu engine
	public void menuContext() {
		char command;
		do {
			view.displayCommands();
			command = inputScanner.inputCommand(inputScanner.scanner);
			switch (command) {
			case 'p':
				view.displayFiltered(derivativeService.findByPrice(
						inputScanner.inputLongData(inputScanner.scanner, StringConstants.PRICE_FROM,
								StringConstants.WRONG_LONG_INPUT),
						inputScanner.inputLongData(inputScanner.scanner, StringConstants.PRICE_TO,
								StringConstants.WRONG_LONG_INPUT)));
				break;
			case 'r':
				view.displayFiltered(derivativeService.findByRiskLevel(
						inputScanner.inputIntData(inputScanner.scanner, StringConstants.RISK_FROM,
								StringConstants.WRONG_INT_INPUT),
						inputScanner.inputIntData(inputScanner.scanner, StringConstants.RISK_TO,
								StringConstants.WRONG_INT_INPUT)));
				break;
			case 'f':
				view.displayFiltered(derivativeService.findByPriceAndRisk(
						inputScanner.inputLongData(inputScanner.scanner, StringConstants.PRICE_FROM,
								StringConstants.WRONG_LONG_INPUT),
						inputScanner.inputLongData(inputScanner.scanner, StringConstants.PRICE_TO,
								StringConstants.WRONG_LONG_INPUT),
						inputScanner.inputIntData(inputScanner.scanner, StringConstants.RISK_FROM,
								StringConstants.WRONG_INT_INPUT),
						inputScanner.inputIntData(inputScanner.scanner, StringConstants.RISK_TO,
								StringConstants.WRONG_INT_INPUT)));
				break;
			case 'd':
				view.displayDerivative(derivativeService);
				break;
			case 's':
				view.displaySortedDerivative(derivativeService.sortByRiskLevel());
				break;
			case 'q':
				break;
			default:
				view.displayMessage(StringConstants.WRONG_COMMAND);
				break;
			}
		} while (command != 'q');
		view.displayMessage(StringConstants.EXIT);
	}
}
