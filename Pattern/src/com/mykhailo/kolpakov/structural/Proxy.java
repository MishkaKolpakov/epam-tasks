package com.mykhailo.kolpakov.structural;

public class Proxy {
	public static void main(String[] args) {
		Image image = new ProxyImage("my.png");
		image.display();
	}
}

interface Image {
	void display();
}

class RealImage implements Image {

	String file;

	public RealImage(String file) {
		this.file = file;
		load();
	}

	void load() {
		System.out.println("Loading " + file);
	}

	@Override
	public void display() {
		System.out.println("Watch " + file);
	}

}

class ProxyImage implements Image {
	String fileName;
	RealImage realImage;
	public ProxyImage(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void display() {
		if(realImage == null) {
			realImage = new RealImage(fileName);
		}
		realImage.display();
	}	

}