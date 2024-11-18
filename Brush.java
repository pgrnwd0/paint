package com.paint;

import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Brush {
	
	private int size;
	private Color color;
	private String shape;
	
	public Brush() {
		size = 5;
		color = Color.BLACK;
		shape = "circle";
	}
	
	public String getShape() {
		return shape;
	}
	
	public void changeShape(String newShape) {
		shape = newShape;
	}
	
	public void setColor(Color newColor) {
		color = newColor;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setSize(int newSize) {
		size = newSize;
	}
	
	public int getSize() {
		return size;
	}
}
