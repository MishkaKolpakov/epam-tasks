package model.entity.employee;

public class Worker {
	private Employee employee;
	private Position position = Position.WORKER;
	private Long salaryRate = position.getSalaryRate();

	public Worker(Employee employee) {
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Position getPosition() {
		return position;
	}

	public Long getSalaryRate() {
		return salaryRate;
	}

}
