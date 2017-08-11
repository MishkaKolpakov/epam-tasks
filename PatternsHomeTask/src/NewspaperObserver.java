import java.util.ArrayList;
import java.util.List;

public class NewspaperObserver {
	public static void main(String[] args) {
		NewspaperSite newspaperSite = new NewspaperSite();
		Observer firstSubscriber = new Subscriber("Mykhailo");
		Observer secondSubscriber = new Subscriber("Anton");

		newspaperSite.addObserver(firstSubscriber);
		newspaperSite.addObserver(secondSubscriber);

		newspaperSite.sendNewspaper("Guardian");
		newspaperSite.sendNewspaper("Times");
		

	}
}

interface Observer {
	void handleEvent(String newspaper);
}

interface Observed {

	void addObserver(Observer observer);

	void removeObserver(Observer observer);

	void notifyObserver();

}

class Subscriber implements Observer {

	String name;

	public Subscriber(String name) {
		super();
		this.name = name;
	}

	@Override
	public void handleEvent(String newspaper) {
		System.out.println("Dear subscriber " + name + " here is your fresh newspaper " + newspaper);
	}

}

class NewspaperSite implements Observed {

	List<Observer> subscribers = new ArrayList<>();
	String newspaper;

	public void sendNewspaper(String title) {
		this.newspaper = title;
		notifyObserver();
	}

	@Override
	public void addObserver(Observer observer) {
		subscribers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		subscribers.remove(observer);
	}

	@Override
	public void notifyObserver() {
		for (Observer observer : subscribers) {
			observer.handleEvent(newspaper);
		}
	}

}
