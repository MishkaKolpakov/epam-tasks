
public class WatchesFactory {
	public static void main(String[] args) {
		WatchMaker watchMaker = createWatch("Sand");
		Watch watch = watchMaker.createWatch();
		watch.showTime();
		watchMaker = createWatch("Digital");
		watch = watchMaker.createWatch();
		watch.showTime();
	}

	public static WatchMaker createWatch(String title) {
		switch (title) {
		case "Sand":
			return new SandWatchMaker();

		case "Digital":
			return new DigitalWatchMaker();

		case "Mechanic":
			return new MechanicWatchMaker();

		default:
			return null;

		}
	}
}

interface Watch {
	void showTime();
}

class DigitalWatch implements Watch {

	@Override
	public void showTime() {
		System.out.println("Digital watch time");
	}

}

class MechanicWatch implements Watch {

	@Override
	public void showTime() {
		System.out.println("Mechanic watch time");
	}

}

class SandWatch implements Watch {

	@Override
	public void showTime() {
		System.out.println("Sand watch time");
	}

}

interface WatchMaker {
	Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker {

	@Override
	public Watch createWatch() {
		return new DigitalWatch();
	}
}

class MechanicWatchMaker implements WatchMaker {

	@Override
	public Watch createWatch() {
		return new MechanicWatch();
	}

}

class SandWatchMaker implements WatchMaker {

	@Override
	public Watch createWatch() {
		return new SandWatch();
	}

}