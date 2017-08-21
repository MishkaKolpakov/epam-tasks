package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dao.HumanDriverLicenseDAO;
import entity.Driver;
import entity.DriverLicense;
import entity.Human;
import entity.HumanToCandidate;

public class DriverHire implements HumanToCandidate {

	private String name;
	private String workPlace;
	private String companyTitle;
	private List<DriverLicense.Category> expectedCategories = new ArrayList<>();

	public DriverHire(String name, String workPlace, String companyTitle) {
		this.name = name;
		this.workPlace = workPlace;
		this.companyTitle = companyTitle;
	}

	public List<DriverLicense.Category> getExpectedCategories() {
		return expectedCategories;
	}

	public void setExpectedCategories(List<DriverLicense.Category> expectedCategories) {
		this.expectedCategories = expectedCategories;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	@Override
	public String getWorkPlace() {
		return workPlace;
	}

	public boolean checkWorkPlace() {
		return getWorkPlace().isEmpty() || getWorkPlace() == null;
	}

	public boolean checkDriverLicense(String name, List<DriverLicense.Category> expectedCategories) {
		for (HumanDriverLicenseDAO key : HumanDriverLicenseDAO.values()) {
			if (key.toString().equals(name.toUpperCase())) {
				if (Arrays.asList(HumanDriverLicenseDAO.valueOf(key.name()).category).containsAll(expectedCategories)) {
					return true;
				} else {
					System.out.println("The candidate doesn`t have expected categories!");
					return false;
				}
			} else {
				System.out.println("The candidate wasn`t found in database!");
				return false;
			}
		}
		return false;
	}

	public boolean checkCandidate(String name, List<DriverLicense.Category> expectedCategories) {
		return checkWorkPlace() && checkDriverLicense(name, expectedCategories);
	}

	public Driver offerCandidate(Human human) {
		if (checkCandidate(name, expectedCategories)) {
			System.out.println("Congratulations you successfully pass the interview");
			return new Driver(name, companyTitle);
		} else {
			throw new RuntimeException("Candidate doesn`t match the requirements");
		}
	}

}
