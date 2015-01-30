package apyrinthe.labyrinthe2d.labgrille2d.cases;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import apyrinthe.VisiteurZone;
import apyrinthe.Zone;
import apyrinthe.labyrinthe2d.labgrille2d.Direction;
import apyrinthe.labyrinthe2d.labgrille2d.exception.CaseVoisineException;
import apyrinthe.labyrinthe2d.labgrille2d.exception.IncorrecteDirectionException;

public class CaseTest {

	@Test
	public void testVoisineDElleMeme() {
		Case laCase = newCase();
		boolean exception = false;
		try {
			laCase.setVoisine(Direction.EST, laCase);
		} catch(CaseVoisineException e) {
			exception = true;
		}
		assertTrue("CaseVoisineException non levée.", exception);
	}

	@Test
	public void testSetVoisineDirectionIncorrecte() {
		Case laCase = newCase();
		boolean exception = false;
		try {
			laCase.setVoisine(8, newCase());
		} catch(IncorrecteDirectionException e) {
			exception = true;
		}
		assertTrue("IncorrecteDirectionException non levée.", exception);
	}
	
	@Test
	public void testSetGetVoisine() {
		Case laCase = newCase();
		Case laCaseEst = newCase();
		Case laCaseOuest = newCase();
		Case laCaseNord = newCase();
		Case laCaseSud = newCase();
		
		laCase.setVoisine(Direction.EST, laCaseEst);
		Case result = laCase.getVoisine(Direction.EST);
		assertTrue("Incohérence entre les méthodes getVoisine et setVoisine pour la direction EST.", result == laCaseEst);
		
		laCase.setVoisine(Direction.OUEST, laCaseOuest);
		result = laCase.getVoisine(Direction.OUEST);
		assertTrue("Incohérence entre les méthodes getVoisine et setVoisine pour la direction OUEST.", result == laCaseOuest);

		laCase.setVoisine(Direction.NORD, laCaseNord);
		result = laCase.getVoisine(Direction.NORD);
		assertTrue("Incohérence entre les méthodes getVoisine et setVoisine pour la direction NORD.", result == laCaseNord);

		laCase.setVoisine(Direction.SUD, laCaseSud);
		result = laCase.getVoisine(Direction.SUD);
		assertTrue("Incohérence entre les méthodes getVoisine et setVoisine pour la direction SUD.", result == laCaseSud);

		laCase.setVoisine(Direction.SUD, null);
		result = laCase.getVoisine(Direction.SUD);
		assertNull("Incohérence entre les méthodes getVoisine et setVoisine avec null.", result);
	}
	
	@Test
	public void testAddGetZoneAccessible() {
		Case laCase = newCase();
		laCase.addZoneAccessible(null);
		assertEquals("Nombre de zones accessible incorrecte", 0, laCase.getZonesAccessibles().size());
		laCase.addZoneAccessible(newCase());
		assertEquals("Nombre de zones accessible incorrecte", 1, laCase.getZonesAccessibles().size());
		// Zone non de type Case
        laCase.addZoneAccessible(new Zone() {
			@Override
			public void removeZoneAccessible(Zone zone) {
			}
			
			@Override
			public boolean isEnd() {
				return false;
			}
			
			@Override
			public boolean hasZoneAccessible() {
				return false;
			}
			
			@Override
			public Set<Zone> getZonesAccessibles() {
				return null;
			}
			
			@Override
			public void clearZonesAccessible() {
			}
			
			@Override
			public void addZoneAccessible(Zone zone) {
			}
			
			@Override
			public boolean accept(VisiteurZone visiteur) {
				return false;
			}
		});
		assertEquals("Nombre de zones accessible incorrecte", 1, laCase.getZonesAccessibles().size());

		laCase.addZoneAccessible(newCase());
		laCase.addZoneAccessible(newCase());
		laCase.addZoneAccessible(newCase());
		assertEquals("Nombre de zones accessible incorrecte", 4, laCase.getZonesAccessibles().size());
		laCase.addZoneAccessible(newCase());
		laCase.addZoneAccessible(null);
		
		assertEquals("Nombre de zones accessible incorrecte", 4, laCase.getZonesAccessibles().size());
	}
	
	@Test
	public void testHasVoisine() {
		Case laCase = newCase();
		Case voisine = newCase();
		
		assertFalse("Il ne devrait pas y avoir de voisine à l'est à la construction d'une Case avec le constructeur par défaut.", laCase.hasVoisine(Direction.EST));
		assertFalse("Il ne devrait pas y avoir de voisine à l'ouest à la construction d'une Case avec le constructeur par défaut.", laCase.hasVoisine(Direction.OUEST));
		assertFalse("Il ne devrait pas y avoir de voisine au nord à la construction d'une Case avec le constructeur par défaut.", laCase.hasVoisine(Direction.NORD));
		assertFalse("Il ne devrait pas y avoir de voisine au sud à la construction d'une Case avec le constructeur par défaut.", laCase.hasVoisine(Direction.SUD));
		assertFalse("Une voisine détectée.", laCase.hasVoisine());
		
		laCase.setVoisine(Direction.EST, voisine);
		assertTrue("Il devrait y avoir une voisine à l'est.", laCase.hasVoisine(Direction.EST));

		laCase.setVoisine(Direction.OUEST, voisine);
		assertTrue("Il devrait y avoir une voisine à l'ouest.", laCase.hasVoisine(Direction.OUEST));

		laCase.setVoisine(Direction.NORD, voisine);
		assertTrue("Il devrait y avoir une voisine à l'nord.", laCase.hasVoisine(Direction.NORD));

		laCase.setVoisine(Direction.SUD, voisine);
		assertTrue("Il devrait y avoir une voisine à l'sud.", laCase.hasVoisine(Direction.SUD));
		
		laCase.setVoisine(Direction.EST, null);
		assertFalse("Il ne devrait pas y avoir de voisine à l'est après modification à null de la voisine EST.", laCase.hasVoisine(Direction.EST));
		
		assertTrue("Une voisine aurait dû être détectée.", laCase.hasVoisine());
	}
	
	@Test
	public void testHasZoneAccessible() {
		Case laCase = newCase();
		assertFalse("Aucune zone accessible n'aurait dû être détectée.", laCase.hasZoneAccessible());
		laCase.addZoneAccessible(newCase());
		assertTrue("Une zone accessible aurait dû être détectée.", laCase.hasZoneAccessible());
	}
	
	@Test
	public void testRemoveVoisine() {
		Case laCase = newCase();
		laCase.setVoisine(Direction.EST, newCase());
		laCase.setVoisine(Direction.SUD, newCase());
		laCase.setVoisine(Direction.NORD, newCase());
		laCase.setVoisine(Direction.OUEST, newCase());
		
		assertNotNull("La voisine Est n'existe pas", laCase.getVoisine(Direction.EST));
		laCase.removeVoisine(Direction.EST);
		assertNull("La voisine Est existe après suppression", laCase.getVoisine(Direction.EST));

		assertNotNull("La voisine Sud n'existe pas", laCase.getVoisine(Direction.SUD));
		laCase.removeVoisine(Direction.SUD);
		assertNull("La voisine Sud existe après suppression", laCase.getVoisine(Direction.SUD));

		assertNotNull("La voisine Nord n'existe pas", laCase.getVoisine(Direction.NORD));
		laCase.removeVoisine(Direction.NORD);
		assertNull("La voisine Nord existe après suppression", laCase.getVoisine(Direction.NORD));

		assertNotNull("La voisine Ouest n'existe pas", laCase.getVoisine(Direction.OUEST));
		laCase.removeVoisine(Direction.OUEST);
		assertNull("La voisine Ouest existe après suppression", laCase.getVoisine(Direction.OUEST));
	}
	
	@Test
	public void testRemoveVoisineDirectionIncorrecte() {
		Case laCase = newCase();
		boolean exception = false;
		try {
			laCase.removeVoisine(8);
		} catch(IncorrecteDirectionException e) {
			exception = true;
		}
		assertTrue("IncorrecteDirectionException non levée.", exception);
	}

	@Test
	public void testRemoveZoneAccessible() {
		Case laCase = newCase();
		laCase.setVoisine(Direction.EST, newCase());
		
		assertNotNull("La voisine Est n'existe pas", laCase.getVoisine(Direction.EST));
		laCase.removeZoneAccessible(laCase.getVoisine(Direction.EST));
		assertNull("La voisine Est existe après suppression", laCase.getVoisine(Direction.EST));
	}

	/*
	 * Crée une instance de Case dont aucune méthode non abstraite n'est redéfinie par rapport au type Case.
	 */
	private Case newCase() {
		return new Case() {
			@Override
			public boolean isEnd() {
				return false;
			}

			@Override
			public boolean accept(VisiteurZone visiteur) {
				return false;
			}
			
		};
	}
}
