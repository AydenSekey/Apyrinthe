package apyrinthe.labyrinthe2d.labgrille2d.cases;

import apyrinthe.VisiteurZone;

/**
 * Visiteur pour les différents types de case.
 */
public interface VisiteurCase extends VisiteurZone {
	/**
	 * Visite d'un couloir.
	 * 
	 * @param couloir le couloir à visiter.
	 */
	public void visiter(Couloir couloir);
}
