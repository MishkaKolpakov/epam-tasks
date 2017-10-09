
public class Task3 {
	public String reverse(String value) {
		String result = "";
		for(int i = value.length() - 1; i >= 0; i--) {
			result += value.charAt(i);
		}
		return result;
	}
}
