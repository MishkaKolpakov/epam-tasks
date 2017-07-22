package com.epam;

public class Main {
	public static void main(String arg[]) {
		Model model = new Model();
		View view = new View();

		Controller controller = new Controller(view, model);
		controller.runGame();
	}

}
