package entities.car;

import java.time.LocalDate;
import java.util.List;

public class DriverLicense {
	public enum Category {
		A, B, C, D
	};

	public List<Category> categories;

	LocalDate startLicenseDate;
	LocalDate endLicenseDate;

	public DriverLicense(List<Category> categories, LocalDate startLicenseDate, LocalDate endLicenseDate) {
		this.categories = categories;
		this.startLicenseDate = startLicenseDate;
		this.endLicenseDate = endLicenseDate;
	}

	public DriverLicense(Category category, LocalDate startLicenseDate, LocalDate endLicenseDate) {
		this.categories.add(category);
		this.startLicenseDate = startLicenseDate;
		this.endLicenseDate = endLicenseDate;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public LocalDate getStartLicenseDate() {
		return startLicenseDate;
	}

	public void setStartLicenseDate(LocalDate startLicenseDate) {
		this.startLicenseDate = startLicenseDate;
	}

	public LocalDate getEndLicenseDate() {
		return endLicenseDate;
	}

	public void setEndLicenseDate(LocalDate endLicenseDate) {
		this.endLicenseDate = endLicenseDate;
	}

	@Override
	public String toString() {
		return "DriverLicense [categories=" + categories + ", startLicenseDate=" + startLicenseDate
				+ ", endLicenseDate=" + endLicenseDate + "]";
	}

}
