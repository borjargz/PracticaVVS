package contenido;

import java.util.ArrayList;
import java.util.List;

public class Cancion extends ContenidoGenerico {

	/**
	 * Constructor con el que se inicializa la cancion.
	 * @param titulo Titulo de la cancion.
	 * @param duracion Duracion de la cancion.
	 */
	public Cancion(String titulo, int duracion){
		this.titulo = titulo;
		this.duracion = duracion;
		listaReproduccion = new ArrayList<Contenido>();
	}

	
	

	public List<Contenido> buscar(String subcadena) {
		if (titulo.contains(subcadena)){
			listaReproduccion.add(this);
		}
		return listaReproduccion;
	}

	public void agregar(Contenido contenido, Contenido predecesor) {
		
	}

	public void eliminar(Contenido contenido) {
		
	}

}
