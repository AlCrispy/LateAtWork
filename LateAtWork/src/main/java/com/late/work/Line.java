package com.late.work;

public class Line {

	private Point p1;
	private Point p2;

	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public Point getP1() {
		return p1;
	}

	public Point getP2() {
		return p2;
	}	

	public boolean intersect(Line line2) {
		Point l2_p1 = line2.getP1();
		Point l2_p2 = line2.getP2();
		// to do
		return false;
	}

}
