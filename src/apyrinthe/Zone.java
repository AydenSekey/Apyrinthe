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
	 * Test s'il y a une zone accessible depuis la zone.
	 * 
	 * @return <code>true</code> s'il existe une zone acessible, sinon <code>false</code>.
	 */
	public boolean hasZoneAccessible();

	/**
	 * Indique si la zone est une sortie.
	 * 
	 * @return <code>true</code> si c'est une sortie, sinon <code>false</code>.
	 */
	public boolean isSortie();
	
	/**
	 * Autorise ou refuse la visite d'un visiteur.
	 * 
	 * @param visiteur le visiteur souhaitant visité la zone.
	 * @return <code>true</code> si la zone accepte la visite, dans ce cas {@link VisiteurZone#visiter(Zone)} a été appelée, sinon <code>false</code>.
	 */
	public boolean accept(VisiteurZone visiteur);
}
