package ar.com.codoacodo.departamento;

public class Empleado {
	
	int dni;
	String nombre;
	String apellido;
	Departamento depto;

    public Empleado(int dni,String nombre,String apellido,Departamento depto) {
    	this.dni = dni;
    	this.nombre = nombre ;
    	this.apellido = apellido;
    	this.depto = depto ;
    	
    	
    }
    
  //metodos
  	public void mostrarDatos() {
  		System.out.println("detallando Empleado..");
  		System.out.println("Dni:" + dni);
  		System.out.println("Nombre:" + nombre);
  		System.out.println("Apellido:" + apellido);
  
  		this.depto.mostrarDatos();
  		
  		
  		
  	}
  	public void setDepto(Departamento depto) {
  		this.depto = depto;
  		
  	}
  	
    public void mostrarNombreDeptoDeEmpleado() {
    	System.out.println("Nombre Depto de Empleado:" + this.depto.getNombreDepto());
    	
    }
	
}
