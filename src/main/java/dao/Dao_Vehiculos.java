package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Dto_Categorias;
import dto.Dto_Vehiculos;
import modelo.Conexion;

public class Dao_Vehiculos {

	private static Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}

	public List<Dto_Vehiculos> Obtener_datos_vehiculo(Long id) {
		
		List<Dto_Vehiculos> lista = new ArrayList<>();

		try (

				Connection con = obtenerConexion();
				PreparedStatement sentencia = con.prepareStatement(
						"select marca, modelo, año, cambio, potencia, plazas, combustible, cilindrada, "
								+ "velocidad_maxima, precio from vehiculos v \r\n" + "where id = "+ id);
				ResultSet resultSet = sentencia.executeQuery();) {

			con.setAutoCommit(false);

			while (resultSet.next()) {
				
				Dto_Vehiculos dto = new Dto_Vehiculos();
							
				dto.setMarca(resultSet.getString("marca"));
				dto.setModelo(resultSet.getString("modelo"));
				dto.setAnio(resultSet.getInt("año"));
				dto.setCambio(resultSet.getString("cambio"));
				dto.setPotencia(resultSet.getString("potencia"));
				dto.setPlazas(resultSet.getInt("plazas"));
				dto.setCombustible(resultSet.getString("combustible"));
				dto.setCilindrada(resultSet.getInt("cilindrada"));
				dto.setVelocidad_maxima(resultSet.getInt("velocidad_maxima"));
				dto.setPrecio(resultSet.getInt("precio"));
				
				lista.add(dto);
			
			}

			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
		
	}

}
