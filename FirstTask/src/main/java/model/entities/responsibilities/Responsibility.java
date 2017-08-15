package model.entities.responsibilities;

public abstract class Responsibility {
	private int riskLevel;
	private long price;
	private String title;

	public Responsibility(String title, int riskLevel, long price) {
		this.price = price;
		this.title = title;
		this.riskLevel = riskLevel;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(int riskLevel) {
		this.riskLevel = riskLevel;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
}
