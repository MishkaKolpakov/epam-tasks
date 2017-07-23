package epam.com.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.epam.Model;

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
		assertTrue(model.checkRange(50));
	}

	@Test
	public void testCheckLowerRange() {
		assertFalse(model.checkRange(0));
	}

	@Test
	public void testCheckHigherRange() {
		assertFalse(model.checkRange(100));
	}
}
