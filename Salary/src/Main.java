import dao.EmployeesDB;
import model.entity.employee.Employee;
import model.service.Fund;

public class Main {
	public static void main(String[] args) {

		EmployeesDB employeesDB = new EmployeesDB();
		Fund fund = new Fund(100000L);
		fund.distributeSalary(employeesDB);
		
		for(Employee employee : employeesDB.getEmployees()) {
			System.out.println(employee.getLastName() + ": " + employee.getSalary());
		}
	}
}
