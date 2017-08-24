package controller.command.functionality;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import controller.Controller;
import controller.command.ActionCommand;
import controller.manager.ConfigurationManager;
import model.entity.responsibility.individual.IndividualResponsibility;
import model.entity.responsibility.property.PropertyResponsibility;
import model.service.ResponsibilityFillable;
import model.service.other.DerivativePriceSummable;

public class ShowDerivativeCommand implements ActionCommand {

	/**
	 * Method return page with all the information in derivative including
	 * summary price
	 * 
	 * @param request
	 * @return page
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;

		List<IndividualResponsibility> individual = Controller.getModel().getDerivative()
				.getIndividualResponsibilities();
		List<PropertyResponsibility> property = Controller.getModel().getDerivative().getPropertyResponsibilities();

		DerivativePriceSummable summable = Controller.getModel().getDerivativeUtil();
		ResponsibilityFillable fillable = Controller.getModel().getDerivativeUtil();
		BigDecimal summary = summable.getSummaryPrice(fillable.getAllReponsibilities());

		request.setAttribute("individual", individual);
		request.setAttribute("property", property);
		request.setAttribute("summary", summary);

		page = ConfigurationManager.getProperty("path.page.derivative");
		return page;
	}

}
