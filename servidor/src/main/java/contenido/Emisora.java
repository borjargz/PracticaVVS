package contenido;

import java.util.ArrayList;
import java.util.List;

public class Emisora implements Contenido{

	/**
	 * Atributo que almacena el titulo de la emisora.
	 */
	private String titulo;
	/**
	 * Atributo que almacena la duración de la emisora.
	 */
	private int duracion;
	/**
	 * Lista que almacena los elementos a reproducir en la emisora.
	 */
	private List<Contenido> listaReproduccion;
	
	public Emisora(){
		
	}
	
	/**
	 * Constructor para crear una nueva emisora.
	 * @param titulo Titulo que tiene la emisora nueva.
	 */
	public Emisora(String titulo){
		this.titulo=titulo;
		this.duracion=0;
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
		List<Contenido> lista = new ArrayList<Contenido>();
		for (int i = 0; i < listaReproduccion.size(); i++) {
			if (listaReproduccion.get(i).obtenerTitulo().toLowerCase().
					contains(subcadena.toLowerCase())) {
				lista.add(listaReproduccion.get(i));
			}
		}
		return lista;
	}
	
	public void agregar(Contenido contenido, Contenido predecesor) {
		if (predecesor == null) {
			if (listaReproduccion.isEmpty()) {
				listaReproduccion.add(contenido);
				this.duracion += contenido.obtenerDuracion();
			} else {
				listaReproduccion.add(0, contenido);
				this.duracion += contenido.obtenerDuracion();
			}
		} else {
			List<Contenido> listaAux = new ArrayList<Contenido>();
			if(listaReproduccion.isEmpty()){
				listaReproduccion.add(contenido);
				this.duracion += contenido.obtenerDuracion();
			}
			else
			{
				int posicionpredecesor = listaReproduccion.indexOf(predecesor);
				int i = posicionpredecesor;
				listaAux = listaReproduccion;
				while(i < listaReproduccion.size()){
					listaAux.add(i+1, listaReproduccion.get(i));
				}
				listaAux.add(posicionpredecesor, contenido);
				listaReproduccion = listaAux;
			}
		}
	}

	public void eliminar(Contenido contenido) {
		if (listaReproduccion.contains(contenido)) {
			listaReproduccion.remove(contenido);
		}
	}

}
