package ar.com.codoacodo.departamento;

public class Departamento {
	
	private Long id;  // private actua como public para la clase misma, pero invisible para el resto
	private String nombre;
	private Double presupuesto;
	
	public Departamento (Long id,String nombre,double presupuesto) {
		
		this.id = id ;  // el id que esta vacio, va a estar lleno con un dato que viene de un select * from 
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		
		
	}
	//metodos
	public void mostrarDatos() {
		System.out.println("detallando Departamento..");
		System.out.println("Departamento [id=" + id + ", nombre=" + nombre + ", Presupuesto=" + presupuesto +  "]");
		
	}
	public String getNombreDepto() {
		return nombre;
	}
	public Double getPresupuestoDepto() {
		return presupuesto;
	}

}
