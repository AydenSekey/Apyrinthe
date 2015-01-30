package apyrinthe.labyrinthe2d.labgrille2d.exception;

/**
 * Exception de direction incorrecte.
 */
public class IncorrecteDirectionException extends RuntimeException {
	/**
	 * Crée une exception de direction incorrecte.
	 * @param message le message de l'exception.
	 */
	public IncorrecteDirectionException(String message) {
		super(message);
	}
}
