package com.late.work;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestObstacles {

	@Test
	public void testObstacleAndLineIntersecting() {
		OhMyGodObstacle o1 = new OhMyGodObstacle(0, 0, 0, 10, 10, 0);
		Line l1 = new Line(-5,-5,30,30);
		assertTrue(o1.intersect(l1));
	}
	

	@Test
	public void testObstacleAndLineNotrsecting() {
		OhMyGodObstacle o1 = new OhMyGodObstacle(0, 0, 0, 10, 10, 0);
		Line l1 = new Line(-40,20,100,20);
		assertFalse(o1.intersect(l1));
	}
	

}
