package apyrinthe.labyrinthe2d.labgrille2d.exception;

/**
 * Exception provenant d'une erreur de construction d'un labyrinthe 2D sous forme de grille.
 */
public class ConstructionLabGrille2DException extends RuntimeException {
	
	/**
	 * Crée une exception de construction de LabGrille2D.
	 * 
	 * @param message le message d'erreur.
	 */
	public ConstructionLabGrille2DException(String message) {
		super(message);
	}
	
	/**
	 * Crée une exception de construction de LabGrille2D avec le message par défaut en fonction des paramètres de construction.
	 * 
	 * @param nbColParam le nombre de colonnes demandées à la construction.
	 * @param nbLiParam le nombre de lignes demandées à la construction.
	 */
	public ConstructionLabGrille2DException(final int nbColParam, final int nbLiParam) {
		this("Paramètre de construction incorrects : col=" + nbColParam + ", li=" + nbLiParam);
	}
}
