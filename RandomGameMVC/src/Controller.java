

import java.util.Scanner;

public class Controller {
	
	Model model;
	View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public void proccessUser() {
		Scanner gameRegimeScanner = new Scanner(System.in);
		Scanner gameEngineScanner = new Scanner(System.in);
		model.chooseGameRegime(inputGameRegime(gameRegimeScanner));
		chooseGameRegime();
		inputUserNumber(gameEngineScanner);
	}
	
	//Work method
	public void chooseGameRegime() {
		if(!model.gameRegime) {
			Scanner minValueScanner = new Scanner(System.in);
			Scanner maxValueScanner = new Scanner(System.in);
			
			model.setLowerBound(inputDiapasoneValue(minValueScanner, 
					Model.getMIN_LOWER_BOUND(), 
					Model.getMIN_UPPER_BOUND(), 
					View.INVITATION_TO_INPUT_MIN,
					View.WRONG_DIAPASON_MIN));
			
			model.setUpperBound(inputDiapasoneValue(maxValueScanner, 
					 	model.getLowerBound() + 1,
						Model.getMAX_UPPER_BOUND(), 
						View.INVITATION_TO_INPUT_MAX,
						View.WRONG_DIAPASON_MAX + model.processMaxValueDiapason()
						));
			
			model.setRandomNumber(model.rand(model.getLowerBound(), model.getUpperBound()));
			
		}
		else {
			model.setLowerBound(Model.getMIN_LOWER_BOUND());
			model.setUpperBound(Model.getMAX_UPPER_BOUND());
			model.setRandomNumber(model.rand(model.getLowerBound(), model.getUpperBound()));
		}
	}
	
	//Handling input of correct int value in determined range
	public int inputDiapasoneValue(Scanner sc, int lowerBound, int upperBound, String invitation, String wrongDiapasone) {
		view.displayMessage(invitation);
		while(true) {
			if(!sc.hasNextInt())
			view.displayMessage(View.WRONG_INPUT_INT_DATA);
			else {
				int tmp = sc.nextInt();
				if(model.checkRange(tmp, lowerBound, upperBound)) {
					return tmp;
					}
				view.displayMessage(wrongDiapasone);
			}
			sc.nextLine();
		}
	}
	
	//Handling user input during game
	public void inputUserNumber(Scanner sc) {
		view.displayMessage(View.START_GAME + model.currentDiapason());
		while(true) {
			if(!sc.hasNextInt())
			view.displayMessage(View.WRONG_INPUT_INT_DATA);
			else {
				int tmp = sc.nextInt();
				if(model.checkRange(tmp, model.getLowerBound(), model.getUpperBound())) {
					view.displayMessage(model.gameEngine(tmp));
					if(model.isEndGame()) break;
					view.displayMessage(model.currentDiapason());
					}
				else view.displayMessage(model.currentDiapason());
				}
			sc.nextLine();
			}
		}
	
	//Handling correct user regime choice
	public String inputGameRegime(Scanner sc) {
		view.displayMessage(View.GAME_REGIME);
		
		while(true) {
			if(!sc.hasNext()) {
			view.displayMessage(View.WRONG_EMPTY_VALUE);
			} else {
				String tmp = sc.next();
				if(model.checkRegime(tmp)) {
					return tmp;
					}
				view.displayMessage(View.WRONG_INPUT_STRING_DATA);
				}
			}
		}
	}
