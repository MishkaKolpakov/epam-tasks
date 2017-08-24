package model.entity.responsibility;

import java.math.BigDecimal;

abstract public class Responsibility {
	private String title;
	private Integer riskRate;
	private BigDecimal price;

	public Responsibility(String title, Integer riskRate, BigDecimal price) {
		this.title = title;
		this.riskRate = riskRate;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getRiskRate() {
		return riskRate;
	}

	public void setRiskRate(Integer riskRate) {
		this.riskRate = riskRate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
