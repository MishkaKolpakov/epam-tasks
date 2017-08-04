package com.kolpakov.mykhailo.arraylist;

public class Main {
	public static void main(String[] args) {
		MyArrayList<String> myArrayList = new MyArrayList<>();
		myArrayList.add("Misha");
		myArrayList.add("Misha");
		myArrayList.add("Misha");
		myArrayList.remove("Misha");
		for(String s : myArrayList)
		System.out.println(s);
	}

}
