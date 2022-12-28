package ar.com.codoacodo.controllers;

import ar.com.codoacodo.dao.iDepartamentoDAO;
import ar.com.codoacodo.dao.implement.DepartamentoDAOMysqlImpl;
import ar.com.codoacodo.domain.Departamento;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// un servelet es una clase que extiende de httpServlet
//http://localhost:8080/app-web//FindAllDepartamentoController
@WebServlet("/FindAllDepartamentoController")

public class FindAllDepartamentoController extends HttpServlet {
	//
	
	// tienen metodos importantes como es el 
	//doGet
	//doPost
	// version para la web 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//interface = new class que implementa la interface
	     iDepartamentoDAO dao = new DepartamentoDAOMysqlImpl();
	     List<Departamento> departamentos = new ArrayList<>();
			
	       try {
	    	 departamentos = dao.findAll();
	       } catch (Exception e) {
	    	 // TODO Auto-generated catch block
	    	 e.printStackTrace(); //  muestra por consola el error 
	       }
	       req.setAttribute("listado", departamentos);
	      // este bloque de codigo lo vamos a usar en todos lados, redirecciona al listado.jsp 
	       getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
		
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	/*	
	// version de consola 
	public static void main(String[] args) {
		//interface = new class que implementa la interface
		iDepartamentoDAO dao = new DepartamentoDAOMysqlImpl();
		
		List<Departamento> departamentos;
		// si no usamos try catch podemos arriba poner throws Exception
		try {
		   departamentos = dao.findAll();
		}
		catch(Exception e) {
			//e.printStackTrace();
			departamentos= null;
		}
		if (departamentos != null) {
			for(Departamento aux : departamentos) {
				System.out.println(aux.toString());
				System.out.println("--------------------------------");
			}
			
			//System.out.println(d);
		}else {
			System.err.println("No hay registros en la tabla departamentos");
		}
		
	} */
}
