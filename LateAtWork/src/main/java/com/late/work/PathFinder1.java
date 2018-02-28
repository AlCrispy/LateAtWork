package com.late.work;

public class PathFinder1 implements PathFinder {

	public Output compute(Input input) {
		Output out = new Output();

		Point[] path = new Point[] {
			new Point(23,0),
			new Point(14,0),
			new Point(0,12)
		};
		out.setPath(path);
		return out;
	}

	
}
