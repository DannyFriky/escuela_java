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
		String met = request.getParameter("metodo");
		if (met.compareTo("anadir") == 0) {
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
		} else if (met.compareTo("buscar") == 0) {
			String nombre = request.getParameter("nombre"); //name del INPUT
			//String edad = request.getParameter("edad");
			String mail = request.getParameter("mail2"); //name del INPUT

			if (!nombre.equals("")) {

				String[] nombresV = nombre.split(",");
				ArrayList<Persona> arrayP = new ArrayList<Persona>();
				int i;
				for (i = 0; i < nombresV.length; i++) {
					Persona p = ServicioPersona.getInstancia().getPersona(nombresV[i]);
					arrayP.add(p);
				}

				request.getSession().setAttribute("resultadoBuscado", arrayP);

				request.getRequestDispatcher("resultados_busq.jsp").forward(request, response);

			} else if (!mail.equals("")) {
				Persona p = ServicioPersona.getInstancia().getMail(mail);
				request.getSession().setAttribute("resultadoBuscado", p);
				request.getRequestDispatcher("resultados_busq.jsp").forward(request, response);
			}
		} else if (met.compareTo("modificar") == 0) {
			String nombre = request.getParameter("nombre");
			Persona p = ServicioPersona.getInstancia().getPersona(nombre);
			if (p != null) {
				request.getSession().setAttribute("resultadoModificar", p);
				request.getRequestDispatcher("modificar.jsp").forward(request, response);
			}

		} else if (met.compareTo("modificado") == 0) {
			String nombre = request.getParameter("nombre"); //name del INPUT
			String edad = request.getParameter("edad");
			String mail = request.getParameter("mail"); //name del INPUT
			String pass = request.getParameter("pass");
			String antiguo = request.getParameter("nombreA");

			int intEdad = Integer.parseInt(edad);
			Persona p = ServicioPersona.getInstancia().getPersona(antiguo);
			p.setNombre(nombre);
			p.setEdad(intEdad);
			p.setMail(mail);
			p.setPass(pass);

				ArrayList<Persona> arrayP = new ArrayList<Persona>();
				arrayP.add(p);
			request.getSession().setAttribute("resultadoBuscado", arrayP);
			request.getRequestDispatcher("resultados_busq.jsp").forward(request, response);


		}else if (met.compareTo("borrar") == 0) {
			String nombre = request.getParameter("nombre"); //name del INPUT
			if (!nombre.equals("")) {


				String[] nombresV = nombre.split(",");
				ArrayList<Persona> arrayP = new ArrayList<Persona>();
				int i;
				for (i = 0; i < nombresV.length; i++) {
					
				}

				request.getSession().setAttribute("resultadoBuscado", arrayP);

				request.getRequestDispatcher("resultados_busq.jsp").forward(request, response);

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
