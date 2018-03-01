package com.late.work;

import java.util.ArrayList;
import java.util.List;

public class OhMyGodObstacle {
	
	private Point a;
	private Point b;
	private Point c;
	private Boolean imInTheMiddle = false;
	
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
		int minX; 
		int maxX;
		int maxY;
		int minY;
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

		List<Boolean> listPointInside = new ArrayList<>();
		listPointInside.add(checkPoint(this.getA().getX(), this.getA().getY(), minX, maxX, minY, maxY));
		listPointInside.add(checkPoint(this.getA().getX(), this.getA().getY(), minX, maxX, minY, maxY));
		listPointInside.add(checkPoint(this.getA().getX(), this.getA().getY(), minX, maxX, minY, maxY));
		
		boolean atLeast2Inside = checkAtList2InsideArea(listPointInside);
		
		
		
		return false;
	}

	private boolean checkAtList2InsideArea(List<Boolean> listed) {
		int counter = 0;
		for (Boolean isPointInside : listed) {
			if(isPointInside) {
				counter++;
			}
		}
		return counter >= 2 ? true : false;
	}

	private boolean checkPoint(int x, int y, int minX, int maxX, int minY, int maxY) {
		boolean isXContained = false;
		boolean isYContained = false;
		boolean isContained = false; 
		if(x < maxX && x > minX) {
			isXContained = true;
		}
		if(y < maxY && y > minY) {
			isYContained = true;
		}
		if(isXContained && isYContained) {
			isContained = true;
		}
		return isContained;
	}
}
