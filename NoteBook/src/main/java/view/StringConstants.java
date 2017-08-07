package view;

import java.util.Locale;
import java.util.ResourceBundle;

public interface StringConstants {
	
	Locale ruLocale = new Locale("ru", "RU");
	Locale enLocale = new Locale("en", "US");

	ResourceBundle resourceBundle = ResourceBundle.getBundle("bundles.MyResource", ruLocale);
	
	// String invitation constants + Exception constant
	String FIRST_NAME = resourceBundle.getString("first.name");
	String LAST_NAME = resourceBundle.getString("last.name");
	String MIDDLE_NAME = resourceBundle.getString("middle.name");
	String POST_INDEX = resourceBundle.getString("post.index");
	String CITY = resourceBundle.getString("city");
	String STREET = resourceBundle.getString("street");
	String HOUSE_NUMBER = resourceBundle.getString("house");
	String FLAT_NUMBER = resourceBundle.getString("flat");
	String NICKNAME = resourceBundle.getString("nick.name");
	String COMMENTARIES = resourceBundle.getString("commentary");
	String GROUP = resourceBundle.getString("group");
	String HOME_PHONE = resourceBundle.getString("home.phone.number");
	String MOBILE_PHONE = resourceBundle.getString("mobile.phone.number");
	String ALTERNATIVE_PHONE = resourceBundle.getString("alternative.phone.number");
	String EMAIL = resourceBundle.getString("email");
	String SKYPE = resourceBundle.getString("skype");
	String CONTINUE_INPUT = resourceBundle.getString("continue.input");
	String UNIQUE_NAME_EXCEPTION = resourceBundle.getString("nick.name.busy");
	String WRONG_INPUT = resourceBundle.getString("wrong.input");
	String WRONG_TRY_AGAIN_INPUT = resourceBundle.getString("wrong.try.again");
}
