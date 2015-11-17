package servidor;

import java.util.ArrayList;
import java.util.List;

import contenido.Anuncio;
import contenido.Contenido;
import token.Token;
import utils.DuplicatedContentException;
import utils.TokenNotFoundException;

public abstract class ServidorGenerico implements Servidor{
	/**
	 * Nombre del servidor.
	 */
	private String nombre;
	/**
	 * Token de administrador, que permite agregar y eliminar contenidos.
	 */
	private String adminToken;
	/**
	 * Lista de contenidos disponibles en el servidor.
	 */
	protected List<Contenido> contenidos; 
	
	/**
	 * Constructor del servidor
	 * @param nombre nombre del servidor
	 * @param adminToken token empleado para añadir y eliminar contenido.
	 */
	public ServidorGenerico(String nombre,String adminToken) {
		super();
		this.nombre = nombre;
		this.adminToken = adminToken;
	}
	
	
	public String obtenerNombre(){
		return nombre;
	}
	
	public String Alta(){
		contenidos = new ArrayList<Contenido>();
		return Token.anadirToken();
	}
	
	public void Baja(String tk){
		Token.eliminarToken(tk);
	}
	
	public void Agregar(Contenido c, String tk) throws DuplicatedContentException, TokenNotFoundException{
		if(tk.equalsIgnoreCase(adminToken)){
			if(contenidos.contains(c))
				throw new DuplicatedContentException(c);
			else
				contenidos.add(c);
		}
	}
	
	public void Eliminar(Contenido c,String tk) throws TokenNotFoundException{
		if(tk.equals(adminToken))
			contenidos.remove(c);
	}
	
	public List<Contenido> Buscar(String buscar,String tk){
		List<Contenido> resultado = new ArrayList<Contenido>();
		/**
		 * Si se emplea un token vacio en las busquedas,
		 * se comienza con un anuncio y cada tres contenidos se reproduce
		 * otro anuncio.
		 */
		if(tk == "")
		{
			resultado = addPublicidad();
		}
		else
		{
			/**
			 * Si puedes emplear el token, devuelves el resultado de la busqueda.
			 */
			try{
				Token.usarToken(tk);
				for(Contenido c: contenidos){
					resultado.addAll(c.Buscar(buscar));
				}
			}
			/**
			 * Si el token no se encuentra por haber llegado al limite de usos, se inserta publi.
			 */
			catch(TokenNotFoundException e){
				resultado = addPublicidad();
			}
		}
		
		return resultado;
	}
	
	private List<Contenido> addPublicidad(){
		List<Contenido> resultado = new ArrayList<Contenido>();
		int i = 0;
		int contador=0;
		while (i<contenidos.size()){
			contador++;
			if(contador == 3){
				resultado.add(i,new Anuncio());
				contador = 0;
			}
			i++;
		}
		return resultado;
	}
}
