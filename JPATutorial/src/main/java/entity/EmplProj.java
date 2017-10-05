package entity;

public class EmplProj {

	private long employeeId;
	private long projectId;

	public EmplProj() {

	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (employeeId ^ (employeeId >>> 32));
		result = prime * result + (int) (projectId ^ (projectId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmplProj other = (EmplProj) obj;
		if (employeeId != other.employeeId)
			return false;
		if (projectId != other.projectId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmplProj [employeeId=" + employeeId + ", projectId=" + projectId + "]";
	}

}
