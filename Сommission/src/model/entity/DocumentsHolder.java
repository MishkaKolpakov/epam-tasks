package model.entity;

import java.util.Queue;

public abstract class DocumentsHolder {

	private Queue<String> documents;

	public DocumentsHolder(Queue<String> documents) {
		this.documents = documents;
	}

	public Queue<String> getDocuments() {
		return documents;
	}

	public void setDocuments(Queue<String> documents) {
		this.documents = documents;
	}

}
