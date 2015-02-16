/*
Copyright Adrien Duroy (2015)

This file is part of Apyrinthe.

ad.duroy@gmail.com

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
package apyrinthe.labyrinthe2d.labgrille2d.cases;

import static org.junit.Assert.*;

import org.junit.Test;

import apyrinthe.Zone;

public class VisiteurCaseTest {

	@Test
	public void test() {
		final Case leCouloir = new Couloir();
		final Case leMur = new Mur();
		VisiteurCase visiteur = new VisiteurCase() {
			@Override
			public void visiter(Zone zone) {
				fail("Visite de Zone non attendu.");
			}
			
			@Override
			public void visiter(Mur mur) {
				assertTrue("Mauvaise instance de Mur visitée.", mur == leMur);
			}
			
			@Override
			public void visiter(Couloir couloir) {
				assertTrue("Mauvaise instance de Couloir visitée.", couloir == leCouloir);
			}
		};
		
		boolean visite = leCouloir.accept(visiteur);
		assertTrue("Visite de couloir non effectuée.", visite);
		
		visite = leMur.accept(visiteur);
		assertTrue("Visite de mur non effectuée.", visite);
	}

}
