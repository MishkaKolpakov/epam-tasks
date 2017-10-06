package dao;

import java.util.List;
import java.util.Optional;
import model.entity.Order;

public interface OrderDao extends GenericDao<Order>{
	public List<Long> getOrderIdsByClientId(Long clientId);
	public Optional<Long> getOrderByIds(Long clientId, Long ticketId);
	public Integer getOrderPrice(Long orderId);
}
