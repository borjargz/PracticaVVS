package contenido;

import java.util.List;

import junit.framework.TestCase;

public class EmisoraTest extends TestCase {

	private Contenido emisora;
	private Contenido anuncio1;
	private Contenido anuncio2;
	private Contenido cancion1;
	private Contenido cancion2;
	
	protected void setUp() throws Exception {
		emisora = new Emisora("emisora1");
		anuncio1 = new Anuncio();
		anuncio2 = new Anuncio();
		cancion1 = new Cancion("cancion1",1);
		cancion2 = new Cancion("cancion2",2);
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testObtenerTitulo() {
		assertEquals("emisora1",emisora.obtenerTitulo());
	}

	public void testObtenerDuracion() {
		assertEquals(0,emisora.obtenerDuracion());
	}

	public void testObtenerListaReproduccion() {
		List<Contenido> lista = emisora.obtenerListaReproduccion();
		assertEquals(0, lista.size());
		
		emisora.agregar(anuncio1, null);
		lista = emisora.obtenerListaReproduccion();
		assertEquals(1,lista.size());
		assertEquals(anuncio1,lista.get(0));
		assertEquals(5,emisora.obtenerDuracion());
		
		emisora.agregar(anuncio2, null);
		lista = emisora.obtenerListaReproduccion();
		assertEquals(2,lista.size());
		assertEquals(anuncio2,lista.get(0));
		assertEquals(anuncio1,lista.get(1));
		assertEquals(10,emisora.obtenerDuracion());
	}

	public void testBuscar() {
		List<Contenido> lista = emisora.obtenerListaReproduccion();
		assertEquals(0, lista.size());
		
		emisora.agregar(anuncio1, null);
		lista = emisora.obtenerListaReproduccion();
		assertEquals(1,lista.size());
		assertEquals(anuncio1,lista.get(0));
		assertEquals(5,emisora.obtenerDuracion());
		
		emisora.agregar(cancion1, null);
		emisora.agregar(cancion2, null);
		lista = emisora.obtenerListaReproduccion();
		assertEquals(3,lista.size());
		assertEquals(cancion2,lista.get(0));
		assertEquals(cancion1,lista.get(1));
		assertEquals(anuncio1,lista.get(2));
		assertEquals(8,emisora.obtenerDuracion());
		
		lista = emisora.buscar("can");
		assertEquals(2,lista.size());
		assertEquals(cancion2,lista.get(0));
		assertEquals(cancion1,lista.get(1));
		
		
		lista = emisora.buscar("pepe");
		assertEquals(0,lista.size());
	}

	public void testAgregar() {
		List<Contenido> lista = emisora.obtenerListaReproduccion();
		assertEquals(0, lista.size());
		
		emisora.agregar(anuncio1, null);
		lista = emisora.obtenerListaReproduccion();
		assertEquals(1,lista.size());
		assertEquals(anuncio1,lista.get(0));
		
		emisora.agregar(cancion1, null);
		emisora.agregar(cancion2, null);
		lista = emisora.obtenerListaReproduccion();
		assertEquals(3,lista.size());
		assertEquals(cancion2,lista.get(0));
		assertEquals(cancion1,lista.get(1));
		assertEquals(anuncio1,lista.get(2));
	}

	public void testEliminar() {
		List<Contenido> lista = emisora.obtenerListaReproduccion();
		assertEquals(0, lista.size());
		
		emisora.agregar(anuncio1, null);
		lista = emisora.obtenerListaReproduccion();
		assertEquals(1,lista.size());
		assertEquals(anuncio1,lista.get(0));
		
		emisora.agregar(cancion1, null);
		emisora.agregar(cancion2, null);
		lista = emisora.obtenerListaReproduccion();
		assertEquals(3,lista.size());
		assertEquals(cancion2,lista.get(0));
		assertEquals(cancion1,lista.get(1));
		assertEquals(anuncio1,lista.get(2));
		
		emisora.agregar(anuncio2, cancion1);
		lista = emisora.obtenerListaReproduccion();
		assertEquals(4,lista.size());
		assertEquals(cancion2,lista.get(0));
		assertEquals(anuncio2,lista.get(1));
		assertEquals(cancion1,lista.get(2));
		assertEquals(anuncio1,lista.get(3));
		
		
		emisora.eliminar(anuncio1);
		lista = emisora.obtenerListaReproduccion();
		assertEquals(3,lista.size());
		assertEquals(cancion2,lista.get(0));
		assertEquals(anuncio2,lista.get(1));
		assertEquals(cancion1,lista.get(2));
		assertEquals(8,emisora.obtenerDuracion());
		
		
	}

}
