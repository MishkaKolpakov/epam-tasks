package model.entity.bouquet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.entity.accessories.Accessory;
import model.entity.plant.Flower;

public class Bouquet {
	private BouquetForm bouquetForm;
	private BouquetFreshness bouquetFreshness;
	private BouquetHoliday bouquetHoliday;
	private BouquetPrice bouquetPrice;
	private BouquetSize bouquetSize;
	private ArrayList<Flower> flowers = new ArrayList<>();
	private HashSet<Accessory> accessories = new HashSet<>();

	public List<Flower> getFlowers() {
		return flowers;
	}

	public void addFlowers(Flower flower) {
		flowers.add(flower);
	}

	public Set<Accessory> getAccessories() {
		return accessories;
	}

	public void addAccessories(Accessory accessory) {
		accessories.add(accessory);
	}

	public BouquetForm getBouquetForm() {
		return bouquetForm;
	}

	public void setBouquetForm(BouquetForm bouquetForm) {
		this.bouquetForm = bouquetForm;
	}

	public BouquetFreshness getBouquetFreshness() {
		return bouquetFreshness;
	}

	public void setBouquetFreshness(BouquetFreshness bouquetFreshness) {
		this.bouquetFreshness = bouquetFreshness;
	}

	public BouquetHoliday getBouquetHoliday() {
		return bouquetHoliday;
	}

	public void setBouquetHoliday(BouquetHoliday bouquetHoliday) {
		this.bouquetHoliday = bouquetHoliday;
	}

	public BouquetPrice getBouquetPrice() {
		return bouquetPrice;
	}

	public void setBouquetPrice(BouquetPrice bouquetPrice) {
		this.bouquetPrice = bouquetPrice;
	}

	public BouquetSize getBouquetSize() {
		return bouquetSize;
	}

	public void setBouquetSize(BouquetSize bouquetSize) {
		this.bouquetSize = bouquetSize;
	}

	@Override
	public String toString() {
		StringBuffer flowerOutput = new StringBuffer();
		
		for (Flower flowers : flowers) {
			flowerOutput.append(flowers.toString()).append(" ");
		}

		StringBuffer accessoryOutput = new StringBuffer();
		for (Accessory accessory : accessories) {
			accessoryOutput.append(accessory.toString()).append(" ");
		}
		return flowerOutput.toString() + accessoryOutput.toString() + bouquetForm + " " + bouquetFreshness + " " + bouquetHoliday + " " + bouquetPrice
				+ " " + bouquetSize + " ";
	}

}
