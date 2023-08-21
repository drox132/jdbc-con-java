package com.alura.jdbc.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.conectionfactory.ConexionMySql;
import com.alura.jdbc.dao.CategoriaDAO;
import com.alura.jdbc.modelo.Categoria;

public class CategoriaController {
	//CREAMOS EL ATRIBUTO DE DAOCATEGORIA PARA QUE PUEDA SER USADO EN EL CONROLLER
	private CategoriaDAO dao;
	
	public CategoriaController() {
		//CREAMOS UN CONSTRUCTOR PARA CREAR LA CONEXION Y PASARSELA AL CATEGORIADAO TAL Y COMO LO DEFINIMOS EN EL CONSSTRUCTOR 
		Connection conexionFactory = new ConexionMySql().establecerConexion();
		this.dao= new CategoriaDAO(conexionFactory);
	}

	public List<Categoria> listar() {
		return  this.dao.listar();
	}

    public List<Categoria> cargaReporte() {
        return this.dao.listarProductos();
    }

}
