package com.mykhailo.kolpakov.structural;

public class Decorator {
	public static void main(String[] args) {
		PrinterIF decorator = new QuotesDecorator(new RightBracketDecorator(new LeftBracketDecorator(new Printer("Hi"))));
		decorator.print();
	}
}

interface PrinterIF {
	void print();
}

abstract class Decor implements PrinterIF {
	PrinterIF component;

	public Decor(PrinterIF component) {
		this.component = component;
	}
	
	public void print() {
		component.print();
	}

}

class Printer implements PrinterIF {
	String value;

	public Printer(String value) {
		this.value = value;
	}

	@Override
	public void print() {
		System.out.print(value);
	}
}

class QuotesDecorator extends Decor {
	public QuotesDecorator(PrinterIF component) {
		super(component);
	}

	@Override
	public void print() {
		System.out.print("\"");
		super.print();
		System.out.println("\"");
	}

}

class LeftBracketDecorator extends Decor {
	public LeftBracketDecorator(PrinterIF component) {
		super(component);
	}

	@Override
	public void print() {
		System.out.print("[");
		super.print();
	}
}

class RightBracketDecorator extends Decor {
	public RightBracketDecorator(PrinterIF component) {
		super(component);
	}

	@Override
	public void print() {
		super.print();
		System.out.print("]");
	}
}