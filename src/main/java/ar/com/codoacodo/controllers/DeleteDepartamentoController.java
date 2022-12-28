package ar.com.codoacodo.controllers;

import ar.com.codoacodo.dao.iDepartamentoDAO;
import ar.com.codoacodo.dao.implement.DepartamentoDAOMysqlImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteDepartamentoController")
public class DeleteDepartamentoController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("idDepto"));//viene como String -> Long.parseLong()

		//interface = new class que implementa la interface
		iDepartamentoDAO dao = new DepartamentoDAOMysqlImpl();
		
		//eliminar
		try {
			dao.delete(id);
			//mensaje de exito
			req.setAttribute("success", List.of("Se he eliminado el producto con id:" + id));
		} catch (Exception e) {
			e.printStackTrace();
			//mensaje de error
			req.setAttribute("erorrs", List.of("NO se he eliminado el producto :" + e.getMessage()));
		}//ctrl+t
		
		//ahora redirect!!!!
		getServletContext().getRequestDispatcher("/FindAllDepartamentoController").forward(req, resp);
		
		
	}

}
