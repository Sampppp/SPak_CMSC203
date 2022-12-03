
public class Coffee extends Beverage {
	private boolean extraShot;
	private boolean extraSyrup;
	
	Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup){ //Creates a Coffee object using the given values
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	public boolean getExtraShot() { //Indicates whether or not extra shot is added
		return extraShot;
	}
	
	public boolean getExtraSyrup() { //Indicates whether or not extra syrup is added
		return extraSyrup;
	}
	
	public double calcPrice() {
		double total = getBasePrice() + addSizePrice();
		if(extraShot)
			total += 0.50;
		if(extraSyrup)
			total += 0.50;
		return total;
	}
	
	public String toString() { //Represents a Coffee beverage in the following String format: name,size, whether it contains extra shot, extra syrup and the price
		return String.format("%s, %s, %s, %s, $%.2f", getBevName(), getSize(), extraShot, extraSyrup, calcPrice());
	}
	
	public boolean equals(Coffee anotherBev) { //Checks if this Beverage equals to anotherBev
		return (super.equals(anotherBev) && anotherBev.extraShot == extraShot && anotherBev.extraSyrup == extraSyrup);
	}
	
}
