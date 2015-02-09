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
