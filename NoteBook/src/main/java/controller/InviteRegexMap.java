package controller;

import java.util.LinkedHashMap;
import java.util.Map;

import view.InvitationConstants;

public class InviteRegexMap {
	Map<String, String> inviteRegex = new LinkedHashMap<>();

	public void inviteRegexSaver() {
		inviteRegex.put(InvitationConstants.LAST_NAME, RegexConstants.NAME);
		inviteRegex.put(InvitationConstants.FIRST_NAME, RegexConstants.NAME);
		inviteRegex.put(InvitationConstants.MIDDLE_NAME, RegexConstants.NAME);
		inviteRegex.put(InvitationConstants.NICKNAME, RegexConstants.NICKNAME);
		inviteRegex.put(InvitationConstants.COMMENTARIES, RegexConstants.COMMENTARIES);
		inviteRegex.put(InvitationConstants.GROUP, RegexConstants.GROUP);
		inviteRegex.put(InvitationConstants.HOME_PHONE, RegexConstants.HOME_PHONE_NUMBER);
		inviteRegex.put(InvitationConstants.MOBILE_PHONE, RegexConstants.PHONE_NUMBER);
		inviteRegex.put(InvitationConstants.ALTERNATIVE_PHONE, RegexConstants.ALTERNATIVE_NUMBER);
		inviteRegex.put(InvitationConstants.EMAIL, RegexConstants.EMAIL);
		inviteRegex.put(InvitationConstants.SKYPE, RegexConstants.SKYPE);
		inviteRegex.put(InvitationConstants.POST_INDEX, RegexConstants.POST_INDEX);
		inviteRegex.put(InvitationConstants.CITY, RegexConstants.CITY);
		inviteRegex.put(InvitationConstants.STREET, RegexConstants.STREET);
		inviteRegex.put(InvitationConstants.HOUSE_NUMBER, RegexConstants.HOUSE_NUMBER);
		inviteRegex.put(InvitationConstants.FLAT_NUMBER, RegexConstants.FLAT_NUMBER);
		inviteRegex.put(InvitationConstants.LAST_NAME, RegexConstants.NAME);
	}
}
