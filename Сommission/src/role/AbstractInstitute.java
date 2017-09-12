package role;

import java.util.LinkedList;
import java.util.Queue;

public abstract class AbstractInstitute implements Runnable {
	public abstract void takeDocuments();

	protected Queue<String> queue;
	protected Queue<String> institute = new LinkedList<>();

	public Queue<String> getInstitute() {
		return institute;
	}

	@Override
	public void run() {
		takeDocuments();
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void setQueue(Queue<String> queue) {
		this.queue = queue;
	}

}
