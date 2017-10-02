package dao;

import java.util.Optional;
import model.entity.Client;

public interface ClientDao extends GenericDao<Client> {
	Optional<Client> findClientByPassportId(String passportId);
	boolean insertClientTicket(Long clientId, Long ticketId, Integer orderPrice);
	boolean deleteClientTicket(Long clientId, Long ticketId);
}
