package com.late.work;

import java.awt.geom.Line2D;

public class Line {

	private Point p1;
	private Point p2;

	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public Line(int x1, int y1, int x2, int y2) {
		this(new Point(x1, y1),new Point(x2, y2));
	}

	public Point getP1() {
		return p1;
	}

	public Point getP2() {
		return p2;
	}

	public boolean isVertical() {
		return p1.getX() == p2.getX();
	}

	public boolean isHorizontal() {
		return p1.getY() == p2.getY();
	}
	
	public boolean intersect(Line line2) {
		int x1a = p1.getX();
		int y1a = p1.getY();
		int x2a = p2.getX();
		int y2a = p2.getY();
		int x1b = line2.getP1().getX();
		int y1b = line2.getP1().getY();
		int x2b = line2.getP2().getX();
		int y2b = line2.getP2().getY();
		return Line2D.linesIntersect(x1a, y1a, x2a, y2a, x1b, y1b, x2b, y2b);
	}
	
	/**
	 * Check if num is between n1 and n2 (no matter which is the greater)
	 * @param num
	 * @param n1
	 * @param n2
	 * @return
	 */
	private boolean between(int num, int n1, int n2) {
		int nA = (n1 < n2) ? n1 : n2;
		int nB = (n1 < n2) ? n2 : n1;
		return (num > nA && num < nB);
	}

	public double distance() {
		return Math.hypot(p1.getX()-p2.getX(), p1.getY()-p2.getY());
		// return Math.sqrt(Math.pow((p1.getX()-p2.getX()), 2) + Math.pow((p1.getY()-p2.getY()), 2));
	}

}
