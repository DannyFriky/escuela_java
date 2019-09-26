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
		String nombre = request.getParameter("nombre"); //name del INPUT
		//String edad = request.getParameter("edad");
		String mail = request.getParameter("mail2"); //name del INPUT
		if (!nombre.equals("")) {
			Persona p = ServicioPersona.getInstancia().getPersona(nombre);
			request.getSession().setAttribute("resultadoBuscado", p);
			request.getRequestDispatcher("resultados_busq.jsp").forward(request, response);

		} else if (!mail.equals("")) {
			Persona p = ServicioPersona.getInstancia().getMail(mail);
			request.getSession().setAttribute("resultadoBuscado", p);
			request.getRequestDispatcher("resultados_busq.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre"); //name del INPUT
		String edad = request.getParameter("edad");
		String mail = request.getParameter("mail"); //name del INPUT
		String pass = request.getParameter("pass");
		try {
			Persona p = ServicioPersona.getInstancia().addPersonas(nombre, edad, mail, pass);
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
