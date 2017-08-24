package model.service;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import controller.exceptions.IllegalSearchArguments;
import model.entity.derivative.Derivative;
import model.entity.responsibility.Responsibility;
import model.service.find.RiskRatePriceFilter;
import model.service.find.RiskRatePriceFindable;
import model.service.order.DerivativeOrder;
import model.service.order.RiskRateSortable;
import model.service.other.DerivativePriceSummable;
import model.service.other.DerivativeSummaryPrice;

public class DerivativeUtil
		implements DerivativePriceSummable, RiskRateSortable, RiskRatePriceFindable, ResponsibilityFillable {

	private Derivative derivative;

	public DerivativeUtil(Derivative derivative) {
		this.derivative = derivative;
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
		RiskRatePriceFilter filter = new RiskRatePriceFilter();
		return filter.findByRiskRateAndPrice(responsibilities, riskLowerBound, riskUpperBound, priceLowerBound,
				priceUpperBound);
	}

	/**
	 * Method returning order list by risk rate
	 * 
	 * @param reponsibilities
	 * @return List<Responsibility> orderedValue
	 **/
	@Override
	public List<Responsibility> orderByRiskLevel(List<Responsibility> responsibilities) {
		RiskRateSortable order = new DerivativeOrder();
		return order.orderByRiskLevel(responsibilities);
	}

	/**
	 * Method returning sum of responsibilities` prices
	 * 
	 * @param reponsibilities
	 * @return BigDecimal sum
	 **/
	@Override
	public BigDecimal getSummaryPrice(List<Responsibility> responsibilities) {
		DerivativePriceSummable derivativeSum = new DerivativeSummaryPrice();
		return derivativeSum.getSummaryPrice(responsibilities);
	}

	/**
	 * Method which fill list with same fields of property and individual
	 * responsibilities
	 * 
	 * @return derivativeResponsibilities
	 */
	@Override
	public List<Responsibility> getAllReponsibilities() {
		List<Responsibility> derivativeResponsibilities = new ArrayList<>();
		derivativeResponsibilities.addAll(derivative.getIndividualResponsibilities());
		derivativeResponsibilities.addAll(derivative.getPropertyResponsibilities());
		return derivativeResponsibilities;
	}

}
