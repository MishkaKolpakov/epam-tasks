package config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ContextConfiguration {
	private static final String JNDI = "java:comp/env";
	private static final String DATASOURCE_NAME = "jdbc/airline";

	private ContextConfiguration(){
	}
	
	public static DataSource getDataSource() throws NamingException {
		Context context = null;
		DataSource dataSource = null;

		context = (Context) (new InitialContext().lookup(JNDI));
		dataSource = (DataSource) context.lookup(DATASOURCE_NAME);

		return dataSource;
	}

}
