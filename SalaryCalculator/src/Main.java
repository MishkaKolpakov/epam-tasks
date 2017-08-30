import model.dao.EmployeeDB;
import model.entity.employee.Worker;
import model.service.count.ActualSalaryDistributable;
import model.service.count.ActualSalaryDistributer;

public class Main {

	public static void main(String[] args) {
		ActualSalaryDistributable actualSalaryDistributer = new ActualSalaryDistributer();
		EmployeeDB employeeDB = new EmployeeDB();
		actualSalaryDistributer.distributeRest(50000L, employeeDB.getEmployees());
		for (Worker worker : employeeDB.getEmployees()) {
			System.out.println(worker.getLastName() + " " + worker.getActualSalary());
		}
	}
}
