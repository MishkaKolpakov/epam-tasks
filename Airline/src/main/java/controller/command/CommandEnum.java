package controller.command;

import controller.command.authentication.LoginCommand;
import controller.command.authentication.LogoutCommand;
import controller.command.authentication.RegistrationCommand;
import controller.command.service.AboutCommand;
import controller.command.service.AddCommand;
import controller.command.service.BuyCommand;
import controller.command.service.FindCommand;
import controller.command.service.LanguageCommand;
import controller.command.service.OrderCommand;
import controller.command.service.ServiceCommand;
import controller.command.service.TicketCommand;
import model.service.AddFlightService;
import model.service.BuyService;
import model.service.FindService;
import model.service.FlightService;
import model.service.LoginService;
import model.service.OrderService;
import model.service.RegistrationService;
import model.service.TicketService;
import controller.command.service.ShowOrderCommand;
import controller.command.service.ProfileCommand;

public enum CommandEnum {
	LOGIN {
		{
			this.command = new LoginCommand(LoginService.getInstance());
		}
	},
	LOGOUT {
		{
			this.command = new LogoutCommand();
		}
	},
	REGISTRATION {
		{
			this.command = new RegistrationCommand(RegistrationService.getInstance());
		}
	},
	PROFILE {
		{
			this.command = new ProfileCommand();
		}
	},
	ABOUT {
		{
			this.command = new AboutCommand();
		}
	},
	ADD {
		{
			this.command = new AddCommand(AddFlightService.getInstance());
		}
	},
	BOOK {
		{
			this.command = new ServiceCommand(FlightService.getInstance());
		}
	},
	ORDERS {
		{
			this.command = new ShowOrderCommand(OrderService.getInstance());
		}
	},
	ORDER {
		{
			this.command = new OrderCommand(OrderService.getInstance());
		}
	},
	TICKET {
		{
			this.command = new TicketCommand(TicketService.getInstance());
		}
	},
	FIND {
		{
			this.command = new FindCommand(FindService.getInstance());
		}
	},
	LANGUAGE {
		{
			this.command = new LanguageCommand();
		}
	},
	BUY {
		{
			this.command = new BuyCommand(BuyService.getInstance(), OrderService.getInstance());
		}
	};

	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}
}
