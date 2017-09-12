package model.entity;

import java.util.Queue;

public class MathDocuments extends DocumentsHolder{
	private static final int DOCUMENTS_AMOUNT = 250;

	public MathDocuments(Queue<String> documents) {
		super(documents);
	}

	public static int getDocumentAmount() {
		return DOCUMENTS_AMOUNT;
	}
}
