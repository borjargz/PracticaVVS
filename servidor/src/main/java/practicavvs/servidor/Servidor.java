package practicavvs.servidor;

import contenido.Contenido;
import token.Token;

public interface Servidor {

	public String obtenerNombre();
	
	public String Alta();
	
	public String Baja(Token tk);
	
	public String Agregar(Contenido c, Token tk);
	
	public String Eliminar(Contenido c,Token tk);
	
	public String Buscar(String buscar,Token tk);
}
