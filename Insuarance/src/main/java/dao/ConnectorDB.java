package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

import com.mysql.cj.jdbc.Driver;

public class ConnectorDB implements AutoCloseable {
	private static Connection connection;

	/**
	 * Encapsulation of connection process method
	 * 
	 * @return connection
	 */
	public static Connection getConnection() throws SQLException {
		ResourceBundle resource = ResourceBundle.getBundle("database");
		String url = resource.getString("db.url");

		Properties properties = new Properties();
		properties.put("user", resource.getString("db.user"));
		properties.put("password", resource.getString("db.password"));
		properties.put("autoReconnect", resource.getString("db.autoReconnect"));
		properties.put("characterEncoding", resource.getString("db.characterEncoding"));
		properties.put("useUnicode", resource.getString("db.useUnicode"));
		properties.put("useJDBCCompliantTimezoneShift", resource.getString("db.useJDBCCompliantTimezoneShift"));
		properties.put("useLegacyDatetimeCode", resource.getString("db.useLegacyDatetimeCode"));
		properties.put("serverTimezone", resource.getString("db.serverTimezone"));

		DriverManager.registerDriver(new Driver());

		connection = DriverManager.getConnection(url, properties);
		return connection;
	}

	public void close() throws Exception {
		connection.close();
	}
}
