package roles.repairer;

import entities.details.Chassis;
import entities.details.Motor;
import entities.human.Human;

public class Repairer implements RepairChassis, RepairMotor {
	Human human;

	public Repairer(Human human) {
		this.human = human;
	}

	@Override
	public void repairMotor(Motor motor) {
		System.out.println("Repairing " + motor + " ...");

	}

	@Override
	public void repairChassis(Chassis chassis) {
		System.out.println("Repairing " + chassis + " ...");

	}

}
