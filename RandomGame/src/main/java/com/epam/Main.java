package com.epam;

public class Main {
	public static void main(String arg[]) {
		// Creating objects
		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(view, model);
		
		// Run the method that starts game
		controller.runGame();
	}

}
