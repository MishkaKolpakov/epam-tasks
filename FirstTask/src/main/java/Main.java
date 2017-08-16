import controller.Controller;
import model.derivative.Derivative;
import view.View;

public class Main {
	public static void main(String[] args) {
		Controller controller = new Controller(new Derivative("First derivative"), new View());
		controller.applicationEngine();
	}
}
