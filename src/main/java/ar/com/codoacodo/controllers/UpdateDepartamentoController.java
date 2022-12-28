package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ar.com.codoacodo.dao.iDepartamentoDAO;
import ar.com.codoacodo.dao.implement.DepartamentoDAOMysqlImpl;
import ar.com.codoacodo.domain.Departamento;

@WebServlet("/UpdateDepartamentoController")
public class UpdateDepartamentoController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//capturo los parametros que viene en el request enviado por el form
		String nombre= req.getParameter("nombre");//name de input
		String id = req.getParameter("id");//name de input
		String presupuesto = req.getParameter("presupuesto");//name de input
		//interface = new class que implementa la interface
		iDepartamentoDAO dao = new DepartamentoDAOMysqlImpl();
		
		
		
		Departamento d;
       
		d = new Departamento(Long.parseLong(id),nombre,Double.parseDouble(presupuesto));
		// si no usamos try catch podemos arriba poner throws Exception
		try { 
			dao.update(d);
			//aca mensaje de exito, PERO COMO UNA LISTA
			req.setAttribute("success", List.of("Departamento id:" + d.getId() + " actualizado correctamente"));
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errors", List.of("Error actualizando Departamento<" + e.getMessage()));
		}
		
		
		//ahora redirect!!!!
	     getServletContext().getRequestDispatcher("/FindAllDepartamentoController").forward(req, resp);
		
		
	}
	
	//cargar el departamento y enviarlo a la jsp que va a editar los datos
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String id = req.getParameter("id");
			
			// realizar validaciones, para los datos que vienen!!!
			
			//interface = new class que implementa la interface
			iDepartamentoDAO dao = new DepartamentoDAOMysqlImpl();
			
			Departamento d = null;
			//cargo los datos 
			try {
				d = dao.getById(Long.parseLong(id));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//guardar el producto en request y pasar dicho producto a la jsp
			req.setAttribute("departamento", d);
			
			//redirect
			//ahora redirect!!!!
		     getServletContext().getRequestDispatcher("/editar.jsp").forward(req, resp);
		}

}
