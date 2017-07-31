package model;

import java.util.ArrayList;
import java.util.Date;

import exceptions.UniqueNicknameException;
import model.Entity.Address;
import model.Entity.Note;

public class Model {
	private Note note;
	private Address address;
	private ArrayList<Note> noteBook = new ArrayList<>();
	private StringBuffer sb;

	public ArrayList<Note> getNoteBook() {
		return noteBook;
	}

	public void setUserData(int index, String input) throws UniqueNicknameException {
		switch (index) {
		case 0:
			note = new Note();
			address = new Address();
			note.setLastName(input);
			break;
		case 1:
			note.setFirstName(input);
			break;
		case 2:
			note.setMiddleName(input);
			break;
		case 3:
			if (input.equals("misha"))
				throw new UniqueNicknameException();
			else {
				note.setNickName(input);
			}
			break;
		case 4:
			note.setCommentary(input);
			break;
		case 5:
			note.setGroup(input);
			break;
		case 6:
			note.setHomePhoneNumber(input);
			break;
		case 7:
			note.setMobilePhoneNumber(input);
			break;
		case 8:
			note.setAlternativephoneNumber(input);
			break;
		case 9:
			note.setEmail(input);
			break;
		case 10:
			note.setSkype(input);
			break;
		case 11:
			address.setPostIndex(input);
			break;
		case 12:
			address.setCity(input);
			break;
		case 13:
			address.setStreet(input);
			break;
		case 14:
			address.setHouseNumber(input);
			break;
		case 15:
			address.setFlatNumber(input);
			note.setCreatedDate(new Date());
			note.setAddress(address);
			noteBook.add(note);
			break;
		}
	}

	public boolean checkTryAgainInput(String input) {
		return (input.toLowerCase().equals("yes") || input.toLowerCase().equals("y") || input.toLowerCase().equals("no")
				|| input.toLowerCase().equals("n"));
	}

	public boolean tryAgain(String input) {
		if (input.toLowerCase().equals("yes") || input.toLowerCase().equals("y"))
			return true;
		else
			return false;
	}

	public String prepareOutput(Note note) {
		sb = new StringBuffer();
		return sb.append("\n").append(note.getLastName()).append(" ").append(note.getFirstName().charAt(0)).append(".")
				.append(" Nickname: ").append(note.getNickName()).append("\nCommentary: ").append(note.getCommentary())
				.append("\nHome phone number: ").append(note.getHomePhoneNumber()).append("\nMobile phone number: ")
				.append(note.getMobilePhoneNumber()).append("\nAlternative number: ")
				.append(note.getAlternativephoneNumber()).append("\nEmail: ").append(note.getEmail())
				.append("\nSkype: ").append(note.getSkype()).append("\nAddress: ")
				.append(note.getAddress().getFullAddress()).append("\n").append(note.getCreatedDate()).toString();
	}

}
