package com.zhongzheng.homeWork.abstract1;

import java.time.LocalDateTime;

public abstract class GeometricObject {
	private String color;
	private boolean filled;
	private LocalDateTime dateCreated;
	
	public GeometricObject() {
		super();
		dateCreated = LocalDateTime.now();
		// TODO Auto-generated constructor stub
	}

	public GeometricObject(String color, boolean filled) {
		super();
		this.dateCreated = LocalDateTime.now();
		this.color = color;
		this.filled = filled;
		this.dateCreated = dateCreated;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	@Override
	public String toString() {
		return "GeometricObject [color=" + color + ", filled=" + filled + ", dateCreated=" + dateCreated + "]";
	}
	
	public abstract double getArea();
	public abstract double getPerimeter();
	
	
	
	

}
