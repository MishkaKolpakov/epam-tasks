package entity;

public class Driver {
	String name;
	String workPlace;

	public Driver(String name, String workPlace) {
		this.name = name;
		this.workPlace = workPlace;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	@Override
	public String toString() {
		return "Driver [name=" + name + ", workPlace=" + workPlace + "]";
	}

}
