package controller;

import java.util.Scanner;

import model.Entity.Address;
import model.Entity.Note;

public class InputChecker {

	Scanner scanner = new Scanner(System.in);
	Address address = new Address();
	Note note = new Note();

	public boolean checkExpression(String input, String regex) {
		return input.matches(regex);
	}

	public boolean checkFirstName(String firstName) {
		return checkExpression(firstName, RegexConstants.NAME);
	}

	public boolean checkLastName(String lastName) {
		return checkExpression(lastName, RegexConstants.NAME);
	}

	public boolean checkMiddleName(String middleName) {
		return checkExpression(middleName, RegexConstants.NAME);
	}

	public boolean checkNickName(String nickName) {
		return checkExpression(nickName, RegexConstants.NICKNAME);
	}

	public boolean checkCommentaries(String commentary) {
		return true;
	}

	public boolean checkGroup(String group) {
		return checkExpression(group, RegexConstants.GROUP);
	}

	public boolean checkHomePhone(String homePhone) {
		return checkExpression(homePhone, RegexConstants.HOME_PHONE_NUMBER);
	}

	public boolean checkMobilePhone(String mobilePhone) {
		return checkExpression(mobilePhone, RegexConstants.PHONE_NUMBER);
	}
	
	public boolean checkAlternativePhone(String alternativePhone) {
		return checkExpression(alternativePhone, RegexConstants.ALTERNATIVE_NUMBER);
	}
	
	
}
