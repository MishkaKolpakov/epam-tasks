
public class View {
	
	//Invitation for input text`s constants
	static String INPUT_WORD = "Please enter the word ";
	
	//Wrong input text`s constant
	static String WRONG_INPUT_WORD = "Wrong input! Please enter correct word";
	static String RESULT_OUTPUT = "The output sentence is: ";
	
	public void displayMessage(String message) {
		System.out.println(message);
	}
	
	public void displayInvitation(String invitation) {
		System.out.println(View.INPUT_WORD + "(\"" + invitation.toLowerCase() + "\"):");
	}
}
