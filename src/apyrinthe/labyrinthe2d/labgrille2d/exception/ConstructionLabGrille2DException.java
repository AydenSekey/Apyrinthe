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
package apyrinthe.labyrinthe2d.labgrille2d.exception;

/**
 * Exception provenant d'une erreur de construction d'un labyrinthe 2D sous forme de grille.
 */
public class ConstructionLabGrille2DException extends RuntimeException {
	
	/**
	 * Crée une exception de construction de LabGrille2D.
	 * 
	 * @param message le message d'erreur.
	 */
	public ConstructionLabGrille2DException(String message) {
		super(message);
	}
	
	/**
	 * Crée une exception de construction de LabGrille2D avec le message par défaut en fonction des paramètres de construction.
	 * 
	 * @param nbColParam le nombre de colonnes demandées à la construction.
	 * @param nbLiParam le nombre de lignes demandées à la construction.
	 */
	public ConstructionLabGrille2DException(final int nbColParam, final int nbLiParam) {
		this("Paramètre de construction incorrects : col=" + nbColParam + ", li=" + nbLiParam);
	}
}
