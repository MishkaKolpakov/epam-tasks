package controller;

import java.util.LinkedHashMap;
import java.util.Map;

import view.StringConstants;

public class InviteRegexMap {
	Map<String, String> inviteRegex = new LinkedHashMap<>();

	/**
	 * Method that`s save to the linked hash map pair of invitation and regular
	 * expression constants
	 * 
	 */
	public void inviteRegexSaver() {
		inviteRegex.put(StringConstants.LAST_NAME, RegexConstants.NAME);
		inviteRegex.put(StringConstants.FIRST_NAME, RegexConstants.NAME);
		inviteRegex.put(StringConstants.MIDDLE_NAME, RegexConstants.NAME);
		inviteRegex.put(StringConstants.NICKNAME, RegexConstants.NICKNAME);
		inviteRegex.put(StringConstants.COMMENTARIES, RegexConstants.COMMENTARIES);
		inviteRegex.put(StringConstants.GROUP, RegexConstants.GROUP);
		inviteRegex.put(StringConstants.HOME_PHONE, RegexConstants.HOME_PHONE_NUMBER);
		inviteRegex.put(StringConstants.MOBILE_PHONE, RegexConstants.PHONE_NUMBER);
		inviteRegex.put(StringConstants.ALTERNATIVE_PHONE, RegexConstants.ALTERNATIVE_NUMBER);
		inviteRegex.put(StringConstants.EMAIL, RegexConstants.EMAIL);
		inviteRegex.put(StringConstants.SKYPE, RegexConstants.SKYPE);
		inviteRegex.put(StringConstants.POST_INDEX, RegexConstants.POST_INDEX);
		inviteRegex.put(StringConstants.CITY, RegexConstants.CITY);
		inviteRegex.put(StringConstants.STREET, RegexConstants.STREET);
		inviteRegex.put(StringConstants.HOUSE_NUMBER, RegexConstants.HOUSE_NUMBER);
		inviteRegex.put(StringConstants.FLAT_NUMBER, RegexConstants.FLAT_NUMBER);
		inviteRegex.put(StringConstants.CONTINUE_INPUT, RegexConstants.TRY_AGAIN);
	}
}
