package view;

import model.Model;
import model.Entity.Note;

public class View {

	public static String WRONG_INPUT = "Wrong input doesn`t match with regex";
	public static String WRONG_TRY_AGAIN_INPUT = "The format [Yes/y] or [No/n]";

	public void displayMessage(String message) {
		System.out.println(message);
	}

	public void displayNotes(Model model) {
	
		StringBuffer sb = new StringBuffer();
		
		for (Note note : model.getNoteBook()) {
			sb.append("\n").append(note.getLastName()).append(" ").append(note.getFirstName().charAt(0)).append(".")
					.append(" Nickname: ").append(note.getNickName()).append("\nCommentary: ")
					.append(note.getCommentary()).append("\nHome phone number: ").append(note.getHomePhoneNumber())
					.append("\nMobile phone number: ").append(note.getMobilePhoneNumber())
					.append("\nAlternative number: ").append(note.getAlternativephoneNumber()).append("\nEmail: ")
					.append(note.getEmail()).append("\nSkype: ").append(note.getSkype()).append("\nAddress: ")
					.append(note.getAddress().getFullAddress()).append("\n").append(note.getCreatedDate());
			displayMessage(sb.toString());
		}
	}
}
