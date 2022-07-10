package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Dto_Categorias;
import modelo.Conexion;

public class Dao_Detalle_Categoria {

	private static Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}

	public List<Dto_Categorias> mostrar_detalle_categoria(String categoria) throws SQLException {
				
		List<Dto_Categorias> lista = new ArrayList<>();

		try (

				Connection con = obtenerConexion();
				PreparedStatement sentencia = con
						.prepareStatement("select v.id, v.marca from detalle_categoria dc join categorias c \r\n"
								+ "on dc.id_categoria = c.id join vehiculos v \r\n" + "on dc.id_vehiculo = v.id \r\n"
								+ "where c.id = " + categoria);
				ResultSet resultSet = sentencia.executeQuery();) {
			
			con.setAutoCommit(false);

			while (resultSet.next()) {

				Dto_Categorias dto = new Dto_Categorias(); //Se usa como LIST

				dto.setId(resultSet.getInt("id"));
				dto.setDescripcion(resultSet.getString("marca"));

				lista.add(dto);
			}

			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

}
