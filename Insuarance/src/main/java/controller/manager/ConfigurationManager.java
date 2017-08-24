package controller.manager;

import java.util.ResourceBundle;

public class ConfigurationManager {
	// Connection to resource bundle with pages paths
	private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

	private ConfigurationManager() {
	}

	/**
	 * Get constant resource by key
	 * 
	 * @param key
	 * @return stringValue
	 **/
	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}
