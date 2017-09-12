package model.service;

import model.entity.BiologyDocuments;
import model.entity.MathDocuments;

public interface QueueFillable {
	boolean fillQueue(MathDocuments mathDocuments, BiologyDocuments biologyDocuments);
}
