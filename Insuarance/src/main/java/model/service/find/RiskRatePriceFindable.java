package model.service.find;

import java.math.BigDecimal;

import java.util.List;
import controller.exceptions.IllegalSearchArguments;
import model.entity.responsibility.Responsibility;

public interface RiskRatePriceFindable {
	List<Responsibility> findByRiskRateAndPrice(List<Responsibility> responsibilities, Integer riskLowerBound,
			Integer riskUpperBound, BigDecimal priceLowerBound, BigDecimal priceUpperBound) throws IllegalSearchArguments;
}
