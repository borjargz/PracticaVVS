package utils;

import contenido.Contenido;

@SuppressWarnings("serial")
public class DuplicatedContentException extends Exception {
		public DuplicatedContentException(Contenido c) {
			super(" Contenido " + c + " ya esta en el servidor. ");
		}
}
