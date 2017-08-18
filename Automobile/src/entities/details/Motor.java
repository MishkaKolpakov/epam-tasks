package entities.details;
public class Motor {
	String motorType;

	public Motor(String motorType) {
		this.motorType = motorType;
	}

	public String getMotorType() {
		return motorType;
	}

	public void setMotorType(String motorType) {
		this.motorType = motorType;
	}

	@Override
	public String toString() {
		return "Motor [motorType=" + motorType + "]";
	}

}
