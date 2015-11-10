package token;

import java.util.HashMap;
import java.util.Random;

import utils.TokenNotFoundException;

public class Token {
		/**
		 * HashMap que almacena pares de 'token' con 'numero de uso'
		 */
		public static HashMap<String, Integer> tokens = new HashMap<String, Integer>();
		/**
		 * Cadena de caracteres que pueden incluirse en el token generado de forma automatica.
		 */
		static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		/**
		 * Semilla empleada para generar de forma aleatoria los tokens.
		 */
		static Random rnd = new Random(); 
		/**
		 * Longitud permitida en los tokens.
		 */
		public static int len = 10; 
		/**
		 * Numero de usos permitodo para cada token.
		 */
		public static int usos = 10; 

		/**
		 * Anade un token al map de tokens con sus usos correspondientes.
		 * @return Devuelve el token generado.
		 */
		public static String anadirToken() {
			String token = randomString();
			if (tokens.containsKey(token))
				return anadirToken();
			else {
				tokens.put(token, usos);
				return token;
			}
		}

		/**
		 * Elimina un token del map de tokens.
		 * @param token token a eliminar del map.
		 */
		public static void eliminarToken(String token) {
			tokens.remove(token);
		}

		/**
		 * Valida la existencia de un token dentro del map para poder emplearlo.
		 * @param token token a validar.
		 * @throws TokenNotFoundException excepcion que indica la existencia del token.
		 */
		public static void validarToken(String token) throws TokenNotFoundException {
			if (!tokens.containsKey(token))
				throw new TokenNotFoundException(token);
		}

		/**
		 * Uso de un token para el servidor, cada vez que se usa
		 * se le restan los usos disponibles y en el caso de que llegue a
		 * cero, el token se elimina del mapa.
		 * @param token token a emplear.
		 * @throws TokenNotFoundException si el token a emplear no existe.
		 */
		public static void usarToken(String token) throws TokenNotFoundException {
			if (!tokens.containsKey(token))
				throw new TokenNotFoundException(token);
			else {
				int usos = tokens.get(token);
				usos = usos - 1;
				if (usos > 0)
					tokens.put(token, usos);
				else
					eliminarToken(token);
			}
		}

		private static String randomString() {
			StringBuilder sb = new StringBuilder(len);
			for (int i = 0; i < len; i++)
				sb.append(AB.charAt(rnd.nextInt(AB.length())));
			return sb.toString();
		}
}
