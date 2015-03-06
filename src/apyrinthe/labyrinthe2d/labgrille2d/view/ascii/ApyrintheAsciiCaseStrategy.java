package apyrinthe.labyrinthe2d.labgrille2d.view.ascii;

import apyrinthe.Zone;
import apyrinthe.labyrinthe2d.labgrille2d.cases.Case;
import apyrinthe.labyrinthe2d.labgrille2d.cases.Couloir;
import apyrinthe.labyrinthe2d.labgrille2d.cases.Mur;
import apyrinthe.labyrinthe2d.labgrille2d.cases.VisiteurCase;

/**
 * Proposition de stratégie de représentation ASCII des cases. <br>
 * # : mur <br>
 * . : couloir <br>
 * &gt; : sortie
 */
public class ApyrintheAsciiCaseStrategy implements AsciiCaseStrategy, VisiteurCase {
	private char asciiChar;

	@Override
	public void visiter(Zone zone) {
		asciiChar = '?';
	}

	@Override
	public void visiter(Couloir couloir) {
		if(couloir.isSortie())
			asciiChar = '>';
		else
			asciiChar = '.';
	}

	@Override
	public void visiter(Mur mur) {
		asciiChar = '#';
	}

	@Override
	public char asciiCase(Case c) {
		c.accept(this);
		return asciiChar;
	}

}
