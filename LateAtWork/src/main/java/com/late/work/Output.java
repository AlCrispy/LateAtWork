package com.late.work;

public class Output {

	private Point[] path;
	
	public Output(Point[] path) {
		this.path = path;
	}
	
	public Output() {
		// TODO Auto-generated constructor stub
	}

	public Point[] getPath() {
		return this.path;
	}
	
	public int getPathSize() {
		return this.path.length;
	}

	public void setPath(Point[] path) {
		this.path = path;		
	}

}
