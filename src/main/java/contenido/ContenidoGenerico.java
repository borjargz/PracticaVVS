package contenido;

import java.util.List;

public abstract class ContenidoGenerico implements Contenido {
	/**
	 * Atributo que almacena el titulo del anuncio.
	 */
	protected String titulo;
	/**
	 * Atributo que almacena la duración del anuncio.
	 */
	protected int duracion;
	/**
	 * Lista generica que almacena el contenido a reproducir en el servidor.
	 */
	protected List<Contenido> listaReproduccion;
	
	public String obtenerTitulo(){
		return titulo;
	}
	
	
	public int obtenerDuracion(){
		return duracion;
	}
	

	public List<Contenido> obtenerListaReproduccion(){
		listaReproduccion.add(this);
		return listaReproduccion;
	}
	

	public abstract List<Contenido> buscar(String subcadena);
	
	public abstract void agregar(Contenido contenido, Contenido predecesor);
	
	public abstract void eliminar(Contenido contenido);
}
