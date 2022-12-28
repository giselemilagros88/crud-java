package ar.com.codoacodo.buscador;

public class MainBuscador {
	
	public static void main(String[] args) {
		
		//quiero crear un objeto de tipo Buscador
		//crear una instancia de Buscador

		//creo mi primer objeto
		Buscador miBuscador = new Buscador();
		
		//"pongo" la clave que quiero buscar
		miBuscador.setClaveBusqueda("iron man");
	//	miBuscador.claveBusqueda = "iron man";

		//ejecutar la busqueda
		miBuscador.buscar();
		
		//res no es un atributos, sino una variable de la clase MainBuscador
		//que guarda el resultado de invocar al metodo
		//buscar del objeto miBuscador (es una instancia
		//de la clase Buscador)
		Articulo[] resultados = miBuscador.getResultados();
		
		//como recorro un array?
		// guardo en cada vuelta en la variable unArticulo, cada articulo de resultados
		//[articulo1,articulo2,articulo3,articulo4...]
		for(Articulo unArticulo : resultados ) {
			unArticulo.detalle();			
		}
	}

}
