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
package apyrinthe;

/**
 * Base pour les vues de Labyrinthe.
 *
 * @param <L> le type de labyrinthe.
 */
public abstract class LabyrintheView <L extends Labyrinthe<?>> {
	protected L model;

	/**
	 * Crée une vue de labyrinthe.
	 * 
	 * @param model le labyrinthe à visualiser
	 */
	public LabyrintheView(L model) {
		this.model = model;
	}

	public L getModel() {
		return model;
	}

	public void setModel(L model) {
		assert model != null;
		this.model = model;
	}

	/**
	 * Met à jour la vue.
	 */
	public abstract void update();
}
