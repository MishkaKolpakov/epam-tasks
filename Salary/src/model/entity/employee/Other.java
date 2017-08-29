package model.entity.employee;

public class Other {
	private Employee employee;
	private String desctription;
	private Position position;
	private Long salaryRate = position.getSalaryRate();

	public Other(Employee employee, Position otherPosition, String desctription) {
		this.employee = employee;
		this.desctription = desctription;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Long getSalaryRate() {
		return salaryRate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getDesctription() {
		return desctription;
	}

	public void setDesctription(String desctription) {
		this.desctription = desctription;
	}
}
