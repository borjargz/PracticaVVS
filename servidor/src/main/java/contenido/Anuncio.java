package contenido;

import java.util.List;

public class Anuncio implements Contenido {

	private String titulo;
	private int duracion;
	
	public Anuncio()
	{
		this.titulo = "Publicidad";
		this.duracion = 5;
	}
	
	public String obtenerTitulo() {
		return this.titulo;
	}

	public int obtenerDuracion() {
		return this.duracion;
	}

	public List<Contenido> obtenerListaReproduccion() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Contenido> buscar(String subcadena) {
		// TODO Auto-generated method stub
		return null;
	}

	public void agregar(Contenido contenido, Contenido predecesor) {
		
	}

	public void eliminar(Contenido contenido) {
		
	}

}
