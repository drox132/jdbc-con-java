package com.alura.jdbc.modelo;

public class Producto {

private Integer id;
private String nombre;
private String descripcion;
private Integer cantidad;



public Producto (String nombre, String descripcion, Integer cantidad) {
	this.setNombre(nombre);
	this.setDescripcion(descripcion);
	this.setCantidad(cantidad);
}
public Producto(int id, String nombre, String descripcion, int cantidad) {
	this.setId(id);
	this.setNombre(nombre);
	this.setDescripcion(descripcion);
	this.setCantidad(cantidad);
	
}


public Producto() {
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
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public Integer getCantidad() {
	return cantidad;
}
public void setCantidad(Integer cantidad) {
	this.cantidad = cantidad;
}



}
