package ar.com.codoacodo.domain;



public class Empleado {
	private Long dni;
	private String nombre;
	private String apellido;
	private Departamento depto;
	
	public Empleado(Long dni, String nombre, String apellido, Departamento depto) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.depto = depto;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Departamento getDepto() {
		return depto;
	}

	public void setDepto(Departamento depto) {
		this.depto = depto;
	}

	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", depto=" + depto + "]";
	}
	
	
	
	
	
}
