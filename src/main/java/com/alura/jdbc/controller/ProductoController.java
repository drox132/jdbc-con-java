package com.alura.jdbc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alura.jdbc.conectionfactory.ConexionMySql;
import com.alura.jdbc.dao.ProductoDAO;
import com.alura.jdbc.modelo.Producto;

public class ProductoController {
	
	 private ProductoDAO dao= new ProductoDAO();
	/* * 
	 * public ProductoController () { dao = new ProductoDAO(new
	 * ConexionMySql().establecerConexion()); }
	 */

	public void modificar( Producto producto )  {
		dao.modificar(producto);
	}

	public void eliminar(Integer id)  {
		dao.eliminar(id);
	}

	public List<Producto> listar()  {
		return dao.listar();
	}

    public Integer guardar(Producto producto)  {
    	return  dao.guardar(producto);
	}

}
