package department;

import java.util.List;

public class Manager extends Employee{
	private List<Developer> developers;
	private List<Designer> designers;

	public List<Developer> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<Developer> developers) {
		this.developers = developers;
	}

	public List<Designer> getDesigners() {
		return designers;
	}

	public void setDesigners(List<Designer> designers) {
		this.designers = designers;
	}

}
