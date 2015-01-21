package apyrinthe;

import java.util.Set;

/**
 * Interface de base d'un Labyrinthe. Un Labyrinthe est composé de {@link Zone}.
 */
public interface Labyrinthe<Z extends Zone> {
	
	/**
	 * Donne l'ensemble des zones du labyrinthe.
	 * 
	 * @return les zones du labyrinthe.
	 */
	public Set<Z> getZones();
	
	/**
	 * Donne l'ensemble des zones d'accès au labyrinthe. <br />
	 * C'est un sous-ensemble de l'ensemble retourné par {@link #getZones()}.
	 * 
	 * @return les zones d'accès au labyrinthe.
	 */
	public Set<Z> getAcces();
}
