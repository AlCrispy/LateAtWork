package com.late.work;

import java.util.ArrayList;
import java.util.List;

public class Input {

	private List<OhMyGodObstacle> obstacles = new ArrayList<OhMyGodObstacle>();
	private Point inStartingPoint;
	private Point inFinishingPoint;
	
	public Input(Point inStartingPoint, Point inFinishingPoint) {
		this.inStartingPoint = inStartingPoint;
		this.inFinishingPoint = inFinishingPoint;
	}

	public void addObstacle(OhMyGodObstacle obstacle) {
		this.obstacles.add(obstacle);
	}

	public Point getInStartingPoint() {
		return inStartingPoint;
	}

	public Point getInFinishingPoint() {
		return inFinishingPoint;
	}
	
	public List<OhMyGodObstacle> getObstacles(){
		return this.obstacles;
	}
	

	public int getNumberOfObstacles(){
		return this.obstacles.size();
	}


}
