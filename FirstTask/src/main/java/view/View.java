package view;

import java.util.List;
import model.derivative.DerivativeUtil;
import model.entities.responsibilities.Responsibility;
import model.entities.responsibilities.individual.IndividualResponsibilitiesList;
import model.entities.responsibilities.individual.IndividualResponsibility;
import model.entities.responsibilities.property.PropertyResponsibilitiesList;
import model.entities.responsibilities.property.PropertyResponsibility;
import view.constants.StringConstants;

public class View {

	public void displayMessage(String message) {
		System.out.println(message);
	}

	public void displayMessageWithoutNewLine(String message) {
		System.out.print(message);
	}

	public void displayDerivativeList(IndividualResponsibilitiesList irl) {
		StringBuffer sb = null;
		for (IndividualResponsibility ir : irl) {
			sb = new StringBuffer();
			sb.append(ir.getTitle()).append(StringConstants.PRICE_IS).append(ir.getPrice())
					.append(StringConstants.CURRENCY + ", " + StringConstants.RISK_LEVEL).append(ir.getRiskLevel())
					.append("%. ").append(StringConstants.GROUP + " ").append(ir.isGroup());
			displayMessage(sb.toString());
		}
	}

	public void displayDerivativeList(PropertyResponsibilitiesList prl) {
		StringBuffer sb = null;
		for (PropertyResponsibility pr : prl) {
			sb = new StringBuffer();
			sb.append(pr.getTitle()).append(StringConstants.PRICE_IS).append(pr.getPrice())
					.append(StringConstants.CURRENCY + ", " + StringConstants.RISK_LEVEL).append(pr.getRiskLevel())
					.append("%. ").append(StringConstants.VALUATED + " ").append(pr.isPropertyValueated());
			displayMessage(sb.toString());
		}
	}

	public void displayDerivative(DerivativeUtil derivativeUtil) {
		displayDerivativeList(derivativeUtil.getDerivative().getAvailablePropertyResponsibilities());
		displayDerivativeList(derivativeUtil.getDerivative().getIndividualResponsibilitiesList());
		displayMessage(StringConstants.SUMMARY_PRICE + derivativeUtil.summaryPrice() + StringConstants.CURRENCY);
		displayMessage("");

	}

	public void displaySortedDerivative(List<Responsibility> responsibilities) {
		StringBuffer sb = null;
		for (Responsibility responsibility : responsibilities) {
			sb = new StringBuffer();
			sb.append(responsibility.getTitle()).append(StringConstants.PRICE_IS).append(responsibility.getPrice())
					.append(StringConstants.CURRENCY + ", " + StringConstants.RISK_LEVEL)
					.append(responsibility.getRiskLevel()).append("%.");
			displayMessage(sb.toString());
		}
		displayMessage("");
	}

	public void displayFiltered(List<Responsibility> responsibilities) {
		StringBuffer sb = null;
		for (Responsibility responsibility : responsibilities) {
			sb = new StringBuffer();
			sb.append(responsibility.getTitle()).append(StringConstants.PRICE_IS).append(responsibility.getPrice())
					.append(StringConstants.CURRENCY + ", " + StringConstants.RISK_LEVEL)
					.append(responsibility.getRiskLevel()).append("%");
			displayMessage(sb.toString());
		}
		displayMessage("");
	}

	public void displayCommands() {
		StringBuffer sb = new StringBuffer().append(StringConstants.INVITATION_DERIVATIVE).append("\n")
				.append(StringConstants.SORT_DERIVATIVE).append("\n").append(StringConstants.SEARCH_PRICE).append("\n")
				.append(StringConstants.SEARCH_RISK).append("\n").append(StringConstants.SEARCH_PRICE_RISK).append("\n")
				.append(StringConstants.QUITE);
		displayMessage(sb.toString());
		displayMessageWithoutNewLine(StringConstants.CHOOSE_COMMAND);
	}
}
