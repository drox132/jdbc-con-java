package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.modelo.Categoria;

public class CategoriaDAO {

	 final Connection con;
	
	//constructor
	public CategoriaDAO(Connection con) {
		this.con=con;
	}

	//METODO LISTAR QUE RETORNA TODAS LAS CATEGORIAS QUE HAY EN LA TABLA
	public List<Categoria> listar() {
		List<Categoria> resultado = new ArrayList<>();
		String sql = "SELECT * FROM CATEGORIA";
		
			try(con){
				final PreparedStatement ps = con.prepareStatement(sql);
				try(ps){
					final ResultSet result = ps.executeQuery();
					try(result){
						while(result.next()) {
							Categoria filaCategoria = new Categoria(
									result.getInt("ID"),
									result.getString("NOMBRE")
									);
							resultado.add(filaCategoria);
						}
					}
					
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		
			
		return resultado;
	}

	public List<Categoria> listarProductos() {
		List<Categoria> resultado = new ArrayList<>();
		String sql = "SELECT C.ID, C.NOMBRE, P.ID_PRODUCTO, P.NOMBRE, P.DESCRIPCION, P.CANTIDAD \r\n"
				+ "FROM TBPRODUCTO P\r\n"
				+ "INNER JOIN CATEGORIA C ON C.ID = P.CATEGORIA_ID";
		
			try(con){
				final PreparedStatement ps = con.prepareStatement(sql);
				try(ps){
					final ResultSet result = ps.executeQuery();
					try(result){
						
						
						
						while(result.next()) {
							Integer idCategoria = result.getInt("ID");
							String nombreCategoria = result.getString("NOMBRE");
							
							var catego = resultado.stream()
							.filter(categoria->categoria.getId().equals(idCategoria))
							.findAny().orElseGet(()->{
								Categoria categoria = new Categoria(
										idCategoria,
										nombreCategoria);
								
								resultado.add(categoria);
								
								return categoria;
							});
						
						}
					}
					
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		
			
		return resultado;
	}
	
	

}
