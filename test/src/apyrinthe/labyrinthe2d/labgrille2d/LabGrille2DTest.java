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
package apyrinthe.labyrinthe2d.labgrille2d;

import static org.junit.Assert.*;

import org.junit.Test;

import apyrinthe.labyrinthe2d.labgrille2d.cases.Case;
import apyrinthe.labyrinthe2d.labgrille2d.cases.Couloir;
import apyrinthe.labyrinthe2d.labgrille2d.exception.CaseVoisineException;
import apyrinthe.labyrinthe2d.labgrille2d.exception.ConstructionLabGrille2DException;

public class LabGrille2DTest {

	@Test
	public void testConstruction() {
		LabGrille2D laby = null;
		boolean exception = false;
		try {
			laby = new LabGrille2D(-1, 1);
		} catch(ConstructionLabGrille2DException e) {
			exception = true;
		}
		assertTrue("ConstructionLabGrille2DException attendue pour nombre de colonnes négatif.", exception);
		exception = false;
		try {
			laby = new LabGrille2D(1, -1);
		} catch(ConstructionLabGrille2DException e) {
			exception = true;
		}
		assertTrue("ConstructionLabGrille2DException attendue pour nombre de lignes négatif.", exception);
		exception = false;
		try {
			laby = new LabGrille2D(1, 0);
		} catch(ConstructionLabGrille2DException e) {
			exception = true;
		}
		assertTrue("ConstructionLabGrille2DException attendue pour nombre de colonnes nul.", exception);
		exception = false;
		try {
			laby = new LabGrille2D(0, 1);
		} catch(ConstructionLabGrille2DException e) {
			exception = true;
		}
		assertTrue("ConstructionLabGrille2DException attendue pour nombre de lignes nul.", exception);
		exception = false;
		try {
			laby = new LabGrille2D(0, 0);
		} catch(ConstructionLabGrille2DException e) {
			exception = true;
		}
		assertTrue("ConstructionLabGrille2DException attendue pour nombre de lignes et de colonnes nul.", exception);
		exception = false;
		try {
			laby = new LabGrille2D(-1, -1);
		} catch(ConstructionLabGrille2DException e) {
			exception = true;
		}
		assertTrue("ConstructionLabGrille2DException attendue pour nombre de lignes et de colonnes négatif.", exception);
		exception = false;
		try {
			laby = new LabGrille2D(3, 2);
		} catch(Exception e) {
			exception = true;
		}
		assertFalse("Echec de la création.", exception);
		assertEquals("Nombre de lignes incorrect", 2, laby.getNbLignes());
		assertEquals("Nombre de lignes incorrect", 3, laby.getNbColonnes());
	}

	@Test
	public void testSetGetCase() {
		LabGrille2D laby = new LabGrille2D(5, 6);
		Case case1 = new Couloir();
		
		laby.setCase(0, 0, case1);
		assertTrue("Erreur de setCase ou getCase.", case1 == laby.getCase(0, 0));
	}
	
	@Test 
	public void testUpdateVoisines() {
		/* ...
		 * ...
		 * 23.
		 * 1..
		 */
		LabGrille2D laby = new LabGrille2D(3, 4);
		Case case1 = new Couloir();
		Case case2 = new Couloir();
		Case case3 = new Couloir();
		laby.setCase(0, 0, case1);
		
		try {
			laby.updateVoisines(0, 0);
		} catch(CaseVoisineException e) {
			fail("Erreur de modification de voisine : " + e.getMessage());
		}
		assertTrue("Une seule case renseigné ne devait pas avoir de voisines.", case1.getZonesAccessibles().isEmpty());
		
		laby.setCase(0, 1, case2);
		try {
			laby.updateVoisines(0, 0);
		} catch(CaseVoisineException e) {
			fail("Erreur de modification de voisine : " + e.getMessage());
		}
		assertEquals("Nombre de voisines incorrect pour case1.", 1, case1.getZonesAccessibles().size());
		assertTrue("La case2 n'est pas au nord de la case1.", case1.getVoisine(Direction.NORD) == case2);
		
		laby.setCase(1, 1, case3);
		try {
			laby.updateVoisines();
		} catch(CaseVoisineException e) {
			fail("Erreur de modification de voisine : " + e.getMessage());
		}
		assertEquals("Nombre de voisines incorrect pour case1.", 1, case1.getZonesAccessibles().size());
		assertEquals("Nombre de voisines incorrect pour case2.", 2, case2.getZonesAccessibles().size());
		assertEquals("Nombre de voisines incorrect pour case3.", 1, case3.getZonesAccessibles().size());
		assertTrue("La case2 n'est pas à l'ouest de la case3.", case3.getVoisine(Direction.OUEST) == case2);
		assertTrue("La case3 n'est pas à l'est de la case2.", case2.getVoisine(Direction.EST) == case3);
	}
}
