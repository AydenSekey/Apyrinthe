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
		LabGrille2D laby = new LabGrille2D(5, 6);
		Case case1 = new Couloir();
		Case case2 = new Couloir();
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
		assertEquals("Nombre de voisines incorrect pour case2.", 1, case2.getZonesAccessibles().size());
	}
}
