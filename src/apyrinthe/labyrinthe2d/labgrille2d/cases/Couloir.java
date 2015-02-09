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

/**
 * Case sans particularité, sur laquelle on peut se déplacer.
 */
public class Couloir extends Case {
	private boolean isEnd;
	
	/**
	 * Crée un couloir.
	 */
	public Couloir() {
		this(false);
	}
	
	/**
	 * Crée un couloir.
	 * 
	 * @param end <code>true</code> pour indiquer que c'est une sortie.
	 */
	public Couloir(boolean end) {
		super();
		isEnd = end;
	}
	
	@Override
	public boolean isSortie() {
		return isEnd;
	}
	
	/**
	 * Modifie l'indicateur de fin.
	 * 
	 * @param end <code>true</code> pour indquer que le couloir correspond à une zone de fin du labyrinthe.
	 */
	public void setEnd(boolean end) {
		isEnd = end;
	}

	@Override
	public boolean accept(VisiteurCase visiteur) {
		visiteur.visiter(this);
		return true;
	}
}
