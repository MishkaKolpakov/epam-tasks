package model.service.find;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import controller.exceptions.IllegalSearchArguments;
import model.entity.responsibility.Responsibility;

public class RiskRatePriceFilter implements RiskRatePriceFindable {

	/**
	 * Method which check price range
	 * 
	 * @return booleanValue
	 */
	private boolean checkDiapason(Responsibility responsibility, BigDecimal lowerPrice, BigDecimal upperPrice) {
		return (responsibility.getPrice().compareTo(lowerPrice) > -1
				&& responsibility.getPrice().compareTo(upperPrice) < 1);
	}

	/**
	 * Method which check risk range
	 * 
	 * @return booleanValue
	 */
	private boolean checkDiapason(Responsibility responsibility, Integer lowerRisk, Integer upperRisk) {
		return (responsibility.getRiskRate() >= lowerRisk && responsibility.getRiskRate() <= upperRisk);
	}

	/**
	 * Method which check both price and risk ranges
	 * 
	 * @return booleanValue
	 */
	private boolean checkFullDiapason(Responsibility responsibility, Integer lowerRisk, Integer upperRisk,
			BigDecimal lowerPrice, BigDecimal upperPrice) {
		return checkDiapason(responsibility, lowerRisk, upperRisk)
				&& checkDiapason(responsibility, lowerPrice, upperPrice);
	}
	
	/**
	 * Method returning filtered list by risk and price
	 * 
	 * @param reponsibilities,
	 *            riskLowerBound, riskUpperBound, priceLowerBound,
	 *            priceUpperBound
	 * @return List<Responsibility> filteredValue
	 **/
	@Override
	public List<Responsibility> findByRiskRateAndPrice(List<Responsibility> responsibilities, Integer riskLowerBound,
			Integer riskUpperBound, BigDecimal priceLowerBound, BigDecimal priceUpperBound)
			throws IllegalSearchArguments {

		Objects.requireNonNull(responsibilities);

		if (riskLowerBound >= riskUpperBound || priceLowerBound.compareTo(priceUpperBound) > -1 || riskLowerBound < 0
				|| riskUpperBound > 100 || priceLowerBound.compareTo(new BigDecimal(0)) < 0) {
			throw new IllegalSearchArguments("Uncorrect arguments entered.");
		}

		List<Responsibility> temporary = new ArrayList<>();
		for (Responsibility responsibility : responsibilities) {
			if (checkFullDiapason(responsibility, riskLowerBound, riskUpperBound, priceLowerBound, priceUpperBound)) {
				temporary.add(responsibility);
			}
		}
		return temporary;
	}

}
