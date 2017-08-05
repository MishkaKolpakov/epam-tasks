package com.mykhailo.kolpakov.behavior;

import java.util.ArrayList;
import java.util.List;

public class Mediator {
	public static void main(String[] args) {
		TextChat chat = new TextChat();

		Client admin = new Admin(chat, "Stepan");
		Client client1 = new SimpleClient(chat, "Vasyliy");
		Client client2 = new SimpleClient(chat, "Andrew");
		Client client3 = new SimpleClient(chat, "Vova");
		
		client2.setEnable(false);
		chat.setAdmin(admin);
		chat.addClient(client1);
		chat.addClient(client2);
		chat.addClient(client3);
		
		admin.sendMessage("Warning!!");
		
		
	}
}

abstract class Client {
	Chat chat;
	String name;

	public String getName() {
		return name;
	}
	
	public void sendMessage(String message) {
		chat.sendMessage(message, this);
	}

	boolean isEnable = true;

	public boolean isEnable() {
		return isEnable;
	}

	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}

	public Client(Chat chat, String name) {
		this.chat = chat;
		this.name = name;
	}

	abstract void getMessage(String message);

	@Override
	public String toString() {
		return "Client [name=" + name + "]";
	}
}

class Admin extends Client {

	public Admin(Chat chat, String name) {
		super(chat, name);
	}

	@Override
	void getMessage(String message) {
		System.out.println("Admin " + getName() + " get message " + message);

	}

}

class SimpleClient extends Client {

	public SimpleClient(Chat chat, String name) {
		super(chat, name);
	}

	@Override
	void getMessage(String message) {
		System.out.println("Client " + getName() + " get message " + message);

	}

}

interface Chat {
	void sendMessage(String message, Client client);
}

class TextChat implements Chat {
	Client admin;
	List<Client> clients = new ArrayList<>();

	public void setAdmin(Client admin) {
		if (admin != null && admin instanceof Admin) {
			this.admin = admin;
		} else {
			throw new RuntimeException("Not enough rights");
		}
	}

	public void addClient(Client client) {
		if (admin == null)
			throw new RuntimeException("No admin");
		if (client != null && client instanceof SimpleClient) {
			clients.add(client);
		}

	}

	public void sendMessage(String message, Client client) {
		if (client instanceof Admin) {
			for (Client u : clients)
				u.getMessage(client.getName() + ": " + message);
		}

		if (client instanceof SimpleClient) {
			for (Client u : clients) {
				if (u != client && u.isEnable()) {
					u.getMessage(client.getName() + " " + message);
				}
			}
		}
		if (admin.isEnable()) {
			admin.getMessage(client.getName() + " " + message);
		}
	}

}
/*
 * interface Client { void sendMessage(String message);
 * 
 * void getMessage(String message); }
 * 
 * class Admin implements Client { Chat chat;
 * 
 * public Admin(Chat chat) { this.chat = chat; }
 * 
 * @Override public void sendMessage(String message) { chat.sendMessae(message,
 * this); }
 * 
 * @Override public void getMessage(String message) {
 * System.out.println("Admin get message" + message); } }
 * 
 * class SimpleClient implements Client { Chat chat;
 * 
 * public SimpleClient(Chat chat) { this.chat = chat;// TODO Auto-generated
 * constructor stub }
 * 
 * @Override public void sendMessage(String message) { chat.sendMessae(message,
 * this); }
 * 
 * @Override public void getMessage(String message) {
 * System.out.println("Client get message " + message + " !");
 * 
 * }
 * 
 * }
 * 
 * interface Chat { void sendMessae(String message, Client client); }
 * 
 * class TextChat implements Chat {
 * 
 * Client admin; List<Client> clients = new ArrayList<>();
 * 
 * public void setAdmin(Client admin) { this.admin = admin; }
 * 
 * public void addClient(Client client) { clients.add(client); }
 * 
 * @Override public void sendMessae(String message, Client client) { for (Client
 * client : clients) { client.getMessage(message); }
 * admin.getMessage(message);// TODO Auto-generated method stub
 * 
 * }
 * 
 * }
 */
