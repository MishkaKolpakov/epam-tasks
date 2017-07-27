import model.entity.accessories.Accessory;
import model.entity.accessories.AccessoryType;
import model.entity.bouquet.Bouquet;
import model.entity.bouquet.BouquetForm;
import model.entity.bouquet.BouquetFreshness;
import model.entity.bouquet.BouquetHoliday;
import model.entity.bouquet.BouquetPrice;
import model.entity.bouquet.BouquetSize;
import model.entity.plant.Flower;
import model.entity.plant.FlowerType;

public class Main {

	public static void main(String[] args) {

		Bouquet bouquet = new Bouquet();
		Flower firstFlower = new Flower(FlowerType.Monocolor, true, false);
		bouquet.addFlowers(firstFlower);
		bouquet.addFlowers(new Flower(FlowerType.Multicolor, false, true));
		Accessory accessory = new Accessory();
		accessory.setAccessoryType(AccessoryType.Wrapper);
		bouquet.setBouquetForm(BouquetForm.MiddleStem);
		bouquet.setBouquetFreshness(BouquetFreshness.Fresh);
		bouquet.setBouquetHoliday(BouquetHoliday.Funeral);
		bouquet.addAccessories(accessory);
		bouquet.setBouquetPrice(BouquetPrice.Expensive);
		bouquet.setBouquetSize(BouquetSize.Large);
		System.out.println(bouquet.toString());
	}
}
