package ar.com.codoacodo.controllers;

import ar.com.codoacodo.dao.iDepartamentoDAO;
import ar.com.codoacodo.dao.implement.DepartamentoDAOMysqlImpl;
import ar.com.codoacodo.domain.Departamento;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CreateDepartamentoController")
public class CreateDepartamentoController extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//capturo los parametros que viene en el request enviado por el form
		String nombre= req.getParameter("nombre");//name de input
		String id = req.getParameter("id");//name de input
		String presupuesto = req.getParameter("presupuesto");//name de input
		
		
		//validaciones!
		List<String> errores = new ArrayList<>();
		if(nombre == null || "".equals(nombre)) {
			errores.add("Nombre vacío");
		}
		if(id== null || "".equals(id)) {
			errores.add("Id vacío");
		}
		if(presupuesto== null || "".equals(presupuesto)) {
			errores.add("Presupuesto vacío");
		}
		//agrego las demas validaciones!!!! (uds)
		if(!errores.isEmpty()) {
			req.setAttribute("errors", errores);
			//vuelvo a la jsp con la lista de errores cargadas 
			getServletContext().getRequestDispatcher("/nuevo.jsp").forward(req, resp);
			return;
		}

		
		
		
		//interface = new class que implementa la interface
		iDepartamentoDAO dao = new DepartamentoDAOMysqlImpl();
		
		// como llego a la base de datos si quiero pedir datos de un departamento?
		
		Departamento d;
       
		d = new Departamento(Long.parseLong(id),nombre,Double.parseDouble(presupuesto));
		// si no usamos try catch podemos arriba poner throws Exception
		try {
			 dao.create(d);
			 req.setAttribute("success", List.of("Alta de producto exitosa"));
		}catch (Exception e) {
			//si falla volver al nuevo.jsp
			e.printStackTrace();
			
		 }
		//ahora redirect!!!!
		getServletContext().getRequestDispatcher("/FindAllDepartamentoController").forward(req, resp);
		
		
		
		
	}

}
