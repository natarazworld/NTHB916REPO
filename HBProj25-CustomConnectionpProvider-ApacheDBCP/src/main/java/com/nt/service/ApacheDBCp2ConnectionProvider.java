package com.nt.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

public class ApacheDBCp2ConnectionProvider implements ConnectionProvider{

	@Override
	public boolean isUnwrappableAs(Class unwrapType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> unwrapType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("ApacheDBCp2ConnectionProiver.getConnection()");
	   BasicDataSource bds=new BasicDataSource();
	   bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	   bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	   bds.setUsername("system");
	   bds.setPassword("manager");
	   bds.setMaxTotal(20); 
	   bds.setMinIdle(5);
	   //get Pooled JDBC con obj
	   Connection con=bds.getConnection();
		return con;
	}

	@Override
	public void closeConnection(Connection con) throws SQLException {
		System.out.println("ApacheDBCp2ConnectionProiver.closeConnection()");
		 con.close();
	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}

}
