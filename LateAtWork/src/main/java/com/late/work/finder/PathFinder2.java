package com.late.work.finder;

import com.late.work.Input;
import com.late.work.Output;
import com.late.work.Point;

public class PathFinder2 implements PathFinder {

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
