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
package apyrinthe.labyrinthe2d.labgrille2d.view;

import apyrinthe.LabyrintheView;
import apyrinthe.labyrinthe2d.labgrille2d.LabGrille2D;

/**
 * Base commune aux vues de {@link LabGrille2D}.
 */
public abstract class LabGrille2DView extends LabyrintheView<LabGrille2D>{
	
	/**
	 * Crée une vue de {@link LabGrille2D}
	 * 
	 * @param labGrille2d le modèle associé à la vue.
	 */
	public LabGrille2DView(LabGrille2D labGrille2d) {
		super(labGrille2d);
	}

}
