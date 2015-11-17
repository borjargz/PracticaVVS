package servidor;

import java.util.List;

import contenido.Contenido;

public class ServidorRespaldo extends ServidorGenerico {

	private ServidorGenerico servidorRespaldo;
	
	public ServidorRespaldo(String nombre,String adminToken,ServidorGenerico res) {
		super(nombre,adminToken);
		this.servidorRespaldo = res;
	}

	public List<Contenido> Buscar(String buscar, String tk){
		List<Contenido> resultado = super.Buscar(buscar, tk);
		if (resultado.isEmpty())
			return servidorRespaldo.Buscar(buscar, tk);
		return resultado;
	}

	

}
