package com.mykhailo.kolpakov.structural;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Flyweight {
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		List<Shapee> shapes = new ArrayList<>();

		shapes.add(shapeFactory.getShapee("circle"));
		shapes.add(shapeFactory.getShapee("square"));
		shapes.add(shapeFactory.getShapee("point"));
		shapes.add(shapeFactory.getShapee("circle"));
		shapes.add(shapeFactory.getShapee("point"));
		shapes.add(shapeFactory.getShapee("point"));

		Random random = new Random();
		for (Shapee shapee : shapes) {
			int x = random.nextInt(100);
			int y = random.nextInt(100);
			shapee.draw(x, y);
		}
	}
}

// Flyweight
interface Shapee {
	void draw(int x, int y);
}

class Point implements Shapee {

	@Override
	public void draw(int x, int y) {
		System.out.println("(" + x + "," + y + "): drawing point");
	}
}

class Circlee implements Shapee {
	int radius = 5;

	@Override
	public void draw(int x, int y) {
		System.out.println("(" + x + "," + y + "): drawing circle with radius " + radius);
	}
}

class Squaree implements Shapee {
	int square = 10;

	@Override
	public void draw(int x, int y) {
		System.out.println("(" + x + "," + y + "): drawing square with square " + square);
	}
}

class ShapeFactory {
	private static final Map<String, Shapee> shapes = new HashMap<>();

	public Shapee getShapee(String shapeName) {
		Shapee shape = shapes.get(shapeName);
		if (shape == null) {
			switch (shapeName) {
			case "circle":
				shape = new Circlee();
				break;
			case "square":
				shape = new Squaree();
				break;
			case "point":
				shape = new Point();
				break;
			}
			shapes.put(shapeName, shape);
		}
		return shape;
	}
}