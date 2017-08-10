
public class ComputerFacade {
	public static void main(String[] args) {
		Computer computer = new Computer();
		computer.action();

	}
}

class Computer {
	private HDD hdd = new HDD();
	private GraphicAdapter graphicAdapter = new GraphicAdapter();
	private Monitor monitor = new Monitor();
	
	public void action() {
		monitor.onDisplay();
		hdd.hddWrite("some inf");
		graphicAdapter.outputPicture("some image");
		hdd.hddRemove();
		monitor.offDisplay();
	}

}

class HDD {
	public HDD() {
		System.out.println("HDD disk is added");
	}

	public void hddWrite(String information) {
		System.out.println("The information " + information + " was saved");
	}

	public void hddRemove() {
		System.out.println("The disk was formated");
	}
}

class Monitor {
	public Monitor() {
		System.out.println("The monitor added");
	}

	public void onDisplay() {
		System.out.println("Display is on");
	}

	public void offDisplay() {
		System.out.println("Display is off");
	}
}

class GraphicAdapter {
	public GraphicAdapter() {
		System.out.println("The graphic adapter added");
	}

	public void outputPicture(String picture) {
		System.out.println("The picture: " + picture);
	}

}
