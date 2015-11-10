package servidor;

import java.util.ArrayList;
import java.util.List;

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
		if (contenidos.contains(c))
			throw new DuplicatedContentException(c);
		if(tk.equalsIgnoreCase(adminToken))
			contenidos.add(c);
	}
	
	public void Eliminar(Contenido c,String tk) throws TokenNotFoundException{
		if(tk.equals(adminToken))
			contenidos.remove(c);
	}
	
	public List<Contenido> Buscar(String buscar,String tk){
		List<Contenido> resultado = new ArrayList<Contenido>();
		/*List<Contenido> tmp = new ArrayList<Contenido>();
		List<Contenido> tmp2 = new ArrayList<Contenido>();
		for (Contenido c : this.contenidos) {
			tmp = c.buscar(buscar);
			if (tmp.size() != 0)
				tmp2.addAll(tmp);
		}
		if (this.getTokens().containsKey(token)
				&& (this.getTokens().get(token).intValue() > 0)) {
			int restantes = this.getTokens().get(token).intValue();
			tmp.clear();
			if(restantes == 0)
				throw new SearchLimitReachedException(token);
			for(int j = 0; j<tmp2.size();j++){
				tmp.add(tmp2.get(j));
				restantes--;
				if(restantes == 0)
					break;
			}
			resultado = tmp;
			if (restantes > 0) {
				this.baja(token);
				this.getTokens().put(token, restantes);
			} else
				this.baja(token);
		} else {
			resultado.add(new Anuncio());
			// meter publi
			int count = 0;
			for (int i = 1; i < tmp2.size(); i++) {
				if (count == 3) {
					resultado.add(new Anuncio());
					count = 0;
				}
				resultado.add(tmp2.get(i-1));
				
				count++;
			}
		}*/
		return resultado;
	}
}
