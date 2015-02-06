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
