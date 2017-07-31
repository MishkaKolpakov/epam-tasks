package view;

import model.Model;
import model.Entity.Note;

public class View {
	// String wrong input constants
	public static String WRONG_INPUT = "Wrong input doesn`t match with regex";
	public static String WRONG_TRY_AGAIN_INPUT = "The format [Yes/y] or [No/n]";

	// Console output method
	public void displayMessage(String message) {
		System.out.println(message);
	}

	//Output all the notes
	public void displayNotes(Model model) {
		for (Note note : model.getNoteBook()) {
			displayMessage(model.output(note));
		}
	}
}
