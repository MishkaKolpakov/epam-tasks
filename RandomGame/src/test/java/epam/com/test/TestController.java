package epam.com.test;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.epam.Controller;
import com.epam.Model;
import com.epam.View;

import static org.junit.Assert.*;

public class TestController {

	Model model;
	View view;
	Controller controller;
	Scanner scanner;

	@Before
	public void init() {
		view = new View();
		model = new Model();
		controller = new Controller(view, model);

	}

	@Test
	public void testInputInRange() {
		scanner = new Scanner("25");
		model.setLowerBound(20);
		model.setUpperBound(30);
		int tmp = controller.inputIntDiapasoneValue(scanner);
		assertSame(25, tmp);
	}

	@Test
	public void testInputLowerDiapasone() {
		scanner = new Scanner("89");
		model.setLowerBound(0);
		model.setUpperBound(100);
		int tmp = controller.inputIntDiapasoneValue(scanner);
		assertSame(89, tmp);
	}
	
	@Test
	public void testInputHigherDiapasone() {
		scanner = new Scanner("35");
		model.setLowerBound(25);
		int tmp = controller.inputIntDiapasoneValue(scanner);
		assertSame(35, tmp);
	}

}
