
public class Alcohol extends Beverage {
	private boolean isWeekend = false; //whether the beverage is offered in the weekend false otherwise
	
	public Alcohol(String bevName, Size size, boolean isWeekend) { //Creates an Alcohol object using given values
		super(bevName,Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}
	
	public double calcPrice() { //Calculates the price of the alcohol
		double total = getBasePrice() + addSizePrice();
		if(isWeekend) {
			total += 0.60;
		}
		return total;
	}
	
	public boolean equals(Alcohol anotherBev) { //Checks if this Beverage equals to anotherBev
		return (super.equals(anotherBev) && anotherBev.isWeekend == isWeekend);
	}
	
	public String toString() { //String representation of Alcohol beverage, includes the name, size, whether or not beverage is offered in weekend and the price
		return String.format("%s, %s, %s, $%.2f", getBevName(), getSize(), isWeekend, calcPrice());
	}
}