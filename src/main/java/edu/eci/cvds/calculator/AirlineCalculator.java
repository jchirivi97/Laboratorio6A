package edu.eci.cvds.calculator;

import java.util.Optional;

import edu.eci.cvds.model.SeatCategory;
import edu.eci.cvds.model.BookingOutput;
import edu.eci.cvds.model.BookingResult;

/**
 * Utility class to validate an airline's booking
 */
public class AirlineCalculator implements BookingCalculator {

	/**
	 * {@inheritDoc}}
	 */
	@Override
	public BookingOutput calculate(Integer seatsNumber, SeatCategory category) {

		// TODO: Add required validations and calculate total price if applies
		if (SeatCategory.ECONOMY_CLASS.equals(category)) {
			return new BookingOutput(BookingResult.SUCCESS, Optional.of(seatsNumber * category.getPrice()));

		} else {

			return new BookingOutput(BookingResult.NOT_ENOUGH_SEATS, Optional.empty());
		}
	}
}
