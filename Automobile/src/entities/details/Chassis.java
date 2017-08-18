package entities.details;

public class Chassis {
	String material;

	public Chassis(String material) {
		this.material = material;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Chassis [material=" + material + "]";
	}

}
