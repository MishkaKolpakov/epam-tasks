package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigDB {

	private String factoryClassName;

	public ConfigDB() {
		load();
	}

	private static class Holder {
		private static ConfigDB INSTANCE = new ConfigDB();
	}

	public static ConfigDB getInstance() {
		return Holder.INSTANCE;
	}

	private void load() {
		try (InputStream in = this.getClass().getResourceAsStream("/db.properties")) {
			Properties properties = new Properties();
			properties.load(in);
			factoryClassName = properties.getProperty("db.factory.class");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getFactoryClassName() {
		return factoryClassName;
	}
}
