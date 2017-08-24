import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;

import controller.exceptions.IllegalSearchArguments;
import dao.individual.IndividualDAO;
import dao.property.PropertyDAO;
import model.entity.derivative.Derivative;
import model.entity.responsibility.Responsibility;
import model.service.DerivativeUtil;

public class DerivativeUtilTest {
	Derivative derivative = new Derivative(new IndividualDAO(), new PropertyDAO());
	DerivativeUtil derivativeUtil = new DerivativeUtil(derivative);
	
	@Test(expected = IllegalSearchArguments.class)
	public void findByOutOfRangeValues() throws IllegalSearchArguments{
		derivativeUtil.findByRiskRateAndPrice(derivativeUtil.getAllReponsibilities(), -1, 101, new BigDecimal(-1), new BigDecimal(-100));
	}
	
	@Test(expected = NullPointerException.class)
	public void summaryNull() throws IllegalSearchArguments{
		derivativeUtil.getSummaryPrice(null);
	}
	
	@Test(expected = NullPointerException.class)
	public void findNull() throws IllegalSearchArguments{
		derivativeUtil.findByRiskRateAndPrice(null, 15, 16, new BigDecimal(2000), new BigDecimal(15000));
	}
	@Test(expected = NullPointerException.class)
	public void orderNull() throws IllegalSearchArguments{
		derivativeUtil.orderByRiskLevel(null);
	}
	
	@Test
	public void correctSearch() throws IllegalSearchArguments{
		List<Responsibility> actual = derivativeUtil.findByRiskRateAndPrice(derivativeUtil.getAllReponsibilities(), 15, 16, new BigDecimal(2000), new BigDecimal(15000));
		String expected = "Accident";
		assertEquals(expected, actual.get(0).getTitle());
	}
	
	@Test 
	public void summaryCorrectly() throws IllegalSearchArguments{
		List<Responsibility> allResponsibilities = derivativeUtil.getAllReponsibilities();
		BigDecimal actualSum = derivativeUtil.getSummaryPrice(allResponsibilities);
		BigDecimal expectedSum = new BigDecimal(118311.55);
		assertTrue(expectedSum.setScale(2, BigDecimal.ROUND_DOWN).compareTo(actualSum) == 0);
	}
	
	
	
}
