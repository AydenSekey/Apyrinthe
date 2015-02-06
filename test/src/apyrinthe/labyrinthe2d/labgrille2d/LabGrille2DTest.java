package apyrinthe.labyrinthe2d.labgrille2d;

import static org.junit.Assert.*;

import org.junit.Test;

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

}
