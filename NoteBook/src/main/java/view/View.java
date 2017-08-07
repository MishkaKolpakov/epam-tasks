package view;

import model.Model;
import model.Entity.Note;

public class View {
	// Console output method
	public void displayMessage(String message) {
		System.out.println(message);
	}

	// Output all the notes
	public void displayNotes(Model model) {
		for (Note note : model.getNoteBook()) {
			displayMessage(model.prepareOutput(note));
		}
	}
}
