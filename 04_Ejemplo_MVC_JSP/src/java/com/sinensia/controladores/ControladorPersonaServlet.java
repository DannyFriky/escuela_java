/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.controladores;

import com.sinensia.modelo.Persona;
import com.sinensia.modelo.logica.ServicioPersona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
public class ControladorPersonaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Map mapa = request.getParameterMap();
		String[] met = (String[]) mapa.get("metodo");
		
		

		

		if (met[0].compareTo("anadir") == 0) {

			try {
				Persona p = ServicioPersona.getInstancia().addPersonas(mapa);
				if (p == null) {
					request.getRequestDispatcher("error.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("exito.jsp").forward(request, response);
				}
			} catch (NumberFormatException ex) {
				request.getSession().setAttribute("mensajeError", "Error Numerico " + ex.getMessage());
				request.getRequestDispatcher("error.jsp").forward(request, response);
			} catch (IllegalArgumentException ex) {
				request.getSession().setAttribute("mensajeError", "Error en Campos " + ex.getMessage());
				request.getRequestDispatcher("error.jsp").forward(request, response);
			} catch (Exception ex) {
				request.getSession().setAttribute("mensajeError", "Error Generico " + ex.getMessage());
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			
		} else if (met[0].compareTo("buscar") == 0) {

			String[] nombre = (String[]) mapa.get("nombre");
			String[] mail = (String[]) mapa.get("mail2");
			
			if (!nombre[0].equals("")) {

				ArrayList<Persona> arrayP = ServicioPersona.getInstancia().buscarPersonaNombre(nombre[0]);

				if (!arrayP.isEmpty()) {
					request.getSession().setAttribute("resultadoBuscado", arrayP);
					request.getRequestDispatcher("resultados_busq.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}

			} else if (!mail[0].equals("")) {

				ArrayList<Persona> arrayP = ServicioPersona.getInstancia().buscarPersonaMail(mail[0]);

				if (!arrayP.isEmpty()) {
					request.getSession().setAttribute("resultadoBuscado", arrayP);
					request.getRequestDispatcher("resultados_busq.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}

			} else {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			
		} else if (met[0].compareTo("modificar") == 0) {
			String[] nombre = (String[]) mapa.get("nombre");
			Persona p = ServicioPersona.getInstancia().getPersona(nombre[0]);
			
			if (p != null) {
				request.getSession().setAttribute("resultadoModificar", p);
				request.getRequestDispatcher("modificar.jsp").forward(request, response);
			}

		} else if (met[0].compareTo("modificado") == 0) {

			ArrayList<Persona> arrayP = ServicioPersona.getInstancia().modificarPersona(mapa);

			if (!arrayP.isEmpty()) {
				request.getSession().setAttribute("resultadoBuscado", arrayP);
				request.getRequestDispatcher("resultados_busq.jsp").forward(request, response);

			} else {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}

		} else if (met[0].compareTo("borrar") == 0) {
			String[] nombre = (String[]) mapa.get("nombre");
			boolean p = false;
			if (!nombre[0].equals("")) {


				String[] nombresV = nombre[0].split(",");

				int i;
				ArrayList<Boolean> arrayBorrar = new ArrayList<Boolean>();
				for (i = 0; i < nombresV.length; i++) {
					p = ServicioPersona.getInstancia().borrarPersona(nombresV[i]);
					arrayBorrar.add(p);
				}

				request.getSession().setAttribute("resultadoBorrar", arrayBorrar);

				request.getRequestDispatcher("borrado.jsp").forward(request, response);

			}
			
		}
		

	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
