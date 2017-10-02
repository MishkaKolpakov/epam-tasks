package config;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageManager {
	private static String language = "en";
	private static String country = "US";
	private static Locale locale = new Locale(language, country);
	
	private MessageManager() {
	}
	
	public static void setLanguage(String languageLocale){
		if(languageLocale != null){
			String [] planguage = languageLocale.split("_");
			language = planguage[0];
			country = planguage[1];
			locale = new Locale(language, country);
		}
	}
	
	

	public static String getProperty(String key) {
		return ResourceBundle.getBundle("pagecontent", locale).getString(key);
	}
	
}
