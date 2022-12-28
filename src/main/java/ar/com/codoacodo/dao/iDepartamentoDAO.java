package ar.com.codoacodo.dao;
import ar.com.codoacodo.domain.Departamento;
import java.util.List;

public interface iDepartamentoDAO {
	
   // en esta interface vamos a definir metodos de acceso a la tabla departamentos
	// LAS INTERFACES POR SI SOLAS NO HACEN NADA, SOLO ES UNA ESTRUCTURA
	// SE DEBE IMPLEMENTAR EN UNA CLASE, ES DECIR EN UNA CLASE USAMOS ESTOS METODOS QUE DEFINIMOS ACA
	
	/*crud
	 getById()
	 find()
	 delete()
	 update()
	 create()*/
	
	// select * from departamentos where id = id;
	public Departamento getById(Long id) throws Exception; // devuelve de un id todos los campos 
	
	// cambiamos el array por una lista de java 
	// select * from departamentos;
	public List<Departamento> findAll() throws Exception;	// devuelve todos los registros de la tabla departamentos
	
	
	// delete from departamentos where id = id;
	public void delete(Long id) throws Exception;// esto borra un registro por el id del departamento
	
	
	//update departamentos set nombre = nombre, presupuesto = presupuesto where id = depto.id;
	public void update(Departamento depto) throws Exception; // se le pasa un objeto 
	
	// insert to departamentos (campo 1..campo2..campo3) values(newDepto.campo1....newDepto.campoN)
	public void create(Departamento newDepto) throws Exception;
	
	//select * from departamentos where titulo like '%clave%' 
    public List<Departamento> search(String clave) throws Exception;
	
	// crear un method que consulte a la base por el nombre y que devuelva una lista de departamentos
	// crear un nuevo method que haga update solo al nombre o solo al presupuesto 
	
}
