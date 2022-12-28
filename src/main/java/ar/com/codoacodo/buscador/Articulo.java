package ar.com.codoacodo.buscador;

public class Articulo {

	//atributos son privados, ya que no van a ser accesibles desde el main
	private String img;
	private String titulo;
	private String autor;
	private double precio;
	
	//contructor, debo pasarle los parametros
	public Articulo(String img,String titulo,String autor,double precio) {
		// el this hace referencia al objeto actual que se esta construyendo 
		this.img = img;
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
	}
	
	//metodos
	public void detalle() {
		System.out.println("detallando articulo..");
		System.out.println("Articulo [img=" + img + ", titulo=" + titulo + ", autor=" + autor + ", precio=" + precio + "]");
		//return 4;
	}
}
