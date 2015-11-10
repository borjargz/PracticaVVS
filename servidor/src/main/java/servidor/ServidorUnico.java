package servidor;

import java.util.List;

import contenido.Contenido;

public class ServidorUnico extends ServidorGenerico{
	
	public ServidorUnico(String nombre,String adminToken) {
		super(nombre,adminToken);
	}

	public List<Contenido> Buscar(String buscar, String tk){
		return super.Buscar(buscar, tk);
	}



}
