package services;

import roles.refueler.ChooseGas;

import roles.refueler.CleanWindow;
import roles.refueler.Refueler;
import roles.refueler.SwapWheel;

public class GasStation implements ChooseGas, CleanWindow, SwapWheel {
	public enum PetrolType {
		A95, A92, Diesel
	};

	Refueler refueler;
	private PetrolType petrolType;
	boolean casIsOnStation;

	public GasStation(Refueler refueler, PetrolType petrolType, boolean casIsOnStation) {
		this.refueler = refueler;
		this.petrolType = petrolType;
		this.casIsOnStation = casIsOnStation;
	}

	public Refueler getRefueler() {
		return refueler;
	}

	public void setRefueler(Refueler refueler) {
		this.refueler = refueler;
	}

	public PetrolType getPetrolType() {
		return petrolType;
	}

	public void setPetrolType(PetrolType petrolType) {
		this.petrolType = petrolType;
	}

	public boolean isCasIsOnStation() {
		return casIsOnStation;
	}

	public void setCasIsOnStation(boolean casIsOnStation) {
		this.casIsOnStation = casIsOnStation;
	}

	@Override
	public String toString() {
		return "GasStation [refueler=" + refueler + ", petrolType=" + petrolType + ", casIsOnStation=" + casIsOnStation
				+ "]";
	}

	@Override
	public void chooseGas(PetrolType petrolType) {
		refueler.chooseGas(petrolType);
	}

	@Override
	public void swapWheel(boolean isHitted) {
		if (isHitted) {
			System.out.println("You should swap the wheel immediately");
		} else {
			System.out.println("Everything alright with wheels on your car");
		}
	}

	@Override
	public void cleanWindow(boolean decision) {
		if (decision) {
			System.out.println("The windows will be cleaned as soon as possible");
		} else {
			System.out.println("You decided that windows clean enough");
		}
	}

}
