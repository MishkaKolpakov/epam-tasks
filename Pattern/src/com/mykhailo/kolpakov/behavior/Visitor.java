package com.mykhailo.kolpakov.behavior;

public class Visitor {
	public static void main(String[] args) {
	/*	Element bodyElement = new BodyElement();
		Element engineElement = new EngineElement();
		IVisitor hooligan = new HooliganVisitor();
		bodyElement.accept(hooligan);
		engineElement.accept(hooligan);*/
		
		Element carElement = new CarElement();
		IVisitor hooliganVisitor = new HooliganVisitor();
		IVisitor mechanicVisitor = new MechanicVisitor();
		
		carElement.accept(hooliganVisitor);
		
		carElement.accept(mechanicVisitor);
		
		
	}
}

interface IVisitor {
	void visit(EngineElement element);

	void visit(BodyElement body);

	void visit(CarElement car);

	void visit(WheelElement wheel);
}

interface Element {
	void accept(IVisitor visitor);
}

class BodyElement implements Element {
	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
}

class EngineElement implements Element {
	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
}

class HooliganVisitor implements IVisitor {
	@Override
	public void visit(EngineElement element) {
		System.out.println("Broken detail");
	}

	@Override
	public void visit(BodyElement body) {
		System.out.println("Kicked the body");
	}

	@Override
	public void visit(CarElement car) {
		System.out.println("Broken car");

	}

	@Override
	public void visit(WheelElement wheel) {
		System.out.println("Broken wheel");
	}
}

class MechanicVisitor implements IVisitor {

	@Override
	public void visit(EngineElement element) {
		System.out.println("Repaired the detail");
	}

	@Override
	public void visit(BodyElement body) {
		System.out.println("Repaired body");
	}

	@Override
	public void visit(CarElement car) {
		System.out.println("Repaired car");
	}

	@Override
	public void visit(WheelElement wheel) {
		System.out.println("Repaired car");

	}
}

class WheelElement implements Element {

	String name;

	public WheelElement(String wheel) {
		name = wheel;
	}

	public String getName() {
		return name;
	}

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
}

class CarElement implements Element {
	Element[] elements;

	public CarElement() {
		this.elements = new Element[] { new WheelElement("4 wheels"), new EngineElement(), new BodyElement() };
	}

	@Override
	public void accept(IVisitor visitor) {
		for (Element e : elements) {
			e.accept(visitor);
		}
		visitor.visit(this);
	}

}