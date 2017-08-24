package controller.command;

import controller.command.functionality.FilterByRiskPriceCommand;
import controller.command.functionality.MainMenuCommand;
import controller.command.functionality.ShowDerivativeCommand;
import controller.command.functionality.ShowSortedByRiskCommand;

public enum CommandEnum {

	SHOW_DERIVATIVE {
		{
			this.command = new ShowDerivativeCommand();
		}
	},
	SHOW_ORDERED {
		{
			this.command = new ShowSortedByRiskCommand();

		}
	},
	FILTER_DERIVATIVE {
		{
			this.command = new FilterByRiskPriceCommand();
		}
	},
	BACK {
		{
			this.command = new MainMenuCommand();
		}

	};

	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}
}
