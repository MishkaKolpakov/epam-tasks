
public class Task4 {
	public boolean isPalindrome(String value){
		String temp = ""; 
		for(int i = value.length() - 1; i >= 0; i--) {
			temp += value.charAt(i);
		}
		return temp.equals(value);
	}
}
