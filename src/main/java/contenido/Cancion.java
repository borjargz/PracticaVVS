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

	
	

	public List<Contenido> Buscar(String subcadena) {
		if (titulo.contains(subcadena)&&!listaReproduccion.contains(this)){
			listaReproduccion.add(this);
		}
		return listaReproduccion;
	}

	public void Agregar(Contenido contenido, Contenido predecesor) {
		
	}

	public void Eliminar(Contenido contenido) {
		
	}

}
