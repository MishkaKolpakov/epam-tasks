package model.service;

import java.util.LinkedList;
import java.util.Queue;

import model.entity.BiologyDocuments;
import model.entity.MathDocuments;

public class DocumentsUtil implements DocumentsFillable {

	@Override
	public Queue<String> fillBiologyDocuments() {
		Queue<String> documentsHolder = new LinkedList<>();
		for (int i = 1; i <= BiologyDocuments.getDocumentAmount(); i++) {
			documentsHolder.add("Biological document #" + i);
		}
		return documentsHolder;
	}

	@Override
	public Queue<String> fillMathDocuments() {
		Queue<String> documentsHolder = new LinkedList<>();
		for (int i = 1; i <= MathDocuments.getDocumentAmount(); i++) {
			documentsHolder.add("Math document #" + i);
		}
		return documentsHolder;
	}

}
