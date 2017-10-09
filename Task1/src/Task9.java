import java.util.Stack;

public class Task9 {
	public boolean checkBrackets(String input) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ']') {
				if (stack.isEmpty()) {
					return false;
				}
			}
			
			if (input.charAt(i) == '[') {
				stack.push(input.charAt(i));
			}

			if (input.charAt(i) == ']') {
				stack.pop();
			}
		}

		return stack.isEmpty();
	}
	
	public void outputResponse(String input) {
		if(checkBrackets(input)) {
			System.out.println(input + "OK");
		} else {
			System.out.println(input + " NOT OK");
		}
	}
}
