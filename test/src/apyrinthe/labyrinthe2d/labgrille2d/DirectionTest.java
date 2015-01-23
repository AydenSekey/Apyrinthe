package apyrinthe.labyrinthe2d.labgrille2d;

import static org.junit.Assert.*;

import org.junit.Test;

public class DirectionTest {

	@Test
	public void testOppose() {
		assertEquals("Opposé du Nord incorrect", Direction.SUD, Direction.oppose(Direction.NORD));
		assertEquals("Opposé du Sud incorrect", Direction.NORD, Direction.oppose(Direction.SUD));
		assertEquals("Opposé du Ouest incorrect", Direction.EST, Direction.oppose(Direction.OUEST));
		assertEquals("Opposé du Est incorrect", Direction.OUEST, Direction.oppose(Direction.EST));
	}

}
