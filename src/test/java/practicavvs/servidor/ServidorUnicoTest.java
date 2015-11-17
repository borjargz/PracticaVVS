package practicavvs.servidor;

import java.util.List;

import contenido.Anuncio;
import contenido.Cancion;
import contenido.Contenido;
import contenido.Emisora;
import junit.framework.TestCase;
import servidor.ServidorUnico;
import utils.DuplicatedContentException;
import utils.TokenNotFoundException;

public class ServidorUnicoTest extends TestCase {

	private ServidorUnico servidor;
	private Contenido emisora;
	private Contenido anuncio2;
	private Contenido cancion1;
	private Contenido cancion2;
	
	private String tokenServidor;
	
	protected void setUp() throws Exception {
		super.setUp();
		servidor = new ServidorUnico("servidor1","tokenadmin");
		emisora = new Emisora("emisora1");
		anuncio2 = new Anuncio();
		cancion1 = new Cancion("cancion1",1);
		cancion2 = new Cancion("cancion2",2);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testBuscar() throws DuplicatedContentException, TokenNotFoundException {
		/**
		 * Busqueda de una cancion existente
		 */
		tokenServidor = servidor.Alta();
		List<Contenido> resultado = servidor.Buscar("a", tokenServidor);
		assertEquals(0, resultado.size());
		servidor.Agregar(cancion1, "tokenadmin");
		resultado = servidor.Buscar("cancion", tokenServidor);
		assertEquals(1,resultado.size());
		assertEquals(cancion1,resultado.get(0));
		/**
		 * Busqueda de una cancion que no existe.
		 */
		resultado = servidor.Buscar("pepe", tokenServidor);
		//assertEquals(0,resultado.size());
		/**
		 * Busqueda de dos textos similares.
		 */
		servidor.Agregar(cancion2, "tokenadmin");
		resultado = servidor.Buscar("cancion", tokenServidor);
		assertEquals(2,resultado.size());
		assertEquals(cancion1,resultado.get(0));
		assertEquals(cancion2,resultado.get(1));
		/**
		 * Busqueda en una emisora.
		 */
		tokenServidor=servidor.Alta();
		servidor.Agregar(emisora, "tokenadmin");
		emisora.Agregar(cancion1, null);
		emisora.Agregar(cancion2, null);
		emisora.Agregar(anuncio2, null);
		resultado = servidor.Buscar("can", tokenServidor);
		assertEquals(2,resultado.size());
		assertEquals(cancion2,resultado.get(0));
		assertEquals(cancion1,resultado.get(1));
		resultado = servidor.Buscar("pee", tokenServidor);
		assertEquals(0,resultado.size());
		/**
		 * Busqueda con texto vacio.
		 */
		

		

	}

	public void testObtenerNombre() {
		assertEquals("servidor1",servidor.obtenerNombre());
	}

	public void testAltayBaja() throws DuplicatedContentException, TokenNotFoundException {
		tokenServidor = servidor.Alta();
		List<Contenido> resultado = servidor.Buscar("a", tokenServidor);
		assertEquals(0, resultado.size());
		servidor.Agregar(cancion1, "tokenadmin");
		resultado = servidor.Buscar("cancion", tokenServidor);
		assertEquals(1,resultado.size());
		assertEquals(cancion1,resultado.get(0));
		servidor.Baja(tokenServidor);
		resultado = servidor.Buscar("cancion", tokenServidor);
		assertEquals(0,resultado.size());
	}

	public void testAgregar() throws DuplicatedContentException, TokenNotFoundException {
		/**
		 * Añadir un elemento empleando el token de administrador.
		 */
		tokenServidor = servidor.Alta();
		List<Contenido> resultado = servidor.Buscar("a", tokenServidor);
		assertEquals(0, resultado.size());
		servidor.Agregar(cancion1, "tokenadmin");
		resultado = servidor.Buscar("cancion", tokenServidor);
		assertEquals(1,resultado.size());
		assertEquals(cancion1,resultado.get(0));
		/**
		 * Añadir un elemento sin el token de administrador.
		 */
		tokenServidor = servidor.Alta();
		resultado = servidor.Buscar("a", tokenServidor);
		assertEquals(0, resultado.size());
		servidor.Agregar(cancion1, "pepe");
		resultado = servidor.Buscar("cancion", tokenServidor);
		assertEquals(0,resultado.size());

	}

	//@Test(expected=DuplicatedContentException.class)
	public void testElementoAnadido() throws DuplicatedContentException, TokenNotFoundException {
		/**
		 * Añadir un elemento previamente añadido.
		 */
		//servidor.Agregar(cancion1, "tokenadmin");
		//servidor.Agregar(cancion1, "tokenadmin");
		//TODO: Ver como capturar las excepciones en junit 3.8 para los test.
	}
	
	public void testEliminar() throws DuplicatedContentException, TokenNotFoundException {
		/**
		 * Eliminar un elemento empleando el token de administrador.
		 */
		tokenServidor = servidor.Alta();
		List<Contenido> resultado = servidor.Buscar("a", tokenServidor);
		assertEquals(0, resultado.size());
		servidor.Agregar(cancion1, "tokenadmin");
		resultado = servidor.Buscar("cancion", tokenServidor);
		assertEquals(1,resultado.size());
		assertEquals(cancion1,resultado.get(0));
		servidor.Eliminar(cancion1, "tokenadmin");
		resultado = servidor.Buscar("cancion", tokenServidor);
		assertEquals(0,resultado.size());
		
		/**
		 * Eliminar un elemento sin el token de administrador.
		 */
		tokenServidor = servidor.Alta();
		resultado = servidor.Buscar("a", tokenServidor);
		assertEquals(0, resultado.size());
		servidor.Agregar(cancion1, "tokenadmin");
		resultado = servidor.Buscar("cancion", tokenServidor);
		assertEquals(1,resultado.size());
		assertEquals(cancion1,resultado.get(0));
		servidor.Eliminar(cancion1, "peeee");
		resultado = servidor.Buscar("cancion", tokenServidor);
		assertEquals(1,resultado.size());
		assertEquals(cancion1,resultado.get(0));
	}


}
