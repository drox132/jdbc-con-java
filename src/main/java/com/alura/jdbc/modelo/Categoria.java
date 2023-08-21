package com.alura.jdbc.modelo;

import java.util.List;

public class Categoria {

	private Integer id;
	private String nombre;
	private List<Producto> productos;
	
	

	public Categoria(int id, String nombre) {
		this.setId(id);
		this.setNombre(nombre);
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return  this.getNombre();
	}
	
	
	

}
