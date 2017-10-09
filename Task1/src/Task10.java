import java.util.HashSet;
import java.util.Set;

public class Task10 {
	public Set<Character> charFrequency(String input) {
		Set<Character> unique = new HashSet<>();

		for (int i = 0; i < input.length(); i++) {
			unique.add(input.charAt(i));
		}
		return unique;
	}

	public void count(String input) {
		for (char c : charFrequency(input)) {
			int tmp = 0;
			for (int i = 0; i < input.length(); i++) {
				if (c == input.charAt(i)) {
					tmp++;
				}
			}
			System.out.println(c + "-" + tmp);
		}
	}
}
