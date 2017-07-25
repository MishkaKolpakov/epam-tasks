package model.entity.plant;

public class Flower {

	private FlowerType flowerType;

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

	private boolean needSupport;
	private boolean needNorish;

	public FlowerType getFlowerType() {
		return flowerType;
	}

	public void setFlowerType(FlowerType flowerType) {
		this.flowerType = flowerType;
	}

}
