package controller;

public interface RegexConstants {
	String NAME = "^[À-ß²¯ª]{1}[à-ÿ³¿º]{1,20}$";
	String EMAIL = "^[a-zA-Z]+[a-zA-Z_-]\\d*@[a-z]{2,8}\\.[a-z]{2,3}$";
	String NICKNAME = "^[a-zA-Z0-9_-.] {3,16}$";
	String PHONE_NUMBER = "^\\+\\d{1,2}[0]\\d{2}\\-\\d{3}\\-\\d{2}\\-\\d{2}$";
	String COMMENTARIES = "^.*$";
	String SKYPE = "^[0-9a-zA-Z-_]+$";
	String POST_INDEX  = "\\d{4}";
	String CITY = "^\\w{1,4}$";
	String STREET = "^\\w{1,4}$";
	String HOUSE_NUMBER = "\\d{1,3}";
	String FLAT_NUMBER = "\\d{1,3}";
	
}
