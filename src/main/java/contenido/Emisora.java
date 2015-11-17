package contenido;

import java.util.ArrayList;
import java.util.List;

public class Emisora extends ContenidoGenerico{

	/**
	 * Constructor para crear una nueva emisora.
	 * @param titulo Titulo que tiene la emisora nueva.
	 */
	public Emisora(String titulo){
		this.titulo=titulo;
		this.duracion=0;
		listaReproduccion = new ArrayList<Contenido>();
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
				int i = 0;
				while(i < listaReproduccion.size()){
					if(i<posicionpredecesor)
						listaAux.add(i, listaReproduccion.get(i));
					else
					{
						if(i == posicionpredecesor)
							listaAux.add(contenido);
						else
						{
							listaAux.addAll(posicionpredecesor+1,
									listaReproduccion.subList(posicionpredecesor, listaReproduccion.size()));
							break;
						}
					}
					i++;
				}
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
