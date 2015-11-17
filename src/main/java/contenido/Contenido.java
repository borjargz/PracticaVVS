package contenido;

import java.util.List;

public interface Contenido {
	
	/**
	 * Metodo que consulta el titulo de un elemento.
	 * @return Devuelve una cadena con el titulo del elemento.
	 */
	public String obtenerTitulo();
	
	/**
	 * Metodo que consulta la duracion de un elemento.
	 * @return Devuelve un entero con la duracion del elemento.
	 */
	public int obtenerDuracion();
	
	/**
	 * Metodo que consulta la lista de reproduccion.
	 * @return Devuelve una lista de reproduccion de contenidos (anuncios,canciones o emisoras).
	 */
	public List<Contenido> obtenerListaReproduccion();
	
	/**
	 * Metodo para buscar contenido dentro de una lista.
	 * @param subcadena subcadena a buscar dentro de la lista de contenido.
	 * @return Devuelve una lista de contenido con los elementos que coincidan
	 * con la subcadena buscada.
	 */
	public List<Contenido> buscar(String subcadena);
	

	/**
	 * Metodo para agregar contenido a la lista, el elemento nuevo se
	 * inserta a continuacion del ultimo elemento existente.
	 * Si no hay ningun elemento, se insertará al inicio.
	 * @param contenido Elemento a agregar.
	 * @param predecesor Elemento previo existente en la lista.
	 */
	public void agregar(Contenido contenido, Contenido predecesor);
	
	/**
	 * Metodo que elimina contenido de una lista.
	 * @param contenido Elemento a eliminar de la lista.
	 */
	public void eliminar(Contenido contenido);
}
