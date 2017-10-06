package model.entity;

public class Ticket {
	private Long id;
	private Integer ticketPrice;
	private Integer baggagePrice;
	private Integer firstInQueuePrice;
	private Flight flight;

	public static class Builder {
		private Integer ticketPrice;
		private Integer baggagePrice;
		private Integer firstInQueuePrice;
		private Flight flight;
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

		public Builder setFlight(Flight flight) {
			this.flight = flight;
			return this;
		}


		public Ticket build() {
			Ticket ticket = new Ticket();
			ticket.setId(id);
			ticket.setBaggagePrice(baggagePrice);
			ticket.setFirstInQueuePrice(firstInQueuePrice);
			ticket.setTicketPrice(ticketPrice);
			ticket.setFlight(flight);
			return ticket;
		}
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

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
}
