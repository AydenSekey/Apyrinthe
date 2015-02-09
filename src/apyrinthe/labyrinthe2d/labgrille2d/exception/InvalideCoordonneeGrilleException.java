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
 * Exception de coordonnée (ligne, colonne) invalide.
 */
public class InvalideCoordonneeGrilleException extends RuntimeException {
	
	/**
	 * Crée une exception de direction incorrecte.
	 * 
	 * @param message le message de l'exception.
	 */
	public InvalideCoordonneeGrilleException(String message) {
		super(message);
	}

	/**
	 * Crée une exception de direction incorrecte, avec un message par défaut en fonction des coordonnées.
	 * 
	 * @param col le numéro de colonne de la coordonnée invaide
	 * @param li le numéro de ligne de la coordonnée invalide
	 */
	public InvalideCoordonneeGrilleException(int col, int li) {
		super("Coordonnées invalides : ligne=" + li + "; colonne=" + col);
	}
}
