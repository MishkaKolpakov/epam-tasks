package controller.command.functionality;

import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import controller.Controller;
import controller.command.ActionCommand;
import controller.manager.ConfigurationManager;
import model.entity.responsibility.Responsibility;
import model.service.ResponsibilityFillable;
import model.service.order.RiskRateSortable;
import model.service.other.DerivativePriceSummable;

public class ShowSortedByRiskCommand implements ActionCommand {

	/**
	 * Method dispatcher to page with ordered by risk rate data
	 * 
	 * @param request
	 * @return page
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;

		DerivativePriceSummable summ = Controller.getModel().getDerivativeUtil();
		RiskRateSortable order = Controller.getModel().getDerivativeUtil();
		ResponsibilityFillable fillDerivative = Controller.getModel().getDerivativeUtil();

		List<Responsibility> sortedList = order.orderByRiskLevel(fillDerivative.getAllReponsibilities());

		BigDecimal summary = summ.getSummaryPrice(fillDerivative.getAllReponsibilities());

		request.setAttribute("ordered", sortedList);
		request.setAttribute("summary", summary);

		page = ConfigurationManager.getProperty("path.page.ordered");
		return page;
	}

}
