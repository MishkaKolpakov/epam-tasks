package model.entity;

import java.time.LocalDateTime;

public class Ticket {
	private Long id;
	private Integer ticketPrice;
	private Integer baggagePrice;
	private Integer firstInQueuePrice;
	private LocalDateTime departureDateTime;
	private Integer placesAmount;
	private FlightInstance flightInstance;

	public static class Builder {
		private Integer ticketPrice;
		private Integer baggagePrice;
		private Integer firstInQueuePrice;
		private LocalDateTime departureDateTime;
		private Integer placesAmount;
		private FlightInstance flightInstance;
		private Long id;
		
		public Builder setId(Long id) {
			this.id = id;
			return this;
		}
		
	
		public Builder setTicketPrice(Integer ticketPrice) {
			this.ticketPrice = ticketPrice;
			return this;
		}

		public Builder setBaggagePrice(Integer baggagePrice) {
			this.baggagePrice = baggagePrice;
			return this;
		}

		public Builder setFirstInQueuePrice(Integer firstInQueuePrice) {
			this.firstInQueuePrice = firstInQueuePrice;
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


		public Ticket build() {
			Ticket ticket = new Ticket();
			ticket.setId(id);
			ticket.setBaggagePrice(baggagePrice);
			ticket.setFirstInQueuePrice(firstInQueuePrice);
			ticket.setTicketPrice(ticketPrice);
			ticket.setFlightInstance(flightInstance);
			ticket.setDepartureDateTime(departureDateTime);
			ticket.setPlacesAmount(placesAmount);
			return ticket;
		}
	}

	
	public LocalDateTime getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(LocalDateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public Integer getPlacesAmount() {
		return placesAmount;
	}

	public void setPlacesAmount(Integer placesAmount) {
		this.placesAmount = placesAmount;
	}

	public FlightInstance getFlightInstance() {
		return flightInstance;
	}

	public void setFlightInstance(FlightInstance flightInstance) {
		this.flightInstance = flightInstance;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(Integer ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public Integer getBaggagePrice() {
		return baggagePrice;
	}

	public void setBaggagePrice(Integer baggagePrice) {
		this.baggagePrice = baggagePrice;
	}

	public Integer getFirstInQueuePrice() {
		return firstInQueuePrice;
	}

	public void setFirstInQueuePrice(Integer firstInQueuePrice) {
		this.firstInQueuePrice = firstInQueuePrice;
	}
}
