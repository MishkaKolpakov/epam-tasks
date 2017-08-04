package com.kolpakov.mykhailo.arraylist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class MyArrayList<E> extends ArrayList<E> {

	private static final long serialVersionUID = 1L;

	@Override
	public E remove(int index) {
		System.out.println("remove operation unsupported");
		return null;
	}

	@Override
	public void clear() {

		System.out.println("Clear operation unsupported");
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		System.out.println("RemoveAll operation unsupported");
		return false;
	}

	@Override
	public boolean remove(Object o) {
		System.out.println("Can`t remove object" + o);
		return false;
	}

	@Override
	protected void removeRange(int fromIndex, int toIndex) {
		System.out.println("removeRange operation unsupported");
	}

	@Override
	public boolean removeIf(Predicate<? super E> filter) {
		System.out.println("RemoveIf operation unsupported");
		return false;
	}

}
