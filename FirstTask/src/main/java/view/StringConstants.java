package view;

import java.util.Locale;
import java.util.ResourceBundle;

public interface StringConstants {
	// Locale initialization
	Locale englishLocale = new Locale("en", "US");
	Locale russianLocale = new Locale("ru", "RU");
	ResourceBundle resourceBundle = ResourceBundle.getBundle("view.bundles.Resource", englishLocale);

	// Wrong input string constants
	String WRONG_COMMAND = resourceBundle.getString("wrong.command.input");
	String WRONG_INT_INPUT = resourceBundle.getString("wrong.int.input");
	String WRONG_LONG_INPUT = resourceBundle.getString("wrong.long.input");

	// Main menu string constants
	String INVITATION_DERIVATIVE = resourceBundle.getString("enter.derivative");
	String SORT_DERIVATIVE = resourceBundle.getString("sort.derivative");
	String SEARCH_PRICE = resourceBundle.getString("search.price");
	String SEARCH_RISK = resourceBundle.getString("search.risk");
	String SEARCH_PRICE_RISK = resourceBundle.getString("search.price.risk");
	String QUITE = resourceBundle.getString("quite");
	String CHOOSE_COMMAND = resourceBundle.getString("choose.command");
	String EXIT = resourceBundle.getString("exit");
	

	// Search by risk level string constants
	String RISK_FROM = resourceBundle.getString("risk.from");
	String RISK_TO = resourceBundle.getString("risk.to");

	// Search by price string constants
	String PRICE_FROM = resourceBundle.getString("price.from");
	String PRICE_TO = resourceBundle.getString("price.to");
	
	// Addition string constants
	String SUMMARY_PRICE = resourceBundle.getString("summary.price");
	String PRICE_IS = resourceBundle.getString("price.is");
	String CURRENCY = resourceBundle.getString("currency");
	String RISK_LEVEL = resourceBundle.getString("risk.level");
	String GROUP = resourceBundle.getString("group");
	String VALUATED = resourceBundle.getString("valuated");

}
