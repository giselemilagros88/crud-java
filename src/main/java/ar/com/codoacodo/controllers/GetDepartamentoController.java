package ar.com.codoacodo.controllers;

import ar.com.codoacodo.dao.iDepartamentoDAO;
import ar.com.codoacodo.dao.implement.DepartamentoDAOMysqlImpl;
import ar.com.codoacodo.domain.Departamento;

public class GetDepartamentoController  {
	
	public static void main(String[] args) {
		//interface = new class que implementa la interface
		iDepartamentoDAO dao = new DepartamentoDAOMysqlImpl();
		
		// como llego a la base de datos si quiero pedir datos de un departamento?
		Long id = 11l;
		Departamento d;
		// si no usamos try catch podemos arriba poner throws Exception
		try {
		d = dao.getById(id);
		}
		catch(Exception e) {
			//e.printStackTrace();
			d= null;
		}
		if (d != null) {
			System.out.println(d);
		}else {
			System.err.println("No existe el id:"+ id);
		}
		
	}

}
