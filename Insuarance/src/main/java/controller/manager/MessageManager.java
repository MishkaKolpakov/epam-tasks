package controller.manager;

import java.util.ResourceBundle;

public class MessageManager {
	// Connection to resource bundle with error messages
	private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");

	private MessageManager() {
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
