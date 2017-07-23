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
	public void testDefaultRandom() {
		int randomValue = model.random(0, 100);
		assertTrue(randomValue > 0 && randomValue < 100);
	}
	
	@Test
	public void testEnteredRandom() {
		int randomValue = model.random(15, 60);
		assertTrue(randomValue > 15 && randomValue < 60);
	}
	
	@Test
	public void testWrongRandom() {
		int randomValue = model.random(-25, 25);
		assertTrue(randomValue > -25 && randomValue < 25);
	}

}
