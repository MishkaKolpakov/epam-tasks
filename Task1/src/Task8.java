import java.util.Scanner;

public class Task8 {

	public void runGame(int lowerBound, int upperBound) {
		int numberToGuess = random(lowerBound, upperBound);
		guessNumber(numberToGuess, lowerBound, upperBound);
	}

	public void guessNumber(int numberToGuess, int lowerBound, int upperBound) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter int: ");
			int tmp = sc.nextInt();
			if (numberToGuess == tmp) {
				System.out.println("You won");
				sc.close();
				break;
			} else {
				System.out.println("Try again, diapasone: " + lowerBound + "-" + upperBound);
			}
		}
	}

	public int random(int lowerBound, int upperBound) {
		int tmp = (int) (Math.random() * (upperBound - lowerBound)) + lowerBound;
		return tmp;
	}
}
