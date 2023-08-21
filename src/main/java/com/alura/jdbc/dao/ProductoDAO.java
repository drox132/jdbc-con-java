package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.conectionfactory.ConexionMySql;
import com.alura.jdbc.modelo.Categoria;
import com.alura.jdbc.modelo.Producto;

public class ProductoDAO {

	//private final Connection con;
	
	/*
	 * public ProductoDAO(Connection con) { this.con = con; }
	 */
	//////////////////////////////////////////////////////////////////////
	//LISTAR PRODUTO 
	//////////////////////////////////////////////////////////////////////
	public List<Producto> listar() {
		List<Producto> resultado = new ArrayList<>();
		
		final Connection con = new ConexionMySql().establecerConexion();
		try(con){
			String sql ="SELECT * FROM TBPRODUCTO";

			final PreparedStatement ps = con.prepareStatement(sql);
			try(ps){
				
				final ResultSet resultSet =  ps.executeQuery();
				try(resultSet){
					while (resultSet.next()) {
						Producto lineaProducto = new Producto(
								resultSet.getInt("ID_PRODUCTO"),
								resultSet.getString("NOMBRE"),
								resultSet.getString("DESCRIPCION"),
								resultSet.getInt("CANTIDAD")
								);
						
						resultado.add(lineaProducto);
					}
				}
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		return resultado;
	}
	//////////////////////////////////////////////////////////////////////
	//GUARDAR PRODUTO 
	//////////////////////////////////////////////////////////////////////
	
	public Integer guardar(Producto producto) {
		   	int pkProductoInsertado=0;
			final Connection con = new ConexionMySql().establecerConexion();

		try(con){
	    	String sql = "INSERT INTO TBPRODUCTO (NOMBRE,DESCRIPCION,CANTIDAD,CATEGORIA_ID) VALUES (?,?,?,? )"; 
	    	
	    		final PreparedStatement stment = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
	    		try(stment){
	    			stment.setString(1, producto.getNombre());
	            	stment.setString(2, producto.getDescripcion());
	            	stment.setInt(3, producto.getCantidad());
	            	stment.setInt(4, producto.getCategoriaId());
	               	stment.execute();
	            		
	            	final ResultSet resultSet = stment.getGeneratedKeys();
	            	try(resultSet){
	            		
	                	while(resultSet.next()) {
	                		pkProductoInsertado = resultSet.getInt(1);
	                	}
	            	}
	    		}
			}catch (Exception e) {
				throw new RuntimeException(e);
			}
		return pkProductoInsertado;
	}

	

	//////////////////////////////////////////////////////////////////////
	//ELIMINAR PRODUTO 
	//////////////////////////////////////////////////////////////////////
	public void eliminar(Integer id) {
		final Connection con = new ConexionMySql().establecerConexion();
		try {
			try(con){

				String sql = "DELETE FROM tbproducto WHERE ID_PRODUCTO = ?";
				
				final PreparedStatement ps = con.prepareStatement(sql);
				try(ps){
					ps.setInt(1, id);
					int rowAfected = ps.executeUpdate();
					System.out.println(rowAfected);
					
					if (rowAfected>0) {
						System.out.println("Se elimino "+rowAfected+" registro");
					}else {
						System.out.println("ha ocurrido un error en la eliminacion del producto");
					}	
				}	
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}


	//////////////////////////////////////////////////////////////////////
	//MODIFICAR PRODUTO 
	//////////////////////////////////////////////////////////////////////
	public void modificar(Producto producto) {
		final Connection con = new ConexionMySql().establecerConexion();
		try {
			try(con){
				String sql = "UPDATE TBPRODUCTO SET NOMBRE = ?, DESCRIPCION=?, CANTIDAD=? WHERE ID_PRODUCTO=?";
				final PreparedStatement ps = con.prepareStatement(sql);
				try(ps){
					ps.setString(1, producto.getNombre());
					ps.setString(2, producto.getDescripcion());
					ps.setInt(3, producto.getCantidad());
					ps.setInt(4, producto.getId());
					int rowAfected = ps.executeUpdate();
					if (rowAfected>0) {
						System.out.println("Producto Modificado con Exito");
					}else {
						System.out.println("Ha ocurrido un error al modificar el producto");
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public List<Producto> listar(Integer categoria) {
List<Producto> resultado = new ArrayList<>();
		
		final Connection con = new ConexionMySql().establecerConexion();
		try(con){
			String sql ="SELECT * FROM TBPRODUCTO WHERE CATEGORIA_ID= ?";

			final PreparedStatement ps = con.prepareStatement(sql);
			try(ps){
				ps.setInt(1, categoria);
				final ResultSet resultSet =  ps.executeQuery();
				try(resultSet){
					while (resultSet.next()) {
						Producto lineaProducto = new Producto(
								resultSet.getInt("ID_PRODUCTO"),
								resultSet.getString("NOMBRE"),
								resultSet.getString("DESCRIPCION"),
								resultSet.getInt("CANTIDAD")
								);
						
						resultado.add(lineaProducto);
					}
				}
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		return resultado;
	}
	

}
