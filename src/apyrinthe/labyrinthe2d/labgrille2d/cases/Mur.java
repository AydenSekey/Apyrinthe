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

import apyrinthe.VisiteurZone;

/**
 * Case representant un mur. On ne peut pas s'y déplacer. N'accepte que les visiteurs de cases. 
 */
public class Mur extends Case {

	/**
	 * Un mur n'est jamais une zone de sortie.
	 * 
	 * @return <code>false</code>
	 */
	@Override
	public boolean isSortie() {
		return false;
	}

	@Override
	public boolean accept(VisiteurCase visiteur) {
		visiteur.visiter(this);
		return true;
	}

	/**
	 * Refuse la visite aux visiteurs qui ne sont pas des {@link VisiteurCase}.
	 */
	@Override
	public boolean accept(VisiteurZone visiteur) {
		if(visiteur instanceof VisiteurCase) {
			return accept((VisiteurCase) visiteur);
		}
		return false;
	}
}
