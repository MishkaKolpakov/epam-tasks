package model.service;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import model.entity.BiologyDocuments;
import model.entity.MathDocuments;

public class QueueEngine implements QueueFillable {

	Queue<String> queue = new LinkedList<>();
	private final int QUEUE_UPPER_BOUND = 50;
	private final int QUEUE_LOWER_BOUND = 25;
	Random random = new Random();

	private boolean isBiologyEnd(BiologyDocuments biologyDocuments) {
		return biologyDocuments.getDocuments().size() == 0;
	}

	private boolean isMathEnd(MathDocuments mathDocuments) {
		return mathDocuments.getDocuments().size() == 0;
	}

	@Override
	public boolean fillQueue(MathDocuments mathDocuments, BiologyDocuments biologyDocuments) {
		if (isBiologyEnd(biologyDocuments) && isMathEnd(mathDocuments)) {
			return false;
		}

		if (isBiologyEnd(biologyDocuments)) {
			for (int i = 0; i < mathDocuments.getDocuments().size(); i++) {
				queue.add(mathDocuments.getDocuments().poll());
			}
			return false;
		}

		if (isMathEnd(mathDocuments)) {
			for (int i = 0; i < biologyDocuments.getDocuments().size(); i++) {
				queue.add(mathDocuments.getDocuments().poll());
			}
			return false;
		}

		if (queue.size() <= QUEUE_LOWER_BOUND) {
			while (queue.size() != 50) {
				boolean randomDecision = random.nextBoolean();
				if(randomDecision) {
					queue.add(mathDocuments.getDocuments().poll());
				} else {
					queue.add(biologyDocuments.getDocuments().poll());
				}
			}
		}
			return false;
	}

}
