package com.mykhailo.kolpakov.creational;

public class AbstractFactory {
	public static void main(String[] args) {
		DeviceFactory deviceFactory = getFabricByName("RU");
		deviceFactory.getKeyboard().print();
		deviceFactory.getMouse().click();
		deviceFactory.geTouchpad().track(2, 3);
	}

	public static DeviceFactory getFabricByName(String language) {
		if (language.equals("EN"))
			return new EnDeviceFactory();
		else if (language.equals("RU"))
			return new RuDeviceFactory();

		throw new RuntimeException("No such a lanuage");
	}
}

interface Mouse {
	void click();

	void doubleClick();

	void scroll();
}

interface Keyboard {
	void print();

	void println();
}

interface Touchpad {
	void track(int deltaX, int deltaY);
}

interface DeviceFactory {
	Mouse getMouse();

	Keyboard getKeyboard();

	Touchpad geTouchpad();
}

class RuMouse implements Mouse {

	@Override
	public void click() {
		System.out.println("Клик мышью");// TODO Auto-generated method stub

	}

	@Override
	public void doubleClick() {
		System.out.println("Двойной клик мышью");// TODO Auto-generated method stub

	}

	@Override
	public void scroll() {
		System.out.println("Колесеко мышки");// TODO Auto-generated method stub

	}

}

class RuKeyboard implements Keyboard {

	@Override
	public void print() {
		System.out.println("Печать строки!");// TODO Auto-generated method stub

	}

	@Override
	public void println() {
		System.out.println("Печать строки с переводом строки!");// TODO Auto-generated method stub

	}

}

class RuTouchpad implements Touchpad {

	@Override
	public void track(int deltaX, int deltaY) {
		int i = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2)); // TODO Auto-generated method stub
		System.out.println("Передвижение на " + i + " пикселей");
	}

}

class EnMouse implements Mouse {

	@Override
	public void click() {
		System.out.println("Mouse click");// TODO Auto-generated method stub

	}

	@Override
	public void doubleClick() {
		System.out.println("Double mouse click");// TODO Auto-generated method stub

	}

	@Override
	public void scroll() {
		System.out.println("Mouse scroll");// TODO Auto-generated method stub

	}

}

class EnKeyboard implements Keyboard {

	@Override
	public void print() {
		System.out.println("Print row!");// TODO Auto-generated method stub

	}

	@Override
	public void println() {
		System.out.println("Print row and \"\n\"!");// TODO Auto-generated method stub

	}

}

class EnTouchpad implements Touchpad {

	@Override
	public void track(int deltaX, int deltaY) {
		int i = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2)); // TODO Auto-generated method stub
		System.out.println("Move the mouse on " + i + " pixels");
	}

}

class EnDeviceFactory implements DeviceFactory {

	@Override
	public Mouse getMouse() {
		return new EnMouse();
	}

	@Override
	public Keyboard getKeyboard() {
		return new EnKeyboard();
	}

	@Override
	public Touchpad geTouchpad() {
		return new EnTouchpad();
	}

}

class RuDeviceFactory implements DeviceFactory {

	@Override
	public Mouse getMouse() {
		return new RuMouse();
	}

	@Override
	public Keyboard getKeyboard() {
		return new RuKeyboard();
	}

	@Override
	public Touchpad geTouchpad() {
		return new RuTouchpad();
	}

}