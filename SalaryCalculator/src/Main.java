import model.dao.EmployeeDB;
import model.entity.employee.Worker;
import model.service.sort.LastNameSorter;
import model.service.sort.Sortable;

public class Main {

	public static void main(String[] args) {
		EmployeeDB employeeDB = new EmployeeDB();

		Sortable sorter = new LastNameSorter();
		
		for (Worker worker : sorter.sort(employeeDB.getWorkers())) {
			System.out.println(worker.getLastName() + " " + worker.getHireJobDate());
		}
	}
}
