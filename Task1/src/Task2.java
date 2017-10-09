
public class Task2 {
	public int sum(int[] list) {
		int result = 0;
		for(int temp : list) {
			result += temp;
		}
		
		return result;
	}
	
	public int multiply(int[] list) {
		int result = 1;
		for(int temp : list) {
			result *= temp;
		}
		return result;
	}
}
