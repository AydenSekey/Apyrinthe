package apyrinthe.labyrinthe2d.labgrille2d.view.ascii;

import apyrinthe.labyrinthe2d.labgrille2d.cases.Case;

/**
 *	Stratégie de représentation d'une case par un caractère ASCII.
 */
public interface AsciiCaseStrategy {
	/**
	 * Donne le caractère ASCII pour représenter une case.
	 * 
	 * @param c la case à représenter.
	 * @return le caractère asccii pour représenter la case.
	 */
	public char asciiCase(Case c);
}
