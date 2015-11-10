package contenido;

import java.util.ArrayList;
import java.util.List;

public class Cancion implements Contenido {
	/**
	 * Atributo que almacena el titulo de la cancion.
	 */
	private String titulo;
	/**
	 * Atributo que almacena la duracion de la cancion.
	 */
	private int duracion;
	/**
	 * Lista que almacena la lista de reproduccion.
	 */
	private List<Contenido> listaReproduccion;
	
	public Cancion(){
		
	}
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

	
	public String obtenerTitulo() {
		return titulo;
	}

	public int obtenerDuracion() {
		return duracion;
	}

	public List<Contenido> obtenerListaReproduccion() {
		return listaReproduccion;
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
