package com.alura.jdbc.pruebas;

import java.sql.SQLException;

import com.alura.jdbc.conectionfactory.ConexionMySql;

public class PoolConecciones {

	public static void main(String[] args) throws SQLException {
		ConexionMySql con = new ConexionMySql();
		
		
		int cantidadMax=15;
		int conexionEstablecida=0;
		while(cantidadMax > 0) {
			
			con.establecerConexion();
			conexionEstablecida++;
			System.out.println("Se establecio la conexion N° "+ conexionEstablecida);
			cantidadMax--;
		}
		
	}

}
