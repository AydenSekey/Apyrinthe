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
package apyrinthe.labyrinthe2d.labgrille2d.view;

import static org.junit.Assert.*;

import org.junit.Test;

import apyrinthe.labyrinthe2d.labgrille2d.LabGrille2D;
import apyrinthe.labyrinthe2d.labgrille2d.cases.Couloir;
import apyrinthe.labyrinthe2d.labgrille2d.cases.Mur;
import apyrinthe.labyrinthe2d.labgrille2d.view.ascii.LabGrille2DAsciiView;

public class LabGrille2DAsciiViewTest {

	@Test
	public void test() {
		LabGrille2D laby = creerLabyrinthe();
		LabGrille2DAsciiView view = new LabGrille2DAsciiView(laby);
		view.update();
		String result = view.getAscii();
		String attendu = "#####\n..#.#\n#...#\n###>#\n";
		assertEquals("Affichage incorrect.", attendu, result);
	}

	private LabGrille2D creerLabyrinthe() {
		/* Schéma
		 * #####
		 *   # #
		 * #   #
		 * ###>#
		 */
		LabGrille2D laby = new LabGrille2D(5, 4);
		laby.setCase(0, 0, new Mur());
		laby.setCase(0, 1, new Mur());
		laby.setCase(0, 2, new Couloir());
		laby.setCase(0, 3, new Mur());
		laby.setCase(1, 0, new Mur());
		laby.setCase(1, 1, new Couloir());
		laby.setCase(1, 2, new Couloir());
		laby.setCase(1, 3, new Mur());
		laby.setCase(2, 0, new Mur());
		laby.setCase(2, 1, new Couloir());
		laby.setCase(2, 2, new Mur());
		laby.setCase(2, 3, new Mur());
		laby.setCase(3, 0, new Couloir(true)); // C'est la sortie.
		laby.setCase(3, 1, new Couloir());
		laby.setCase(3, 2, new Couloir());
		laby.setCase(3, 3, new Mur());
		laby.setCase(4, 0, new Mur());
		laby.setCase(4, 1, new Mur());
		laby.setCase(4, 2, new Mur());
		laby.setCase(4, 3, new Mur());
		return laby;
	}
}
