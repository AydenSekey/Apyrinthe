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

import java.io.IOException;
import java.io.OutputStream;

import apyrinthe.Zone;
import apyrinthe.labyrinthe2d.labgrille2d.LabGrille2D;
import apyrinthe.labyrinthe2d.labgrille2d.cases.Case;
import apyrinthe.labyrinthe2d.labgrille2d.cases.Couloir;
import apyrinthe.labyrinthe2d.labgrille2d.cases.Mur;
import apyrinthe.labyrinthe2d.labgrille2d.cases.VisiteurCase;
import apyrinthe.labyrinthe2d.labgrille2d.view.LabGrille2DView;

/**
 * Vue ASCII d'un labyrinthe 2D représenté par une grille
 */
public class LabGrille2DAsciiView extends LabGrille2DView {
	private final StringBuilder affichage;
	private AsciiCaseStrategy asciiStrategie;
	
	/**
	 * Crée une vue du labyrinthe sous format de texte ASCII.
	 * 
	 * @param labyrinthe le modèle du labyrinthe à visualiser.
	 */
	public LabGrille2DAsciiView(LabGrille2D labyrinthe) {
		super(labyrinthe);
		int capacityMini = labyrinthe.getNbColonnes() * labyrinthe.getNbLignes();
		affichage = new StringBuilder(capacityMini);
		asciiStrategie = new ApyrintheAsciiCaseStrategy();
	}
	
	@Override
	public void update() {
		final int nbCol = labGrille2d.getNbColonnes();
		final int nbLi = labGrille2d.getNbLignes();
		affichage.delete(0, affichage.length());
		for(int li = nbLi - 1; li >= 0; li--) {
			for(int col = 0; col < nbCol; col++) {
				Case c = labGrille2d.getCase(col, li);
				if(c != null) {
					affichage.append(asciiStrategie.asciiCase(c));
				} else {
					affichage.append('?');
				}
			}
			affichage.append('\n');
		}
	}
	
	/**
	 * Donne la stratégie de représentation ascii des case.
	 * 
	 * @return la stratégie.
	 */
	public AsciiCaseStrategy getAsciiStrategy() {
		return asciiStrategie;
	}
	
	/**
	 * Modifie la stratégie de représentation ASCII des cases.
	 * 
	 * @param strategy la nouvelle stratégie.
	 */
	public void setAsciiStrategy(AsciiCaseStrategy strategy) {
		asciiStrategie = strategy;
	}

	/**
	 * Donne le texte ASCII de la vue.
	 * 
	 * @return le texte ASCII correspondant au modèle du labyrinthe.
	 */
	public String getAscii() {
		update();
		return affichage.toString();
	}
	
	/**
	 * Ecrit le texte ASCII de la vue dans un flux.
	 * 
	 * @param out le flux dans lequel écrire la sortie.
	 * @throws IOException en cas d'erreur d'écriture dans le flux.
	 */
	public void print(OutputStream out) throws IOException {
		update();
		out.write(affichage.toString().getBytes());
	}
}
