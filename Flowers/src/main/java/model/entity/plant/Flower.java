package model.entity.plant;

public class Flower {

	private FlowerType flowerType;
	private boolean needSupport;
	private boolean needNorish;

	public Flower(FlowerType flowerType, boolean needSupport, boolean needNorish) {
		this.flowerType = flowerType;
		this.needNorish = needNorish;
		this.needSupport = needSupport;
	}

	public boolean isNeedSupport() {
		return needSupport;
	}

	public void setNeedSupport(boolean needSupport) {
		this.needSupport = needSupport;
	}

	public boolean isNeedNorish() {
		return needNorish;
	}

	public void setNeedNorish(boolean needNorish) {
		this.needNorish = needNorish;
	}

	public FlowerType getFlowerType() {
		return flowerType;
	}

	public void setFlowerType(FlowerType flowerType) {
		this.flowerType = flowerType;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " " + flowerType;
	}

}
