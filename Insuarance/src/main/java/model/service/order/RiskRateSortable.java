package model.service.order;

import java.util.List;
import model.entity.responsibility.Responsibility;

public interface RiskRateSortable {
	
	List<Responsibility> orderByRiskLevel(List<Responsibility> responsibilities);
}
