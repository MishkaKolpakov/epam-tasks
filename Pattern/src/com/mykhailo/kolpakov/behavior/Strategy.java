package com.mykhailo.kolpakov.behavior;

import java.util.Arrays;

public class Strategy {
	public static void main(String[] args) {
		
		ClientStrategy clientStrategy = new ClientStrategy();
		Sorting strategy = new BubbleSort();
		
		int arr[] = new int[10];
		for(int i = 0; i < 10; i++) {
			arr[i] = (int) (Math.random()*100);
		}
		clientStrategy.setStrategy(strategy);
		clientStrategy.executeStrategy(arr);
		
		strategy = new SelectionSort();
		clientStrategy.setStrategy(strategy);
		clientStrategy.executeStrategy(arr);
		
	}
}

interface Sorting {
	void sort(int[] arr);
}

class ClientStrategy {
	Sorting strategy;

	public void setStrategy(Sorting strategy) {
		this.strategy = strategy;
	}

	public void executeStrategy(int[] arr) {
		strategy.sort(arr);
	}
}

class BubbleSort implements Sorting {

	@Override
	public void sort(int[] arr) {
		System.out.println("Bubble sort: ");
		System.out.println("before sorting: " + Arrays.toString(arr));
		int i, j;
		for (i = arr.length - 1; i >= 0; i--)
			for (j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		System.out.println("After: " + Arrays.toString(arr));
	}
}

class SelectionSort implements Sorting {

	@Override
	public void sort(int[] arr) {
		System.out.println("Selection sort");
		System.out.println("before sorting: " + Arrays.toString(arr));
		int i, j;
		for (i = 0; i < arr.length-1 ; i++)
			for (j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
				}
			}
		System.out.println("After: " + Arrays.toString(arr));
	}
}
