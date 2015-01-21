package apyrinthe;

/**
 * Interface pour visiter les zones.
 * 
 * @param <Z> le type de zone.
 */
public interface VisiteurZone {
	
	/**
	 * Visite une zone.
	 * 
	 * @param zone la zone à visiter.
	 */
	public void visiter(Zone zone);
}
