package controller;

import model.derivative.DerivativeUtil;
import view.View;
import view.constants.StringConstants;

public class Menu {
	private DerivativeUtil derivativeUtil = null;
	private InputScanner inputScanner = null;
	private View view = null;

	public Menu(DerivativeUtil derivativeUtil, InputScanner inputScanner, View view) {
		this.inputScanner = inputScanner;
		this.derivativeUtil = derivativeUtil;
		this.view = view;
	}

	// Main menu engine
	public void menuContext() {
		char command;
		do {
			view.displayCommands();
			command = inputScanner.inputCommand(inputScanner.scanner);
			switch (command) {
			case 'd':
				view.displayDerivative(derivativeUtil);
				break;
			case 's':
				view.displaySortedDerivative(derivativeUtil.sortByRiskLevel());
				break;
			case 'p':
				view.displayFiltered(derivativeUtil.findByPrice(
						inputScanner.inputLongData(inputScanner.scanner, StringConstants.PRICE_FROM, StringConstants.WRONG_LONG_INPUT),
						inputScanner.inputLongData(inputScanner.scanner, StringConstants.PRICE_TO, StringConstants.WRONG_LONG_INPUT)));
				break;
			case 'r':
				view.displayFiltered(derivativeUtil.findByRiskLevel(
						inputScanner.inputIntData(inputScanner.scanner, StringConstants.RISK_FROM, StringConstants.WRONG_INT_INPUT),
						inputScanner.inputIntData(inputScanner.scanner, StringConstants.RISK_TO, StringConstants.WRONG_INT_INPUT)));
				break;
			case 'f':
				view.displayFiltered(derivativeUtil.findByPriceAndRisk(
						inputScanner.inputLongData(inputScanner.scanner, StringConstants.PRICE_FROM, StringConstants.WRONG_LONG_INPUT),
						inputScanner.inputLongData(inputScanner.scanner, StringConstants.PRICE_TO, StringConstants.WRONG_LONG_INPUT),
						inputScanner.inputIntData(inputScanner.scanner, StringConstants.RISK_FROM, StringConstants.WRONG_INT_INPUT),
						inputScanner.inputIntData(inputScanner.scanner, StringConstants.RISK_TO, StringConstants.WRONG_INT_INPUT)));
				break;
			case 'q': view.displayMessage(StringConstants.EXIT);
				break;
			default:
				view.displayMessage(StringConstants.WRONG_COMMAND);
				break;
			}
		} while (command != 'q');
	}
}
