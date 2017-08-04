package com.mykhailo.kolpakov.behavior;

public class Command {
	public static void main(String[] args) {
		Computer computer = new Computer();
		
		User user = new User(new StartCommand(computer), new StopCommand(computer), new ResetCommand(computer));
		
		user.startComputer();
		user.stopComputer();
		user.resetComputer();
	}
}

interface CommandIF {
	void execute();
}

// Receiver
class Computer {
	void start() {
		System.out.println("Start");
	}

	void stop() {
		System.out.println("Stop");
	}

	void reset() {
		System.out.println("Reset");
	}
}

// Concrete command
class StartCommand implements CommandIF {

	Computer computer;

	public StartCommand(Computer computer) {
		this.computer = computer;
	}

	@Override
	public void execute() {
		computer.start();

	}
}

// Concrete command
class StopCommand implements CommandIF {

	Computer computer;

	public StopCommand(Computer computer) {
		this.computer = computer;
	}

	@Override
	public void execute() {
		computer.stop();
	}
}

// Concrete command
class ResetCommand implements CommandIF {

	Computer computer;

	public ResetCommand(Computer computer) {
		this.computer = computer;
	}

	@Override
	public void execute() {
		computer.reset();
	}
}

// Invoker
class User {
	CommandIF start;
	CommandIF stop;
	CommandIF reset;

	public User(CommandIF start, CommandIF stop, CommandIF reset) {
		this.start = start;
		this.stop = stop;
		this.reset = reset;
	}
	
	void startComputer() {
		start.execute();
	}
	
	void stopComputer() {
		stop.execute();
	}
	
	void resetComputer() {
		reset.execute();
	}
}
