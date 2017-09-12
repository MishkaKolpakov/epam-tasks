package model.service;

import java.util.Queue;

public interface DocumentsFillable {
	Queue<String> fillBiologyDocuments();

	Queue<String> fillMathDocuments();
}
