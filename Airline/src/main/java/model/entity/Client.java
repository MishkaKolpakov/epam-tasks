package model.entity;

import java.util.List;

public class Client {

	public static class Builder {

		private Long id;
		private String firstName;
		private String lastName;
		private String middleName;
		private String passportId;
		private User user;
		private List<Order> orders;

		public Builder addId(long id) {
			this.id = id;
			return this;
		}

		public Builder addFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder addMiddleName(String middleName) {
			this.middleName = middleName;
			return this;
		}

		public Builder addLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder addPassportId(String passportId) {
			this.passportId = passportId;
			return this;
		}

		public Builder addUser(User user) {
			this.user = user;
			return this;
		}

		public Builder addOrders(List<Order> orders) {
			this.orders = orders;
			return this;
		}

		public Client build() {
			Client client = new Client();
			client.setId(id);
			client.setFirstName(firstName);
			client.setMiddleName(middleName);
			client.setLastName(lastName);
			client.setPassportId(passportId);
			client.setUser(user);
			client.setOrders(orders);
			return client;
		}

	}

	private Long id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String passportId;
	private User user;
	private List<Order> orders;

	public Client() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPassportId() {
		return passportId;
	}

	public void setPassportId(String passportId) {
		this.passportId = passportId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((passportId == null) ? 0 : passportId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (passportId == null) {
			if (other.passportId != null)
				return false;
		} else if (!passportId.equals(other.passportId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName
				+ ", passportId=" + passportId + ", user=" + user + ", orders=" + orders + "]";
	}

}
