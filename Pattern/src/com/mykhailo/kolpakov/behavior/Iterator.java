package com.mykhailo.kolpakov.behavior;

public class Iterator {
	public static void main(String[] args) {
		Tasks concreteAggregate = new Tasks();
		IteratorIF iteratorIF = concreteAggregate.getIterator();
		while(iteratorIF.hasNext()) {
			System.out.println(iteratorIF.next());
		}
	}
}

class Tasks implements Container {
	String[] tasks = { "Build house", "Grow up son", "Plant tree" };

	@Override
	public IteratorIF getIterator() {
		// TODO Auto-generated method stub
		return new TaskIterator();
	}

	private class TaskIterator implements IteratorIF {
		int index = 0;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return index < tasks.length;
		}

		@Override
		public String next() {
			return tasks[index++];
		}

	}
}

interface IteratorIF {
	boolean hasNext();

	Object next();
}

interface Container {
	IteratorIF getIterator();
}