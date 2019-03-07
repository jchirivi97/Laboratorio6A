package edu.eci.cvds.calculator;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.*;

import org.junit.Test;

import edu.eci.cvds.calculator.AirlineCalculator;
import edu.eci.cvds.model.BookingOutput;
import edu.eci.cvds.model.BookingResult;
import edu.eci.cvds.model.SeatCategory;

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

		qt()
		.forAll(integers().between(1,100),integers().between(1,3))
		.check((a,b) -> {
			SeatCategory category;
			if (b == 1 ) {
				category = SeatCategory.FIRST_CLASS;
			}
			else if (b == 2) {
				category = SeatCategory.ECONOMY_CLASS;
			} 
			else {
				category = SeatCategory.EMERGENCY_DOOR;
			}
			
			BookingOutput price = calculator.calculate(a, category);
			
			if (a > 15 && category == SeatCategory.FIRST_CLASS) {
				return price.getResult() == BookingResult.INVALID_SEATS; 
			}
			else if (a > 50 && category == SeatCategory.ECONOMY_CLASS) {
				return price.getResult() == BookingResult.INVALID_SEATS;
			}
			else if (a > 8 && category == SeatCategory.EMERGENCY_DOOR) {
				return price.getResult() == BookingResult.INVALID_SEATS;
			}
			else if (a <= 15 && category == SeatCategory.FIRST_CLASS) {
				return price.getResult() == BookingResult.SUCCESS; 
			}
			else if (a <= 50 && category == SeatCategory.ECONOMY_CLASS) {
				return price.getResult() == BookingResult.SUCCESS;
			}
			else if (a <= 8 && category == SeatCategory.EMERGENCY_DOOR) {
				return price.getResult() == BookingResult.SUCCESS;
			}
			
			return false;
			
		});
		
		
		
	}
}
