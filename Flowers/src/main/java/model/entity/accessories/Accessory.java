package model.entity.accessories;

public class Accessory {
	private AccessoryType accessoryType;

	public AccessoryType getAccessoryType() {
		return accessoryType;
	}

	public void setAccessoryType(AccessoryType accessoryType) {
		this.accessoryType = accessoryType;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return accessoryType + "\n";
	}

}
