package edu.eci.cvds.calculator;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.*;

import org.junit.Test;

import edu.eci.cvds.calculator.AirlineCalculator;

/**
 * Test class for {@linkplain AirlineCalculator} class
 */
public class AirlineCalculatorTest {

	/**
	 * The class under test.
	 */
	private AirlineCalculator calculator = new AirlineCalculator();

	/**
	 * {@inheritDoc}}
	 */
	@Test
	public void calculateTest() {

		calculator.calculate(null, null);
	}
}
