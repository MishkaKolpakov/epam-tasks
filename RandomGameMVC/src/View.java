

public class View {
	//Invitation for input
	public static final String INVITATION_TO_INPUT_MIN = "Please enter the value of diapason`s lower bound: ";
	public static final String INVITATION_TO_INPUT_MAX = "Please enter the value of diapason`s upper bound: ";
	
	//Some introduction sentences
	public static final String START_GAME = "So let`s start the game, the computer thought of number try to guess it. ";
	public static final String GAME_REGIME = "Please choose the game regime. If you choose [yes] game will start with default diapasone, if you choose [no] you should enter diapasone";
	
	//Wrong input text constants
	public static final String WRONG_EMPTY_VALUE = "You didn`t entered anything. Please try again";
	public static final String WRONG_INPUT_STRING_DATA = "You should input \"String\" values in format [Yes(y)/No(n)]. Please try again: ";
	public static final String WRONG_INPUT_INT_DATA = "You can only input \"int\" values. Please repeat with correct datatype:";
	public static final String WRONG_DIAPASON_MIN = "Min value must be in [0:100)";
	public static final String WRONG_DIAPASON_MAX = "Max value must be in ";
	
	public void displayMessage(String message) {
		System.out.println(message);
	}
}
