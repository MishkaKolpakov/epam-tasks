package com.mykhailo.kolpakov.structural;

import java.util.ArrayList;
import java.util.List;

public class Composite {
	
	public static void main(String[] args) {
		Shape square1 = new Square();
		Shape square2 = new Square();
		
		Shape circle1 = new Circle();
		Shape circle2 = new Circle();
		
		Shape triangle1 = new Triangle();
		Shape triangle2 = new Triangle();
		Shape triangle3 = new Triangle();
		
		Composit composite1 = new Composit();
		Composit composite2 = new Composit();
		Composit composite3 = new Composit();
		
		composite1.addElement(square1);
		composite1.addElement(square2);
		composite1.addElement(triangle1);
		
		composite2.addElement(square2);
		composite2.addElement(circle2);
		composite2.addElement(circle1);
		
		composite3.addElement(triangle2);
		composite3.addElement(triangle3);
		composite3.addElement(composite1);
		composite3.addElement(composite2);
		composite3.draw();
	
	}
	
}

interface Shape {
	void draw();
}

class Square implements Shape {
	@Override
	public void draw() {
		System.out.println("Square drawn");
	}
}

class Triangle implements Shape {
	@Override
	public void draw() {
		System.out.println("Triangle drawn");
	}
}

class Circle implements Shape {
	@Override
	public void draw() {
		System.out.println("Circle drawn");
	}
}

class Composit implements Shape {

	private List<Shape> elements = new ArrayList<>();
	
	public void addElement(Shape element) {
		elements.add(element);
	}
	
	public void removeElement(Shape element) {
		elements.remove(element);
	}
	
	@Override
	public void draw() {
		for(Shape element : elements) {
			element.draw();
		}
	}
}
