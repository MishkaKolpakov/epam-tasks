package dao;

import static entity.DriverLicense.Category.*;

import entity.DriverLicense;

public enum HumanDriverLicenseDAO {
	IVANOV(A, B, C), PETROV(D, C), SIDOROV(B);

	public DriverLicense.Category[] category;

	HumanDriverLicenseDAO(DriverLicense.Category... category) {
		this.category = category;
	}
}
