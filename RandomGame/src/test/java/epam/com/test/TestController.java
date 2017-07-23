package epam.com.test;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.epam.Controller;
import com.epam.Model;
import com.epam.View;

import org.junit.Assert;

public class TestController {

	Model model;
	View view;
	Controller controller;
	Scanner inRange;
	Scanner upperRange;
	Scanner lowerRange;

	@Before
	public void init() {
		view = new View();
		model = new Model();
		controller = new Controller(view, model);
		inRange = new Scanner("50");
		upperRange = new Scanner("100");
		lowerRange = new Scanner("0");
	}

	@Test
	public void testInputInDiapasone() {
		int tmp = controller.inputIntDiapasoneValue(inRange);
		Assert.assertSame(50, tmp);
	}
}
