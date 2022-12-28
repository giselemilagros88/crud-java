package ar.com.codoacodo.domain;

public class Departamento {
	private Long id;  // private actua como public para la clase misma, pero invisible para el resto
	private String nombre;
	private Double presupuesto;
	
	// alt +shift +s para generar automaticamente los get y set y tambien el constructor y el tostring de forma automatica
	
	public Departamento (Long id,String nombre,double presupuesto) {
		
		this.id = id ;  // el id que esta vacio, va a estar lleno con un dato que viene de un select * from 
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(Double presupuesto) {
		this.presupuesto = presupuesto;
	}
	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombre=" + nombre + ", presupuesto=" + presupuesto + "]";
	}
	
	

}
