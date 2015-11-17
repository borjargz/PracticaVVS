package servidor;

import java.util.List;

import contenido.Contenido;
import utils.DuplicatedContentException;
import utils.TokenNotFoundException;

public interface Servidor {
	/**
	 * Metodo que obtiene el nombre del servidor.
	 * @return Devuelve el nombre del servidor.
	 */
	public String obtenerNombre();
	/**
	 * Metodo para dar de alta un nuevo servidor.
	 * @return
	 */
	public String Alta();
	/**
	 * Metodo para eliminar un servidor.
	 * @param tk token para darlo de baja.
	 */
	public void Baja(String tk);
	/**
	 * Metodo que agrega contenido a un servidor.
	 * Para agregar contenido a un servidor es necesario emplear un token especial
	 * de administracion.
	 * @param c Contenido a agregar
	 * @param tk token empleado para agregar contenido
	 * @throws DuplicatedContentException Si se desea agregar un elemento que ya existe.
	 * @throws TokenNotFoundException Si se emplea un token no encontrado.
	 */
	public void Agregar(Contenido c, String tk) throws DuplicatedContentException,TokenNotFoundException;
	/**
	 * Metodo que elimina contenido de un servidor.
	 * Para eliminar contenido de un servidor es necesario emplear un token especial
	 * de administracion.
	 * @param c Contenido a eliminar
	 * @param tk token empleado para eliminar contenido.
	 * @throws TokenNotFoundException Si se emplea un token no encontrado.
	 */
	public void Eliminar(Contenido c,String tk) throws TokenNotFoundException;
	/**
	 * Metodo que busca contenido dentro de un servidor.
	 * @param buscar Cadena de texto a buscar en el servidor.
	 * @param tk token empleado para la busqueda.
	 * @return Devuelve una lista de elementos que coinciden con la busqueda.
	 * @throws TokenNotFoundException Si el token empleado no es encontrado.
	 */
	public List<Contenido> Buscar(String buscar,String tk);
}
