package contenido;

import java.util.List;

import junit.framework.TestCase;

public class AnuncioTest extends TestCase {

	private Contenido anuncio;
	
	protected void setUp() throws Exception {
		anuncio = new Anuncio();
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAnuncio() {
		
	}

	public void testObtenerTitulo() {
		assertTrue(anuncio.obtenerTitulo().equalsIgnoreCase("Publicidad"));
		assertEquals("Publicidad", anuncio.obtenerTitulo());
	}

	public void testObtenerDuracion() {
		assertEquals(5, anuncio.obtenerDuracion());
	}

	public void testObtenerListaReproduccion() {
		List<Contenido> lista = anuncio.obtenerListaReproduccion();
		assertEquals(lista.size(), 1);
		for (int i = 0; i < lista.size(); i++) {
			assertEquals(lista.get(i), anuncio);
		}
	}

	public void testBuscar() {
		List<Contenido> lista = anuncio.buscar("PUBLICIDAD");
		assertEquals(0, lista.size());
		lista = anuncio.buscar("pepe");
		assertEquals(0, lista.size());
		lista = anuncio.buscar("Publicidad");
		assertEquals(1, lista.size());
		assertEquals(anuncio,lista.get(0));
		
	}

}
