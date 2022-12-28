package ar.com.codoacodo.buscador;

public class Buscador {
	
	// atributos
	
	public String claveBusqueda;
	// este atributo se va a llenar con la cantidad de registros que encuentro en la base de datos
	
	private int cantidad;
	
	//el buscador va a encontrar articulos que son objetos que tienen sus atributos y sus metodos
	private Articulo[] resultados;
//rivate Perro[] perros;
	
	
	
	
	// metodos 
	// se declara con el nombre del metodo que es como una funcion
	// despues de los dos puntos : se indica que devuelve esa funcion
	// que valor retorna
	// void significa que no retorna información
	//atributos
	
	// este metodo es el mas importante ya que es el constructor del objeto y debe ser siempre publico
		public Buscador() {
			// TODO Auto-generated constructor stub
		}
		
		//metodos
		public void buscar() {
			//crear dos articulos y ponerlos dentro de
			//array/vector resultados
			
			//crear un array
			/*
			int[] array = new int[2];
			String[] nombres = new String[2];
			boolean[] flags = new boolean[2];
			Articulo[] otroRes = new Articulo[2];
			*/
			
			//select * from articulos where id = claveBusqueda;	nombre like '%clavebusqueda%';	
			//esto va a devolver un array de articulos que vamos a guardar en resultados
			
			//creo el primer resultado Articulo
			Articulo res1 = new Articulo("http://sitio.com.ar/img/1.jpg",claveBusqueda," autor 1",2450);
			Articulo res2 = new Articulo("http://sitio.com.ar/img/2.jpg",claveBusqueda," autor 2",1850);
			Articulo articulo3 = new Articulo("http://sitio.com.ar/img/3.jpg",claveBusqueda,"auto 3",3650);
			
			// ejemploo de como crear arrays de distintos tipos de datos
			//int[] array = new int[2];
			//String[] nombres = new String[2];
			//boolean[] flags = new boolean[2];
			
			resultados = new Articulo[3];		// objetos 
			//cargar en cada posicion un articulo
			resultados[0] = res1;
			resultados[1] = res2;
			resultados[2]= articulo3;
			
			//actualizo la cantidad de resultados
			//en base al tamanio del vector
			cantidad = resultados.length;
		}
		
		
		// esta accion, este metodo, esta funcionalidad recibe un codigo que viene
		// desde el buscador y lo pisa en el valor de claveBusqueda
		public void setClaveBusqueda(String claveQueVieneDeAfuera) {
			claveBusqueda = claveQueVieneDeAfuera;
		}
		
		// esta funcion va a retornar articulos con todos los resultados
		public Articulo[] getResultados() {
			return resultados;
		}
		
		// como los atributos son privados a traves del metodo publico vamos a obtener desde afuera la cantidad
		
		public int getTotal() {
			return cantidad;
		}
		

}
