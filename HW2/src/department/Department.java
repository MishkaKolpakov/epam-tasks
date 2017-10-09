package department;
import java.util.List;

public class Department {
	List<Manager> managers;

	public List<Manager> getManagers() {
		return managers;
	}

	public void setManagers(List<Manager> managers) {
		this.managers = managers;
	}

	public void filterManagers() {
		for (Manager manager : managers)
			if (manager.getDesigners().isEmpty() && manager.getDevelopers().isEmpty()) {
				managers.remove(manager);
			}
	}

	private void templateEmployee(Employee employee) {
		double salary = 0;
		double bonus = 0;
		if (employee.getExperiance() > 2 && employee.getExperiance() < 5) {
			bonus = 200;
			salary = employee.getSalary();
		}

		if (employee.getExperiance() > 5) {
			bonus = 500;
			salary = employee.getSalary() * 1.2;
		}
		salary += bonus;
		employee.setSalary(salary);
		System.out.println(employee.getFirstName() + " " + employee.getSecondName() + ": " + employee.getSalary());
	}

	public void defineEmployeeSalaries() {
		for (Manager manager : managers) {
			for (Employee designer : manager.getDesigners()) {
				templateEmployee(designer);
			}

			for (Employee developer : manager.getDevelopers()) {
				templateEmployee(developer);
			}

			templateEmployee(manager);
		}
	}

	public void defineDesignerSalaries() {
		for (Manager manager : managers) {
			for (Designer designer : manager.getDesigners()) {
				designer.setSalary(designer.getSalary() * designer.getCoefficient());
			}
		}
	}

	public void defineManagerSalaries() {
		for (Manager manager : managers) {
			double bonus = 0;
			int employeeAmount = manager.getDesigners().size() + manager.getDevelopers().size();

			if (employeeAmount > 5 && employeeAmount < 10) {
				bonus = 200;
			}

			if (employeeAmount > 10) {
				bonus = 300;
			}

			manager.setSalary(manager.getSalary() + bonus);
			if (manager.getDesigners().size() < manager.getDevelopers().size()) {
				manager.setSalary(manager.getSalary() * 1.1);
			}

		}
	}

	private void redefineToString(Employee employee, Manager manager) {
		System.out.println(employee.getFirstName() + " " + employee.getSecondName() + ", manager:"
				+ manager.getSecondName() + ", experience: " + employee.getExperiance());
	}

	public void outputEmployeeManager() {

		for (Manager manager : managers) {
			for (Employee developer : manager.getDevelopers()) {
				redefineToString(developer, manager);
			}

			for (Employee designer : manager.getDesigners()) {
				redefineToString(designer, manager);
			}
		}

	}
}
