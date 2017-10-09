
public class Task6 {
	public String enrypt(String input, int key) {
		String enrypt = "";
		for(int i = 0; i < input.length(); i++) {
			enrypt += (char)(input.charAt(i) + key);
		}
		return enrypt;
	}
}
