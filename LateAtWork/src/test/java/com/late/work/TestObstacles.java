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
	public void testObstacleAndLineNotIntersecting() {
		OhMyGodObstacle o1 = new OhMyGodObstacle(0, 0, 0, 10, 10, 0);
		Line l1 = new Line(-40,20,100,20);
		assertFalse(o1.intersect(l1));
	}

	@Test
	public void testFindNearestObstacle() {
		OhMyGodObstacle o1 = new OhMyGodObstacle(0, 0, 0, 10, 10, 0);
		OhMyGodObstacle o2 = new OhMyGodObstacle(20, 0, 20, 10, 30, 0);
		Point p1 = new Point(-5,-5);
		Point p2 = new Point(50,20);
		Line l1 = new Line(p1,p2);
		assertTrue(o1.intersect(l1));
		assertTrue(o2.intersect(l1));
		OhMyGodObstacle nearest = Utils.findNearestObstacle(p2,o1,o2);
		assertTrue(nearest.getA().getX()==20);
	}



}
