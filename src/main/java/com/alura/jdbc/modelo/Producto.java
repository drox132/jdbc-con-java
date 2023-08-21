package com.alura.jdbc.modelo;

public class Producto {

private Integer id;
private String nombre;
private String descripcion;
private Integer cantidad;
private Integer categoriaId;




public Producto (String nombre, String descripcion, Integer cantidad) {
	this.setNombre(nombre);
	this.setDescripcion(descripcion);
	this.setCantidad(cantidad);
}
public Producto(Integer id, String nombre, String descripcion, Integer cantidad) {
	this.setId(id);
	this.setNombre(nombre);
	this.setDescripcion(descripcion);
	this.setCantidad(cantidad);
	
}

//constuctor para guardar la categoria del producto tambien 
public Producto(String nombre, String descripcion, Integer cantidad, Integer categoriaId) {
	this.setNombre(nombre);
	this.setDescripcion(descripcion);
	this.setCantidad(cantidad);
	this.setCategoriaId(categoriaId);
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

public Integer getCategoriaId() {
	return categoriaId;
}
public void setCategoriaId(Integer categoriaId) {
	this.categoriaId = categoriaId;
}


}
