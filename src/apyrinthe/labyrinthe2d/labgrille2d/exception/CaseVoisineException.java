package apyrinthe.labyrinthe2d.labgrille2d.exception;

/**
 * Exception liée à l'accès ou la manipulation de case voisine.
 */
public class CaseVoisineException extends RuntimeException {
	/**
	 * Crée une exception de case voisine.
	 * @param message le message de l'exception.
	 */
	public CaseVoisineException(String message) {
		super(message);
	}
}
