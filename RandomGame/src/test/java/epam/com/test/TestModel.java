package epam.com.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.epam.Model;
import com.epam.interfaces.Constants;

public class TestModel {
	Model model;

	@Before
	public void initModel() {
		model = new Model();
	}

	@Test
	public void testRandom() {
		int tmp = model.random(0, 100);
		assertTrue(tmp > 0 && tmp < 100);
	}

	@Test
	public void testCheckInRange() {
		model.setLowerBound(10);
		model.setUpperBound(20);
		assertTrue(model.checkRange(15));
	}

	@Test
	public void testCheckLowerRange() {
		model.setLowerBound(10);
		model.setUpperBound(20);
		assertFalse(model.checkRange(9));
	}

	@Test
	public void testCheckHigherRange() {
		model.setLowerBound(10);
		model.setUpperBound(20);
		assertFalse(model.checkRange(21));
	}

	@Test
	public void testCheckInputYesRegime() {
		assertTrue(model.checkInputRegime("yes") || model.checkInputRegime("y"));
	}

	@Test
	public void testCheckInputNoRegime() {
		assertTrue(model.checkInputRegime("no") || model.checkInputRegime("n"));
	}

	@Test
	public void testCheckInputFailRegime() {
		assertFalse(model.checkInputRegime("some") || model.checkInputRegime("12") || model.checkInputRegime(" "));
	}

	@Test
	public void testChooseGameRegimeWithYes() {
		assertTrue(model.chooseGameRegime("yes") || model.chooseGameRegime("y"));
	}

	@Test
	public void testChooseGameRegimeWithNo() {
		assertFalse(model.chooseGameRegime("no") || model.chooseGameRegime("n"));
	}

	@Test
	public void testCheckLowerDifferanceOutOfRange() {
		assertFalse(model.checkLowerDifferance(100));
	}

	@Test
	public void testCheckLowerDifferanceWithInRange() {
		assertTrue(model.checkLowerDifferance(89));
	}

	@Test
	public void testCheckHigherDifferanceInRange() {
		model.setLowerBound(10);
		assertTrue(model.checkHigherDifferance(20));
	}

	@Test
	public void testCheckLowerHigherWithOutOfRange() {
		model.setLowerBound(10);
		assertFalse(model.checkHigherDifferance(10));
	}

	@Test
	public void testCheckUserInputEndGame() {
		model.setRandomValue(20);
		model.checkUserInput(model.getRandomValue());
		assertTrue(model.isEndGame());
	}

	@Test
	public void testCheckUserInputHigher() {
		model.setRandomValue(20);
		assertSame(Constants.HIGHER, model.checkUserInput(15));
	}

	@Test
	public void testCheckUserInputCongratulations() {
		model.setRandomValue(20);
		assertSame(Constants.CONGRATULATIONS, model.checkUserInput(20));
	}

	@Test
	public void testCheckUserInputLower() {
		model.setRandomValue(20);
		assertSame(Constants.LOWER, model.checkUserInput(25));
	}
}
