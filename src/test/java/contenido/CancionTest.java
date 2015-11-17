package contenido;

import java.util.List;

import junit.framework.TestCase;

public class CancionTest extends TestCase {

	private Contenido cancion;
	private Contenido cancion2;
	
	protected void setUp() throws Exception {
		cancion = new Cancion("cancion1", 3);
		cancion2 = new Cancion("cancion2",4);
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testObtenerTitulo() {
		assertEquals("cancion1",cancion.obtenerTitulo());
		assertEquals("cancion2",cancion2.obtenerTitulo());
	}

	public void testObtenerDuracion() {
		assertEquals(3,cancion.obtenerDuracion());
		assertEquals(4,cancion2.obtenerDuracion());
	}

	public void testObtenerListaReproduccion() {
		List<Contenido> lista = cancion.obtenerListaReproduccion();
		assertEquals(lista.size(), 1);
		for (int i = 0; i < lista.size(); i++) {
			assertEquals(lista.get(i), cancion);
		}
	}

	public void testBuscar() {
		List<Contenido> lista = cancion.Buscar("PUBLICIDAD");
		assertEquals(0, lista.size());
		lista = cancion.Buscar("pepe");
		assertEquals(0, lista.size());
		lista = cancion.Buscar("can");
		assertEquals(1, lista.size());
		assertEquals(cancion,lista.get(0));
		
		lista = cancion2.Buscar("can");
		assertEquals(1, lista.size());
		assertEquals(cancion2,lista.get(0));
	}


}
