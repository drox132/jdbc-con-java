package com.alura.jdbc.conectionfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConexionMySql {

	DataSource dataSource;
	
	public ConexionMySql () {
		var pooleDataSource = new ComboPooledDataSource();
		pooleDataSource.setJdbcUrl("jdbc:mysql://localhost/control_de_stock?useTimeZone=true&serverTimeZone=UTC");
		pooleDataSource.setUser("root");
		pooleDataSource.setPassword("21306336.Ff,");
		pooleDataSource.setMaxPoolSize(10);
		this.dataSource=pooleDataSource;
	}
	public Connection establecerConexion ()  {
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			throw  new RuntimeException(e); 
		}
	}

}
