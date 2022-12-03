
public abstract class Beverage {
	private String bevName;
	private Type type;
	private Size size;
	
	final double BASEPRICE = 2.00;
	
	
	public Beverage(String bevName, Type type, Size size) {
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}
	
	abstract double calcPrice(); //Calculates the beverage price
	
	public double addSizePrice() { //Calculates a new price by adding the size price to the base price.
		switch(size) {
		case SMALL:
			return 0;
		case MEDIUM:
			return 1.0;
		case LARGE:
			return 2.0;
		default:
			return 0;			
		}
	}

	public boolean equals(Beverage anotherBev) { //Checks if this Beverage equals to anotherBev
		return(anotherBev.bevName == bevName && anotherBev.size == size && anotherBev.type == type);
	}
	
	public double getBasePrice() { //Gets the base price
		return BASEPRICE;
	}
	
	public String getBevName() { //Gets the name of the beverage
		return bevName;
	}
	
	public Size getSize() { //Gets the size of the beverage
		return size;
	}
	
	public Type getType() { //Gets beverage type
		return type;
	}
	
	public String toString() { //Represents a Beverage object in String with the format of bevName,size
		return String.format("%s, %s, %s", bevName, size, type);
	}
	
}
