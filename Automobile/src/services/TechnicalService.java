package services;

import java.time.LocalDate;
import java.util.Arrays;

import entities.details.Chassis;
import entities.details.Motor;
import roles.repairer.RepairChassis;
import roles.repairer.Repairer;
import roles.repairer.RepairMotor;

public class TechnicalService implements RepairChassis, RepairMotor {

	Repairer repairer;
	LocalDate[] inspectionDates;
	boolean isCarInService;

	public TechnicalService(Repairer repairer, LocalDate[] inspectionDates, boolean isCarInService) {
		this.repairer = repairer;
		this.inspectionDates = inspectionDates;
		this.isCarInService = isCarInService;
	}

	public Repairer getRepairer() {
		return repairer;
	}

	public void setRepairer(Repairer repairer) {
		this.repairer = repairer;
	}

	public LocalDate[] getInspectionDates() {
		return inspectionDates;
	}

	public void setInspectionDates(LocalDate[] inspectionDates) {
		this.inspectionDates = inspectionDates;
	}

	public boolean isCarInService() {
		return isCarInService;
	}

	public void setCarInService(boolean isCarInService) {
		this.isCarInService = isCarInService;
	}

	@Override
	public String toString() {
		return "TechnicalService [repairer=" + repairer + ", inspectionDates=" + Arrays.toString(inspectionDates)
				+ ", isCarInService=" + isCarInService + "]";
	}

	@Override
	public void repairMotor(Motor motor) {
		if (isCarInService)
			repairer.repairMotor(motor);
		else {
			System.out.println("You should drive the car to the technical station");
		}
	}

	@Override
	public void repairChassis(Chassis chassis) {
		if (isCarInService) {
			repairer.repairChassis(chassis);
		} else {
			System.out.println("You should drive the car to the technical station");
		}
	}

}
