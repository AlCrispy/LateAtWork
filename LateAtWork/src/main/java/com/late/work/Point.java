package com.late.work;

public class Point {
	
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean isLefter(Point p) {
		return this.getX() < p.getX() ? true : false; 
	}
	
	public boolean isRighter(Point p) {
		return this.getX() < p.getX() ? false : true; 
	}
	
	public boolean isEquals(Point p) {
		return (p.getX() == this.getX() && p.getY() == this.getY()) ? true : false; 	
	}
	
	public boolean isDeeper(Point p) {
		return this.getY() < p.getY() ? false : true; 	
	}
	
	public boolean isNearer(Point p) {
		return this.getY() < p.getY() ? true : false; 	
	}
}
