package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import dao.Dao_Categorias;
import dao.Dao_Detalle_Categoria;
import dao.Dao_Vehiculos;
import dto.Dto_Categorias;
import dto.Dto_Vehiculos;

@WebServlet("/Controlador_Vehiculos")
public class Controlador_Vehiculos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controlador_Vehiculos() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accion = request.getParameter("action");

		if (accion.startsWith("reporte_articulos")) {

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// doGet(request, response);
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();

		String accion = request.getParameter("action");

		String lista_art_json = "";
				
		if (accion.equals("listado_categoria")) {

			List<Dto_Categorias> lista_categorias = new ArrayList<>();
			try {
				Dao_Categorias metodo = new Dao_Categorias();
				lista_categorias = metodo.mostrar_categorias();
				out.print(lista_categorias);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (accion.equals("mostrar_caracteristicas")) {
			
			Long id_vehiculo = Long.valueOf(request.getParameter("vehiculo"));
			
			Dao_Vehiculos metodo = new Dao_Vehiculos();
			
			try {
				List<Dto_Vehiculos> lista_caracteristicas = metodo.Obtener_datos_vehiculo(id_vehiculo);

				lista_art_json = new Gson().toJson(lista_caracteristicas);// Convertir LIST en JSON para enviar a la tabla.

				out.print(lista_art_json);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (accion.equals("anidado_categoria")) {

			String categoria = request.getParameter("categoria");
			
			System.out.println(categoria);

			List<Dto_Categorias> lista_vehiculos = new ArrayList<>();
			try {
				Dao_Detalle_Categoria metodo = new Dao_Detalle_Categoria();
				lista_vehiculos = metodo.mostrar_detalle_categoria(categoria);

				out.print(lista_vehiculos);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
