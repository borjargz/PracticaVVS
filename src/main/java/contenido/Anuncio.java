package contenido;

import java.util.ArrayList;
import java.util.List;

public class Anuncio implements Contenido {
	/**
	 * Atributo que almacena el titulo del anuncio.
	 */
	private String titulo;
	/**
	 * Atributo que almacena la duración del anuncio.
	 */
	private int duracion;
	/**
	 * Lista generica que almacena el contenido a reproducir en el servidor.
	 */
	private List<Contenido> listaReproduccion;
	/**
	 * Constructor de la clase, en la que se inicializan los atributos.
	 * En el caso de un anuncio, el titulo será 'Publicidad' y la duracion 5.
	 */
	public Anuncio()
	{
		this.titulo = "Publicidad";
		this.duracion = 5;
		listaReproduccion = new ArrayList<Contenido>();
	}
	
	public String obtenerTitulo() {
		return this.titulo;
	}

	public int obtenerDuracion() {
		return this.duracion;
	}

	public List<Contenido> obtenerListaReproduccion() {
		listaReproduccion.add(this);
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
