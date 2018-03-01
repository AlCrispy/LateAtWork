package com.late.work;

public class Utils {

	public static OhMyGodObstacle findNearestObstacle(Point p2, OhMyGodObstacle ... obs) {
		OhMyGodObstacle nearest = null;
		double shortest = Integer.MAX_VALUE;
		for(OhMyGodObstacle o: obs) {
			for(Point p: o.getVertexs()) {
				double dist = new Line(p,p2).distance();
				if(dist<shortest) {
					nearest = o;
					shortest=dist;
				}
			}
		}
		return nearest;
	}
}
