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
	
	public int candsillas = 100;
	public float pricediscount = 0;
	public float pricetotal = 0;
	
	
	@Override
	public BookingOutput calculate(Integer seatsNumber, SeatCategory category) {

		// TODO: Add required validations and calculate total price if applies
		if (SeatCategory.ECONOMY_CLASS.equals(category) && candsillas >= 1 && seatsNumber <= 50) {
			System.out.println("las sillas y sillas total: "+ Integer.toString(seatsNumber)+" : "+ Integer.toString(candsillas));
			candsillas -=  seatsNumber;
			pricetotal = (seatsNumber * category.getPrice()) - discount(seatsNumber,category);
			return new BookingOutput(BookingResult.SUCCESS, Optional.of(pricetotal));

		}
		else if(SeatCategory.FIRST_CLASS.equals(category) && candsillas >= 1 && seatsNumber <= 15 ) {
			candsillas -=  seatsNumber;
			pricetotal = (seatsNumber * category.getPrice()) - discount(seatsNumber,category);
			return new BookingOutput(BookingResult.SUCCESS, Optional.of(pricetotal));
		}
		else if(SeatCategory.EMERGENCY_DOOR.equals(category) && candsillas >= 1 && seatsNumber <= 8 ) {
			candsillas -=  seatsNumber;
			pricetotal = (seatsNumber * category.getPrice()) - discount(seatsNumber,category);
			return new BookingOutput(BookingResult.SUCCESS, Optional.of(pricetotal));
		}
		else {
			if (candsillas == 0 ) {
				candsillas = 100;
			return new BookingOutput(BookingResult.NOT_ENOUGH_SEATS, Optional.empty());
			}
			else {
				return new BookingOutput(BookingResult.INVALID_SEATS, Optional.empty());
			}
		}
		
	}
	
	public float discount(Integer seatsNumber, SeatCategory category ) {
		if (seatsNumber > 5 ) {
			pricediscount = (float) (category.getPrice() * 0.02);
			return pricediscount;
			
		}
		else if (seatsNumber >= 10) {
			pricediscount = (float) (category.getPrice() * 0.1);
			return pricediscount;
		}
		else if (seatsNumber >= 15) {
			
			pricediscount = (float) (category.getPrice() * 0.2);
			return pricediscount;
		}
		else {
			return pricediscount;
		}
	}
}