import java.util.HashSet;
import java.util.Set;

public class StrategyApp {

	public static void main(String[] args) {
		HumanStr humanStr = new HumanStr();
		humanStr.addState(new StayOnBeachStr());
		humanStr.addState(new SeeAnimalStr());

		humanStr.doAction();
	}

}

interface StateStr {
	void doAction(HumanStr human);
}

class StayOnBeachStr implements StateStr {
	@Override
	public void doAction(HumanStr human) {
		System.out.println("Staying on beach");
	}

}

class StayOnMushroomFieldStr implements StateStr {
	@Override
	public void doAction(HumanStr human) {
		System.out.println("Staying on mushroom field");
	}

}

class SeeAnimalStr implements StateStr {
	@Override
	public void doAction(HumanStr human) {
		System.out.println("Seeing animal");
	}

}

class HumanStr {

	private Set<StateStr> states = new HashSet<>();

	public void addState(StateStr state) {
		states.add(state);
	}

	public void doAction() {
		for (StateStr state : states) {
			state.doAction(this);
		}
	}

}
