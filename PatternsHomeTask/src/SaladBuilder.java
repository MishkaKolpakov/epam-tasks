import java.util.Arrays;

public class SaladBuilder {
	public static void main(String[] args) {
		Salad salad = new Salad.SaladBuilder(Vegatables.CABBAGE, Vegatables.TOMATO)
				.addSauce(Sauce.MUSHROOM)
				.addCheese(Cheese.CHEDDAR)
				.build();
		System.out.println(salad.getSalad());
	}
}

class Salad {
	private Cheese cheese = Cheese.MOZZARELLA;
	private Vegatables[] vegatables = { Vegatables.TOMATO, Vegatables.ONIONS };
	private Sauce sauce = Sauce.MUSHROOM;

	public Cheese getCheese() {
		return cheese;
	}

	public Vegatables[] getVegatables() {
		return vegatables;
	}

	public Sauce getSauce() {
		return sauce;
	}
	
	public String getSalad() {
		return this.toString();
	}

	@Override
	public String toString() {
		return "Salad consists of: "+ cheese + ", " + Arrays.toString(vegatables) + ", " + sauce;
	}

	private Salad(SaladBuilder saladBuilder) {
		this.cheese = saladBuilder.cheese;
		this.vegatables = saladBuilder.vegatables;
		this.sauce = saladBuilder.sauce;
	}

	static class SaladBuilder {
		private Cheese cheese = Cheese.MOZZARELLA;
		private Vegatables[] vegatables = { Vegatables.TOMATO, Vegatables.ONIONS };
		private Sauce sauce = Sauce.MUSHROOM;
		
		public SaladBuilder(Vegatables... vegatables) {
			this.vegatables = vegatables;
		}
		
		public SaladBuilder addCheese(Cheese cheese) {
			this.cheese = cheese;
			return this;
		}
		
		public SaladBuilder addVegatables(Vegatables... vegatables) {
			this.vegatables = vegatables;
			return this;
		}
		
		public SaladBuilder addSauce(Sauce sauce) {
			this.sauce = sauce;
			return this;
		}
		
		public Salad build() {
			return new Salad(this);
		}
	}

}

enum Cheese {
	CHEDDAR, MOZZARELLA, MASCARPONE;
}

enum Vegatables {
	ONIONS, TOMATO, CABBAGE;
}

enum Sauce {
	SALSA, MUSHROOM, WINE;
}