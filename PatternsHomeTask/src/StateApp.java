
public class StateApp {
	public static void main(String[] args) {
		Human human = new Human();
		human.setState(new StayOnBeach());
		human.doAction();
		human.setState(new SeeAnimal());
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

	public void setState(State state) {
		this.state = state;
	}

	public void doAction() {
		state.doAction(this);
	}

}
