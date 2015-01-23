package apyrinthe.labyrinthe2d.labgrille2d;

/**
 * Direction possible pour un labyrinthe à deux dimensions sous forme d'une grille.
 */
public final class Direction {
	public static final int NORD = 0;
	public static final int EST = 1;
	public static final int SUD = 2;
	public static final int OUEST = 3;
	
	private Direction() {}
	
	public static int oppose(int direction) {
		return (direction + 2) % 4;
	}
}
