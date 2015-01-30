package apyrinthe.labyrinthe2d.labgrille2d.cases;

import java.util.HashSet;
import java.util.Set;

import apyrinthe.Zone;
import apyrinthe.labyrinthe2d.labgrille2d.Direction;
import apyrinthe.labyrinthe2d.labgrille2d.exception.CaseVoisineException;
import apyrinthe.labyrinthe2d.labgrille2d.exception.IncorrecteDirectionException;

/**
 * Zone d'un labyrinthe à deux dimensions modélisé par une grille. 
 */
public abstract class Case implements Zone {
	private static final int NB_MAX_VOISINES = 4;
	private final Case[] voisines;
	
	public Case() {
		super();
		voisines = new Case[NB_MAX_VOISINES];
	}
	
	@Override
	public Set<Zone> getZonesAccessibles() {
		Set<Zone> zones = new HashSet<Zone>();
		for(int i = 0; i < NB_MAX_VOISINES; i++) {
			if(voisines[i] != null) {
				zones.add(voisines[i]);
			}
		}
		return zones;
	}

	/**
	 * {@inheritDoc} <br />
	 * La zone est ajouté si elle est de type {@link Case} et si il y a moins de 4 voisines à la case.
	 */
	@Override
	public void addZoneAccessible(Zone zone) {
		if(zone instanceof Case) {
			for(int i = 0; i < NB_MAX_VOISINES; i++) {
				if(voisines[i] == null) {
					setVoisine(i, (Case) zone);
					break;
				}
			}
		}
	}
	
	@Override
	public void removeZoneAccessible(Zone zone) {
		if(zone != null) {
			for(int i = 0; i < NB_MAX_VOISINES; i++) {
				if(zone == voisines[i]) {
					voisines[i] = null;
					break;
				}
			}
		}
	}
	
	@Override
	public void clearZonesAccessible() {
		for(int i = 0; i < NB_MAX_VOISINES; i++) {
			voisines[i] = null;
		}
	}
	
	/**
	 * Identique à {@link Case#hasVoisine()}.
	 */
	@Override
	public boolean hasZoneAccessible() {
		return hasVoisine();
	}
	
	/**
	 * Test s'il y a une case voisine.
	 * 
	 * @return <code>true</code> s'il y a une case voisine, sinon <code>false</code>.
	 */
	public boolean hasVoisine() {
		for(Case c : voisines) {
			if(c != null)
				return true;
		}
		return false;
	}
	
	/**
	 * Test s'il y a une case voisine dans une direction.
	 * 
	 * @param direction la direction ({@link Direction}) dans laquelle se trouve la case voisine par rapport à la case.
	 * @return <code>true</code> s'il y a une case dans la direction, sinon <code>false</code>.
	 */
	public boolean hasVoisine(int direction) {
		if(NB_MAX_VOISINES > direction && direction >= 0) {
			return voisines[direction] != null;
		}
		return false;
	}
	
	/**
	 * Accède à une case voisine.
	 * 
	 * @param direction la direction ({@link Direction}) dans laquelle se trouve la case voisine par rapport à la case.
	 * @return la case voisine si elle existe ou <code>null</code> si elle n'existe pas.
	 * @throws IncorrecteDirectionException si la direction est incorrecte.
	 */
	public Case getVoisine(int direction) {
		if(direction < NB_MAX_VOISINES && direction >= 0) {
			return voisines[direction];
		} else {
			throw new IncorrecteDirectionException("Direction invalide !");
		}
	}
	
	/**
	 * Modifie à une case voisine.
	 * 
	 * @param direction la direction ({@link Direction}) dans laquelle se trouve la case voisine par rapport à la case.
	 * @param laCase la nouvelle case.
	 * @throws CaseVoisineException si on tente de mettre la case voisine d'elle-même.
	 * @throws IncorrecteDirectionException si la direction est incorrecte.
	 */
	public void setVoisine(int direction, Case laCase) {
		if(laCase == this) {
			throw new CaseVoisineException("Une case ne peut être la voisine d'elle-même.");
		}
		if(direction < NB_MAX_VOISINES && direction >= 0) {
			voisines[direction] = laCase;
		} else {
			throw new IncorrecteDirectionException("Direction invalide !");
		}
	}
	
	/**
	 * Supprime une voisine.
	 * 
	 * @param direction la direction où se trouve la voisine à supprimer.
	 * @throws IncorrecteDirectionException si la direction est incorrecte.
	 */
	public void removeVoisine(int direction) {
		if(direction < NB_MAX_VOISINES && direction >= 0) {
			voisines[direction] = null;
		} else {
			throw new IncorrecteDirectionException("Direction invalide !");
		}
	}
}
