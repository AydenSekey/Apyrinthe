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
package apyrinthe.labyrinthe2d.labgrille2d;

import java.util.HashSet;
import java.util.Set;

import apyrinthe.Labyrinthe;
import apyrinthe.labyrinthe2d.labgrille2d.cases.Case;
import apyrinthe.labyrinthe2d.labgrille2d.exception.ConstructionLabGrille2DException;
import apyrinthe.labyrinthe2d.labgrille2d.exception.InvalideCoordonneeGrilleException;

/**
 * Labyrinthe à deux dimensions représenté par une grille.
 * La coordonnée (0;0) au coin sud-ouest.
 */
public class LabGrille2D implements Labyrinthe<Case> {
	private final Set<Case> acces;
	private final int nbLignes;
	private final int nbColonnes;
	private final Case[] grille;

	/**
	 * Crée un labyrinthe.
	 * @param col le nombre de colonnes de la grille représentant le labyrinthe.
	 * @param li le nombre de lignes de la grille représentant le labyrinthe.
	 * @throws ConstructionLabGrille2DException si les paramètres de construction sont incorrects.
	 */
	public LabGrille2D(int col, int li) {
		if(col <= 0 || li <= 0)
			throw new ConstructionLabGrille2DException(col, li);
		acces = new HashSet<Case>();
		nbColonnes = col;
		nbLignes = li;
		grille = new Case[nbColonnes * nbLignes];
	}
	
	@Override
	public Set<Case> getZones() {
		Set<Case> zones = new HashSet<Case>();
		final int nbZones = grille.length;
		for(int i = 0; i < nbZones; i++) {
			if(grille[i] != null) {
				zones.add(grille[i]);
			}
		}
		return zones;
	}

	@Override
	public Set<Case> getAcces() {
		return acces;
	}

	/**
	 * Accède à une case.
	 * @param col la colonne de la case.
	 * @param li la ligne de la case.
	 * @return la case ou <code>null</code> s'il n'y en a pas à cette position.
	 */
	public Case getCase(int col, int li) {
		if(valideCoordonnee(col, li)) {
			int pos = calculPosition(col, li);
			return grille[pos];
		} else {
			throw new InvalideCoordonneeGrilleException(col, li);
		}
	}
	
	public void setCase(int col, int li, Case laCase) {
		if(valideCoordonnee(col, li)) {
			int pos = calculPosition(col, li);
			grille[pos] = laCase;
		} else {
			throw new InvalideCoordonneeGrilleException(col, li);
		}
	}
	
	/**
	 * Calcul la position de la case dans le tableau représentant la grille.
	 * @param col la colonne.
	 * @param li la ligne.
	 * @return la position.
	 */
	private int calculPosition(int col, int li) {
		return nbColonnes * li + col;
	}
	
	private boolean valideCoordonnee(int col, int li) {
		return col >= 0 && li >= 0 && col < nbColonnes && li < nbLignes;
	}
	
	/**
	 * Met à jour les liens d'accès d'une case avec ses voisines.
	 * 
	 * @param col la colonne de la case pour laquelle mettre à jour les voisines.
	 * @param li la ligne de la case pour laquelle mettre à jour les voisines.
	 */
	public void updateVoisines(int col, int li) {
		if(!valideCoordonnee(col, li)) {
			throw new InvalideCoordonneeGrilleException(col, li);
		}
		final Case laCase = getCase(col, li);
		if(li + 1 < nbLignes) {
			final Case caseNord = getCase(col, li + 1);
			if(caseNord != null) {
				if(laCase != null)
					laCase.setVoisine(Direction.NORD, caseNord);
				caseNord.setVoisine(Direction.SUD, laCase);
			}
		}
		if(li - 1 > 0) {
			final Case caseSud = getCase(col, li - 1);
			if(caseSud != null) {
				if(laCase != null)
					laCase.setVoisine(Direction.SUD, caseSud);
				caseSud.setVoisine(Direction.NORD, laCase);
			}
		}
		if(col + 1 < nbColonnes) {
			final Case caseEst = getCase(col + 1, li);
			if(caseEst != null) {
				if(laCase != null)
					laCase.setVoisine(Direction.EST, caseEst);
				caseEst.setVoisine(Direction.OUEST, laCase);
			}
		}
		if(col - 1 > 0) {
			final Case caseOuest = getCase(col - 1, li);
			if(caseOuest != null) {
				if(laCase != null)
					laCase.setVoisine(Direction.OUEST, caseOuest);
				caseOuest.setVoisine(Direction.EST, laCase);
			}
		}
	}
	
	public void updateVoisines() {
		for(int col = 0; col < nbColonnes; col++) {
			for(int li = 0 ; li < nbLignes; li++) {
				updateVoisines(col, li);
			}
		}
	}

	/**
	 * Donne le nombre de lignes de la grille du labyrinthe.
	 * 
	 * @return le nombre de lignes.
	 */
	public int getNbLignes() {
		return nbLignes;
	}

	/**
	 * Donne le nombre de colonnes de la grille du labyrinthe.
	 * 
	 * @return le nombre de colonnes.
	 */
	public int getNbColonnes() {
		return nbColonnes;
	}
}
