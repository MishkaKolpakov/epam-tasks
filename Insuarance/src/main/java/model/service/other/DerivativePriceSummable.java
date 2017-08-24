package model.service.other;

import java.math.BigDecimal;
import java.util.List;

import model.entity.responsibility.Responsibility;

public interface DerivativePriceSummable {
	BigDecimal getSummaryPrice(List<Responsibility> responsibilities);
}
