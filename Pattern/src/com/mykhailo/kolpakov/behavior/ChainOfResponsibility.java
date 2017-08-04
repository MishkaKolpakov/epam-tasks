package com.mykhailo.kolpakov.behavior;

public class ChainOfResponsibility {
	public static void main(String[] args) {
		Logger smsLogger = new SMSLogger(Level.ERROR);
		Logger fileLogger = new FileLogger(Level.DEBUG);

		smsLogger.setNext(fileLogger);
		smsLogger.writeMessage("Error", Level.ERROR);
		smsLogger.writeMessage("Debug", Level.DEBUG);
		
		NoteModule noteModule500 = new NoteModule500();
		NoteModule noteModule200 = new NoteModule200();
		NoteModule noteModule100 = new NoteModule100();
		NoteModule noteModule50 = new NoteModule50();
		
		noteModule500.setNextModule(noteModule200);
		noteModule200.setNextModule(noteModule100);
		noteModule100.setNextModule(noteModule50);
		
		noteModule500.takeMoney(new Money(2400));
		
		
	}
}

interface Note {
	public static final int UAH50 = 50;
	public static final int UAH100 = 100;
	public static final int UAH200 = 200;
	public static final int UAH500 = 500;
}

class Money {
	private int sum;

	public Money(int sum) {
		setSum(sum);// TODO Auto-generated constructor stub
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		if (sum > 0 && sum <= 10000 && sum % Note.UAH50 == 0)
			this.sum = sum;
		else {
			throw new RuntimeException("Entered summ should be lesser than 10000UAH and multiple to 50");
		}
	}
}

abstract class NoteModule {
	NoteModule next;

	abstract void takeMoney(Money money);

	void setNextModule(NoteModule module) {
		next = module;
	}
}

class NoteModule500 extends NoteModule {

	@Override
	void takeMoney(Money money) {
		int countNotes = money.getSum() / Note.UAH500;
		int remind = money.getSum() % Note.UAH500;
		if (countNotes > 0) {
			System.out.println("Give " + countNotes + " notes with the nominal " + Note.UAH500);
		}
		if (remind > 0 && next != null) {
			next.takeMoney(new Money(remind));
		}
	}
}

class NoteModule200 extends NoteModule {

	@Override
	void takeMoney(Money money) {
		int countNotes = money.getSum() / Note.UAH200;
		int remind = money.getSum() % Note.UAH200;
		if (countNotes > 0) {
			System.out.println("Give " + countNotes + " notes with the nominal " + Note.UAH200);
		}
		if (remind > 0 && next != null) {
			next.takeMoney(new Money(remind));
		}
	}
}

class NoteModule100 extends NoteModule {

	@Override
	void takeMoney(Money money) {
		int countNotes = money.getSum() / Note.UAH100;
		int remind = money.getSum() % Note.UAH100;
		if (countNotes > 0) {
			System.out.println("Give " + countNotes + " notes with the nominal " + Note.UAH100);
		}
		if (remind > 0 && next != null) {
			next.takeMoney(new Money(remind));
		}
	}
}

class NoteModule50 extends NoteModule {

	@Override
	void takeMoney(Money money) {
		int countNotes = money.getSum() / Note.UAH50;
		int remind = money.getSum() % Note.UAH50;
		if (countNotes > 0) {
			System.out.println("Give " + countNotes + " notes with the nominal " + Note.UAH50);
		}
		if (remind > 0 && next != null) {
			next.takeMoney(new Money(remind));
		}
	}
}

class Level {
	public final static int ERROR = 1;
	public final static int DEBUG = 2;
	public final static int INFO = 3;

}

abstract class Logger {
	Logger next;
	int priority;

	public Logger(int priority) {
		this.priority = priority;
	}

	public void writeMessage(String message, int level) {
		if (level <= priority) {
			write(message);
		}

		if (next != null) {
			next.writeMessage(message, level);
		}
	}

	public boolean setNext(Logger next) {
		this.next = next;
		return true;
	}

	abstract void write(String message);

}

class SMSLogger extends Logger {
	public SMSLogger(int priority) {
		super(priority);
	}

	@Override
	void write(String message) {
		System.out.println("SMS: " + message);// TODO Auto-generated method stub

	}

}

class FileLogger extends Logger {
	public FileLogger(int priority) {
		super(priority);
	}

	@Override
	void write(String message) {
		System.out.println("File: " + message);// TODO Auto-generated method stub

	}

}
