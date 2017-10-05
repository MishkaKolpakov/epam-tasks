package model.entity;

import java.time.LocalDateTime;

public class Flight {

	private Long id;
	private LocalDateTime departureDateTime;
	private Integer placesAmount;
	private FlightInstance flightInstance;

	public static class Builder {
		private Long id;
		private LocalDateTime departureDateTime;
		private Integer placesAmount;
		private FlightInstance flightInstance;

		public Builder setId(Long id) {
			this.id = id;
			return this;
		}
		
		public Builder setDepartureDateTime(LocalDateTime departureDateTime) {
			this.departureDateTime = departureDateTime;
			return this;
		}

		public Builder setPlacesAmount(Integer placesAmount) {
			this.placesAmount = placesAmount;
			return this;
		}

		public Builder setFlightInstance(FlightInstance flightInstance) {
			this.flightInstance = flightInstance;
			return this;
		}

		public Flight build() {
			Flight flight = new Flight();
			flight.setId(id);
			flight.setDepartureDateTime(departureDateTime);
			flight.setPlacesAmount(placesAmount);
			flight.setFlightInstance(flightInstance);

			return flight;
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(LocalDateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public FlightInstance getFlightInstance() {
		return flightInstance;
	}

	public void setFlightInstance(FlightInstance flightInstance) {
		this.flightInstance = flightInstance;
	}

	public Integer getPlacesAmount() {
		return placesAmount;
	}

	public void setPlacesAmount(Integer placesAmount) {
		this.placesAmount = placesAmount;
	}

}
