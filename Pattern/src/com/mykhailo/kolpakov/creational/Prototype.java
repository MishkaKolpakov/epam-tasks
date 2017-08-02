package com.mykhailo.kolpakov.creational;

public class Prototype {
	public static void main(String[] args) {
		Human original = new Human(18, "Mark");
		Human copy = original.copy();
		System.out.println(copy);
		
		HumanFactory humanFactory = new HumanFactory(copy);
		Human human1 = humanFactory.makeCopy();
		System.out.println(human1);
		
		humanFactory.setPrototype(new Human(20, "PetyA"));
		Human human2 = humanFactory.makeCopy();
		System.out.println(human2);
	}
}

interface Copyable {
	Human copy();
}

class Human implements Copyable {
	int age;
	String name;

	public Human(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public Human copy() {
		Human copy = new Human(age, name);// TODO Auto-generated method stub
		return copy;
	}

	@Override
	public String toString() {
		return "Human [age=" + age + ", name=" + name + "]";
	}

}

class HumanFactory {
	Human human;

	public HumanFactory(Human human) {
		setPrototype(human);
	}

	public void setPrototype(Human human) {
		this.human = human;
	}

	Human makeCopy() {
		return 	human.copy();
	}
}