package org.openserp.test.common;

import javax.sql.DataSource;

import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.ext.mysql.MySqlMetadataHandler;

public class CustomDatabaseTester extends DataSourceDatabaseTester {

	
	public CustomDatabaseTester(DataSource dataSource, String schema) {
		super(dataSource, schema);
	}

	@Override
	public IDatabaseConnection getConnection() throws Exception {
		IDatabaseConnection databaseConnection = super.getConnection();

		DatabaseConfig databaseConfig = databaseConnection.getConfig();

		databaseConfig.setProperty(
				DatabaseConfig.PROPERTY_DATATYPE_FACTORY,
				new MySqlDataTypeFactory());
		databaseConfig.setProperty(DatabaseConfig.PROPERTY_METADATA_HANDLER,
				new MySqlMetadataHandler());

		return databaseConnection;
	}
	
}
