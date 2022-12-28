package ar.com.codoacodo.dao.implement;

import ar.com.codoacodo.dao.iDepartamentoDAO;
import ar.com.codoacodo.db.AdministradorDeConexiones;
import ar.com.codoacodo.domain.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

// la interface List tiene una serie de metodos que son 
// add(elemento)
//remove(elemento)
// me permite trabajar como si fueran vectores dinamicamente como en js, dependiendo de la memoria



// en la clase que creamos, heredamos de una interface, la interfaceDAO que tiene los
//metodos para interactuar con la base
public class DepartamentoDAOMysqlImpl implements iDepartamentoDAO {

	@Override
	public Departamento getById(Long id)  throws Exception{
		//-1 necesito la conection a la base
		Connection connection = AdministradorDeConexiones.getConnection();
		//2 - arma el statement
		String sql = "select * from departamentos where id = " + id;
	   
		Statement statement  = connection.createStatement();
		
		//3 - obtengo el resulSet
		ResultSet resultset = statement.executeQuery(sql);
		// El resultset devuelve un registro de una tabla 
		
	     // primero verifico si hay datos 
		
		if (resultset.next()){
			// obtengo el dato del campo id
			Long idBd = resultset.getLong("id");
			String nombreBd = resultset.getString("nombre");
			Double presupuestoBd = resultset.getDouble("presupuesto");
			return new Departamento(idBd,nombreBd,presupuestoBd);
			
		}
		cerrar(connection);
		return null; // si no hay resultset entonces no devuelve nada
	}

	@Override
	public List<Departamento> findAll() throws Exception {
		//-1 necesito la conection a la base
		Connection connection = AdministradorDeConexiones.getConnection();
		//2 - arma el statement
	    String sql = "select * from departamentos";
			   
		Statement statement  = connection.createStatement();
				
		//3 - obtengo el resulSet
		ResultSet resultset = statement.executeQuery(sql);
		// El resultset devuelve un registro de una tabla 
				
	     // primero verifico si hay datos 
		    // creo una lista de departamentos
			List<Departamento> departamentos = new ArrayList<Departamento>();	
			
			// mientras encontremos resultados de la base 
			while (resultset.next()){
			// obtengo el dato del campo id
			Long idBd = resultset.getLong("id");
			String nombreBd = resultset.getString("nombre");
			Double presupuestoBd = resultset.getDouble("presupuesto");
			// creamos un departamento y lo agregamos a la lista 
			Departamento d = new Departamento(idBd,nombreBd,presupuestoBd);
			departamentos.add(d);
					
			}
			cerrar(connection);
		   // devolvemos departamentos		
		   return departamentos; //
	}

	@Override
	public void delete(Long id) throws Exception {
	   //-1 necesito la conection a la base
		Connection connection = AdministradorDeConexiones.getConnection();
		//2 - arma el statement
	     String sql = "DELETE FROM departamentos WHERE ID=" + id;
	 	 Statement statement  = connection.createStatement();
	 	//3 -devuelve un entero devuelve 1 o 0, pero no hace falta confirmar para este caso 
		  statement.executeUpdate(sql);
		  cerrar(connection);
		 
	}

	@Override
	public void update(Departamento depto) throws Exception {
		// creo un Departamento con los datos modificados del departemento 
		  
		//-1 necesito la conection a la base
		Connection connection = AdministradorDeConexiones.getConnection();
		//2 - arma el statement
		 String sql = "update departamentos set nombre = ?, presupuesto = ? where id= ?"  ;
		 PreparedStatement statement  = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
	     statement.setString(1,depto.getNombre());
		 statement.setDouble(2,depto.getPresupuesto());
		 statement.setLong(3,depto.getId());
		//3 -devuelve un entero devuelve 1 o 0, pero no hace falta confirmar para este caso 
		 statement.execute();
		
		 cerrar(connection);
	}

	@Override
	public void create(Departamento newDepto) throws Exception {
		
        
		//-1 necesito la conection a la base
		Connection connection = AdministradorDeConexiones.getConnection();
		//2 - arma el statement
		 String sql = "insert into departamentos (id, nombre, presupuesto) values (?,?,?)" ;
		 PreparedStatement statement  = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		 statement.setLong(1,newDepto.getId());
		 statement.setString(2,newDepto.getNombre());
		 statement.setDouble(3,newDepto.getPresupuesto());
		//3 -devuelve un entero devuelve 1 o 0, pero no hace falta confirmar para este caso 
		 statement.execute();
		 
		 ResultSet res = statement.getGeneratedKeys(); // RETORNA LA KEY QUE SE GENERO
		 if (res.next()) {
			 System.out.println("Se creo el departamento correctamente");
		 }
		 cerrar(connection);
	}
	@Override
	public List<Departamento> search(String clave) throws Exception {
		// 1 - necesito la Connection
		Connection connection = AdministradorDeConexiones.getConnection();

		// 2 - arma el statement
		String sql = "SELECT * FROM DEPARTAMENTOS WHERE NOMBRE LIKE ?";
		PreparedStatement statement = connection.prepareStatement(sql);

		//setear el valor que va en remplazo del ?
		statement.setString(1, "%" + clave + "%");
		
		// 3 - resultset
		ResultSet resultSet = statement.executeQuery();

		// Interface i = new ClaseQueImplementaLaInterface();
		List<Departamento> depto = new ArrayList<Departamento>();

		// verifico si hay datos
		while (resultSet.next()) {
			depto.add(this.crearDepto(resultSet));
		}
		
		cerrar(connection);
		
		return depto;
	}
	
	private void cerrar(Connection con) throws Exception{
		con.close();
	}
	
	private Departamento crearDepto(ResultSet resultSet) throws Exception {
		// obtengo el dato del campo id
		Long idDb = resultSet.getLong("id");
		String nombre = resultSet.getString("nombre");
		Double presupuesto = resultSet.getDouble("presupuesto");
		

		return new Departamento(idDb, nombre, presupuesto);
	}
	
	// implementar el nuevo metodo que busca por el nombre y que devuelve una lista de departamentos

}
