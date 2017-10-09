
public class Task5 {
	public void histogram(int[] rowAmounts) {
		for(int i = 0; i < rowAmounts.length; i++) {
			for(int j = 0; j < rowAmounts[i]; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}
