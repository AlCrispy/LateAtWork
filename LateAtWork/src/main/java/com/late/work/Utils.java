package com.late.work;

import java.util.ArrayList;
import java.util.List;

public class Utils {

	/**
	 * Find which obstacle is the nearest.
	 * @param p
	 * @param obs
	 * @return
	 */
	public static OhMyGodObstacle findNearestObstacle(Point point, OhMyGodObstacle ... obs) {
		OhMyGodObstacle nearest = null;
		double shortest = Integer.MAX_VALUE;
		for(OhMyGodObstacle o: obs) {
			for(Point p: o.getVertexs()) {
				double dist = new Line(point,p).distance();
				if(dist<shortest) {
					nearest = o;
					shortest=dist;
				}
			}
		}
		return nearest;
	}

	/**
	 * Find which vertexs of the obstacle are visible from the point.
	 * Doesn't consider any other obstacle
	 * @param p
	 * @param o1
	 * @return
	 */
	public static Point[] findVisiblePoints(Point p, OhMyGodObstacle o) {
		List<Point> visibles = new ArrayList<Point>();
		Point[] vertexs = o.getVertexs();
		for(Point v: vertexs) {
			if(!o.intersect(new Line(p,v))) {
				visibles.add(v);
			}
		}
		return visibles.toArray(new Point[visibles.size()]);
	}
}
