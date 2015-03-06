/*
Copyright Adrien Duroy (2015)
 
ad.duroy@gmail.com

This file is part of Apyrinthe.
Apyrinthe is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Apyrinthe is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with Apyrinthe.  If not, see <http://www.gnu.org/licenses/>.
 */
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
