
public class StateApp {
	public static void main(String[] args) {
		Human human = new Human(new StayOnBeach());
		human.doAction();
		human.changeState();
		human.doAction();
		human.changeState();
		human.doAction();
		human.changeState();
		human.doAction();
	}
}

interface State {
	void doAction(Human human);
}

class StayOnBeach implements State {
	@Override
	public void doAction(Human human) {
		System.out.println("Staying on beach");
	}

}

class StayOnMushroomField implements State {
	@Override
	public void doAction(Human human) {
		System.out.println("Staying on mushroom field");
	}

}

class SeeAnimal implements State {
	@Override
	public void doAction(Human human) {
		System.out.println("Seeing animal");
	}

}

class Human {

	private State state;

	public Human(State state) {
		this.state = state;
	}

	private void setState(State state) {
		this.state = state;
	}

	public void changeState() {
		if (state instanceof StayOnBeach) {
			setState(new StayOnMushroomField());
		} else if (state instanceof StayOnMushroomField) {
			setState(new SeeAnimal());
		} else if (state instanceof SeeAnimal) {
			setState(new StayOnBeach());
		}
	}

	public void doAction() {
		state.doAction(this);
	}

}
