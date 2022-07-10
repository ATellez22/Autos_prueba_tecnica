package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Dto_Categorias;
import modelo.Conexion;

public class Dao_Categorias {

	private static Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}

	public List<Dto_Categorias> mostrar_categorias() throws SQLException {

		List<Dto_Categorias> lista = new ArrayList<>();

		try (

				Connection con = obtenerConexion();
				PreparedStatement sentencia = con.prepareStatement("SELECT id, descripcion FROM Categorias");
				ResultSet resultSet = sentencia.executeQuery();) {

			con.setAutoCommit(false);

			while (resultSet.next()) {

				Dto_Categorias dto = new Dto_Categorias();

				dto.setId(resultSet.getInt("id"));
				dto.setDescripcion(resultSet.getString("descripcion"));

				lista.add(dto);
			}

			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

}
