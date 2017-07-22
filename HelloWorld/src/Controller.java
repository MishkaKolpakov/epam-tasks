import java.util.Scanner;

public class Controller {
	static String firstInputValue = "HELLO";
	static String secondInputValue = "WORLD";
	
	//Constructor
	Model model;
	View view;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	//Work method
	public void processUser() {
		Scanner scanner = new Scanner(System.in);
		
		model.setFirstWord(inputValidValue(scanner, firstInputValue));
		model.setSecondWord(inputValidValue(scanner, secondInputValue));
		model.setSentence(model.concatenation(model.getFirstWord(), model.getSecondWord()));
		
		view.displayMessage(View.RESULT_OUTPUT + model.getSentence());
	}
	
	//Utility method for processing word
	public String inputValidValue(Scanner sc, String validValue) {
		view.displayInvitation(validValue);
		String temp;
		while(true) {
			temp = sc.nextLine();
			if(temp.toUpperCase().equals(validValue)) 
				return temp;
			else {
				view.displayMessage(View.WRONG_INPUT_WORD);
				view.displayInvitation(validValue);
			}
				
		}
		
	}
	}
