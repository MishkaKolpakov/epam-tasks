package dao;

import java.util.Optional;

import model.entity.FlightInstance;

public interface FlightInstanceDao extends GenericDao<FlightInstance>{
	public Optional<FlightInstance> findFlightByDirection(String from, String to);
}
