package main.java;

public class OhMyGodObstacles {
	
	private Point a;
	private Point b;
	private Point c;
	
	public OhMyGodObstacles(int ax, int ay, int bx, int by, int cx, int cy) {
		
	}

	public Point getA() {
		return a;
	}

	public void setA(int x, int y) {
		Point point = new Point();
		point.setX(x);
		point.setY(y);
		this.a = point;
	}

	public Point getB() {
		return b;
	}

	public void setB(int x, int y) {
		Point point = new Point();
		point.setX(x);
		point.setY(y);
		this.b = point;
		
	}

	public Point getC() {
		return c;
	}

	public void setC(int x, int y) {
		Point point = new Point();
		point.setX(x);
		point.setY(y);
		this.c = point;
	}
	
	public boolean isMyPointInsideRouteArea(Point p1, Point p2) {
		int minX, maxX, maxY, minY;
		if(p1.getX() < p2.getX()) {
			maxX = p2.getX();
			minX = p1.getX();
		} else {
			maxX = p1.getX();
			minX = p2.getX();
		}
		
		if(p1.getY() < p2.getY()) {
			maxY = p2.getY();
			minY = p1.getY();
		} else {
			maxY = p1.getY();
			minY = p2.getY();
		}
		return true;
	}
}
