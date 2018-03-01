package com.late.work;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestLines {

	@Test
	public void testLinesIntersecting() {
		Line l1 = new Line(1,1,4,4);
		Line l2 = new Line(4,4,1,1);
		assertTrue(l1.intersect(l2));

		l1 = new Line(1,1,4,4);
		l2 = new Line(0,0,3,3);
		assertTrue(l1.intersect(l2));
		
		l1 = new Line(-100,20,50,-20);
		l2 = new Line(-50,-10,60,60);
		assertTrue(l1.intersect(l2));
		
	}

	@Test
	public void testLinesNotIntersecting() {
		Line l1 = new Line(8,8,5,5);
		Line l2 = new Line(4,4,1,1);
		assertFalse(l1.intersect(l2));

		l1 = new Line(1,1,4,4);
		l2 = new Line(1,0,4,3);
		assertFalse(l1.intersect(l2));

		l1 = new Line(-100,20,50,-5);
		l2 = new Line(-50,-10,1,1);
		assertFalse(l1.intersect(l2));
	}

}
