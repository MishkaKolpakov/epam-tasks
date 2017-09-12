package model.entity;

import java.util.Queue;

public class BiologyDocuments extends DocumentsHolder {
	private static final int DOCUMENTS_AMOUNT = 200;

	public BiologyDocuments(Queue<String> documents) {
		super(documents);
	}

	public static int getDocumentAmount() {
		return DOCUMENTS_AMOUNT;
	}

}
