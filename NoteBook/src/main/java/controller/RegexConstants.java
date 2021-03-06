package controller;

public interface RegexConstants {
	//String regular expressions constants initialization
	String NAME = "^[A-ZА-Я]{1}[a-zа-я]{1,20}$";
	String EMAIL = "^[a-zA-Z]+[a-zA-Z_-]\\d*@[a-z]{2,8}\\.[a-z]{2,3}$";
	String NICKNAME = "^[a-zA-Z0-9]{3,16}$";
	String HOME_PHONE_NUMBER = "^\\d{5,6}$";
	String PHONE_NUMBER = "^\\+\\d{1,2}[0]\\d{2}\\-\\d{3}\\-\\d{2}\\-\\d{2}$";
	String ALTERNATIVE_NUMBER = "^(\\+\\d{1,2}[0]\\d{2}\\-\\d{3}\\-\\d{2}\\-\\d{2})?$";
	String COMMENTARIES = "^.*$";
	String SKYPE = "^[0-9a-zA-Z-_]+$";
	String POST_INDEX = "\\d{4}";
	String CITY = "^[A-Z]{1}[a-zA-Z]+$";
	String GROUP = "All|Friends|Family|Colleagues|Все|Друзья|Семья|Колеги";
	String STREET = "^[A-Z]{1}[a-zA-Z]+$";
	String HOUSE_NUMBER = "\\d{1,3}";
	String FLAT_NUMBER = "\\d{1,3}";
	String TRY_AGAIN = "Y|Yes|N|No|yes|no";

}
