package apyrinthe;

import java.util.Set;

/**
 * Element constituant un labyrinthe.
 */
public interface Zone {
	
	/**
	 * Donne l'ensemble des zones potentiellement accessibles depuis la zone. <br />
	 * Potentiellement signifit que la zone peut être innacessible selon des règles qui lui sont propres. <br />
	 * Par exemple une zone avec une porte bloquant l'accès quand elle est fermée mais autorisant l'acces quand elle est ouverte. <br />
	 * <br />
	 * Ces zones sont acessibles dans le sens où l'on peut intéragir avec elles.
	 * 
	 * @return l'ensemble des zones accessibles depuis la zone.
	 */
	public Set<Zone> getZonesAccessibles();
	
	/**
	 * Ajoute une zone accessible depuis la zone (voir {@link #getZonesAccessibles()} pour plus d'informations).
	 * 
	 * @param zone la nouvelle zone accessible depuis la zone.
	 */
	public void addZoneAccessible(Zone zone);
	
	/**
	 * Supprime une zone accessible de la zone.
	 * 
	 * @param zone la zone à retirer.
	 */
	public void removeZoneAccessible(Zone zone);
	
	/**
	 * Supprime toutes les zones accessibles de la zone.
	 */
	public void clearZonesAccessible();
	
	/**
	 * Indique si la zone est une zone de fin.
	 * 
	 * @return <code>true</code> si c'est une zone de fin, sinon <code>false</code>.
	 */
	public boolean isEnd();
	
	/**
	 * Autorise ou refuse la visite d'un visiteur.
	 * 
	 * @param visiteur le visiteur souhaitant visité la zone.
	 * @return <code>true</code> si la zone accepte la visite, dans ce cas {@link VisiteurZone#visiter(Zone)} a été appelée, sinon <code>false</code>.
	 */
	public boolean accept(VisiteurZone visiteur);
}
