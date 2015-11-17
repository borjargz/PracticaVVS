package contenido;

import java.util.ArrayList;
import java.util.List;

public class Anuncio extends ContenidoGenerico {
	
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
	

	public List<Contenido> Buscar(String subcadena) {
		if (titulo.contains(subcadena)&&!listaReproduccion.contains(this)){
			listaReproduccion.add(this);
		}
		return listaReproduccion;
	}


	@Override
	public void Agregar(Contenido contenido, Contenido predecesor) {
		
	}


	@Override
	public void Eliminar(Contenido contenido) {
		
	}

}
