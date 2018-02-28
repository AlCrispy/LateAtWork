package com.late.work;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCase1 {

	@Test
	public void testPathFinder1() {
		Input input = buildInput();	
		PathFinder pathfinder = new PathFinder1();
		Output output = pathfinder.compute(input);
		
		assertEquals(3,output.getPathSize());		
		
		// assert ancora da fare sui points		
		/** SOLUZIONE
		Point[] path = new Point[] {
			new Point(23,0),
			new Point(14,0),
			new Point(0,12)
		};
		int outNumberOfPoints = 3;
		**/
	}

	@Test
	public void testPathFinder2() {
		Input input = buildInput();	
		PathFinder pathfinder = new PathFinder2();
		Output output = pathfinder.compute(input);
		
		assertEquals(3,output.getPathSize());		
		
		// assert ancora da fare sui points		
		/** SOLUZIONE
		Point[] path = new Point[] {
			new Point(23,0),
			new Point(14,0),
			new Point(0,12)
		};
		int outNumberOfPoints = 3;
		**/
	}
	
	
	private Input buildInput() {
		Point inStartingPoint = new Point(23,0);
		Point inFinishingPoint = new Point(0,12); 
		// int inNumberOfObstacles = 2;
		OhMyGodObstacle inFirstObstacle = new OhMyGodObstacle(14, 1 ,14 ,50, 16, 1);
		OhMyGodObstacle inSecondObstacle = new OhMyGodObstacle( 0, 14, 20, 14, 0 ,13);
		
		Input input = new Input(inStartingPoint,inFinishingPoint);
		input.addObstacle(inFirstObstacle);
		input.addObstacle(inSecondObstacle);
		return input;
	}

}
