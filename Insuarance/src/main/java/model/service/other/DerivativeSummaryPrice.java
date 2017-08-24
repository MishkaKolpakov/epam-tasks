package model.service.other;

import java.math.BigDecimal;
import java.util.List;

import model.entity.responsibility.Responsibility;

public class DerivativeSummaryPrice implements DerivativePriceSummable {

	/**
	 * Method returning sum of responsibilities` prices
	 * 
	 * @param reponsibilities
	 * @return BigDecimal sum
	 */
	@Override
	public BigDecimal getSummaryPrice(List<Responsibility> responsibilities) {
		BigDecimal summaryPrice = new BigDecimal(0);
		for (Responsibility responsibility : responsibilities) {
			summaryPrice = summaryPrice.add(responsibility.getPrice());
		}
		return summaryPrice;
	}

}
