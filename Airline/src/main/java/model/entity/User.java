package model.entity;

public class User {

	private Long id;
	private String password;
	private String email;
	private Role role;
	private Client client;

	public static class Builder {
		private Long id;
		private String password;
		private String email;
		private Role role;
		private Client client;

		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		public Builder setPassword(String password) {
			this.password = password;
			return this;
		}

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder setRole(Role role) {
			this.role = role;
			return this;
		}

		public Builder setClient(Client client) {
			this.client = client;
			return this;
		}

		public User build() {
			User user = new User();
			
			user.setId(id);
			user.setEmail(email);
			user.setPassword(password);
			user.setRole(role);
			user.setClient(client);
			
			return user;
		}
	}

	public enum Role {
		ADMIN, USER, GUEST;
	}

	public User() {
	}

	public User(Long id, String password, String email, Role role, Client client) {
		this.id = id;
		this.password = password;
		this.email = email;
		this.role = role;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
