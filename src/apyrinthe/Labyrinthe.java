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
	 * Donne l'ensemble des zones d'accès au labyrinthe. <br>
	 * C'est un sous-ensemble de l'ensemble retourné par {@link #getZones()}.
	 * 
	 * @return les zones d'accès au labyrinthe.
	 */
	public Set<Z> getAcces();
	
	/**
	 * Ajoute une zone en tant qu'accès au labyrinthe.<br>
	 * La zone doit être une zone du labyrinthe.
	 * 
	 * @param zone la zone à enregistrée en tant qu'accès.
	 */
	public void addAcces(Z zone);
	
	/**
	 * Supprime un accès au labyrinthe.
	 * 
	 * @param zone l'accès à supprimer.
	 */
	public void removeAcces(Z zone);
	
	/**
	 * Vérifie si une zone est une zone d'accès au labyrinthe.
	 * 
	 * @param zone la zone pour laquelle faire la vérification.
	 * @return <code>true</code> si c'est une zone d'accès, sinon <code>false</code>.
	 */
	public boolean isAcces(Z zone);
}
