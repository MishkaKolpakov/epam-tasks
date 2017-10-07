package model.entity;

public class Order {
	private Client client;
	private Ticket ticket;
	private Integer orderPrice;
	
	public static class Builder{
		private Client client;
		private Ticket ticket;
		private Integer orderPrice;
		
		
		public Builder addClient(Client client){
			this.client = client;
			return this;
		}
		
		public Builder addTicket(Ticket ticket){
			this.ticket = ticket;
			return this;
		}
		
		public Builder addOrderPrice(Integer orderPrice){
			this.orderPrice = orderPrice;
			return this;
		}
		
		public Order build(){
			Order order = new Order();
			order.setClient(client);
			order.setTicket(ticket);
			order.setOrderPrice(orderPrice);
			return order;
		}
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Integer getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Integer orderPrice) {
		this.orderPrice = orderPrice;
	}

	

}
