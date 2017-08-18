package roles.refueler;

import entities.human.Human;
import services.GasStation.PetrolType;

public class Refueler implements ChooseGas {

	Human human;

	public Refueler(Human human) {
		this.human = human;
	}

	public Human getHuman() {
		return human;
	}

	public void setHuman(Human human) {
		this.human = human;
	}

	@Override
	public void chooseGas(PetrolType petrolType) {
		System.out.println("You choosen " + petrolType);
	}

}
