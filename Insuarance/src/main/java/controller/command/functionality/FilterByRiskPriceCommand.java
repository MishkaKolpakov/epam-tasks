package controller.command.functionality;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import controller.Controller;
import controller.command.ActionCommand;
import controller.exceptions.IllegalSearchArguments;
import controller.manager.ConfigurationManager;
import controller.manager.MessageManager;
import model.entity.responsibility.Responsibility;
import model.service.ResponsibilityFillable;
import model.service.find.RiskRatePriceFindable;

public class FilterByRiskPriceCommand implements ActionCommand {

	/**
	 * Method for processing input data, and dispatcher to page with filtered
	 * data
	 * 
	 * @param request
	 * @return page
	 **/
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		try {
			List<Responsibility> filteredDerivative = filterByRiskPriceCommand(request);
			request.setAttribute("filter", filteredDerivative);
			page = ConfigurationManager.getProperty("path.page.filter");
		} catch (IllegalSearchArguments isa) {
			request.setAttribute("illegalInput", MessageManager.getProperty("message.wrongarguments"));
			page = ConfigurationManager.getProperty("path.page.index");
		} catch (NumberFormatException e) {
			request.setAttribute("emptyInput", MessageManager.getProperty("message.emptyarguments"));
			page = ConfigurationManager.getProperty("path.page.index");
		}
		return page;
	}

	/**
	 * Private method for separating input process from dispatcher process
	 * 
	 * @param request
	 * @return page
	 **/
	private List<Responsibility> filterByRiskPriceCommand(HttpServletRequest request) throws IllegalSearchArguments {

		Integer riskLowerBound = Integer.parseInt(request.getParameter("riskLowerBound"));
		Integer riskUpperBound = Integer.parseInt(request.getParameter("riskUpperBound"));

		BigDecimal priceLowerBound = new BigDecimal(request.getParameter("priceLowerBound"));
		BigDecimal priceUpperBound = new BigDecimal(request.getParameter("priceUpperBound"));

		RiskRatePriceFindable find = Controller.getModel().getDerivativeUtil();
		ResponsibilityFillable fill = Controller.getModel().getDerivativeUtil();

		List<Responsibility> result = null;

		result = find.findByRiskRateAndPrice(fill.getAllReponsibilities(), riskLowerBound, riskUpperBound,
				priceLowerBound, priceUpperBound);
		return result;
	}

}
