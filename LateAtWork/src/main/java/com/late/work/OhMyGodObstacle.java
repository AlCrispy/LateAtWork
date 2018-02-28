package com.late.work;

public class OhMyGodObstacle {
	
	private Point a;
	private Point b;
	private Point c;
	
	public OhMyGodObstacle(int ax, int ay, int bx, int by, int cx, int cy) {
		this.setA(ax, ay);
		this.setB(bx, by);
		this.setC(cx, cy);
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
	
	public boolean isMyObstaclesInsideRoute(Point p1, Point p2) {
		// TODO capire come identificare se un oggetto passa in messo alla retta ipotetica passante da p1 a p2
		
		//massimi e minimi, conoscendo questi valori so qual'è 
		//l'area che devo prendere in considerazione sul piano 2d
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

		boolean isAContained = checkPointA(minX, maxX, minY, maxY);
		boolean isBContained = checkPointB(minX, maxX, minY, maxY);
		boolean isCContained = checkPointC(minX, maxX, minY, maxY);
		
		return false;
	}

	private boolean checkPointA(int minX, int maxX, int minY, int maxY) {
		boolean isXContained = false;
		boolean isYContained = false;
		boolean isContained = false; 
		if(this.getA().getX() < maxX && this.getA().getX() > minX) {
			isXContained = true;
		}
		if(this.getA().getY() < maxY && this.getA().getY() > minY) {
			isYContained = true;
		}
		if(isXContained && isYContained) {
			isContained = true;
		}
		return isContained;
	}
	
	private boolean checkPointB(int minX, int maxX, int minY, int maxY) {
		boolean isXContained = false;
		boolean isYContained = false;
		boolean isContained = false; 
		if(this.getB().getX() < maxX && this.getB().getX() > minX) {
			isXContained = true;
		}
		if(this.getB().getY() < maxY && this.getB().getY() > minY) {
			isYContained = true;
		}
		if(isXContained && isYContained) {
			isContained = true;
		}
		return isContained;
	}
	
	private boolean checkPointC(int minX, int maxX, int minY, int maxY) {
		boolean isXContained = false;
		boolean isYContained = false;
		boolean isContained = false; 
		if(this.getC().getX() < maxX && this.getC().getX() > minX) {
			isXContained = true;
		}
		if(this.getC().getY() < maxY && this.getC().getY() > minY) {
			isYContained = true;
		}
		if(isXContained && isYContained) {
			isContained = true;
		}
		return isContained;
	}
	
}
