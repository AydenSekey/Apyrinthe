/*
Copyright Adrien Duroy (2015)
 
ad.duroy@gmail.com

This file is part of Apyrinthe.
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
package apyrinthe.labyrinthe2d.labgrille2d.view.ascii;

import apyrinthe.labyrinthe2d.labgrille2d.cases.Case;

/**
 *	Stratégie de représentation d'une case par un caractère ASCII.
 */
public interface AsciiCaseStrategy {
	/**
	 * Donne le caractère ASCII pour représenter une case.
	 * 
	 * @param c la case à représenter.
	 * @return le caractère asccii pour représenter la case.
	 */
	public char asciiCase(Case c);
}
