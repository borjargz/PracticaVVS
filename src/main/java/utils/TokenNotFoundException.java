package utils;

@SuppressWarnings("serial")
public class TokenNotFoundException extends Exception {
		public TokenNotFoundException(String token) {
			super(" Token " + token + "Not Found ");
		}
}
