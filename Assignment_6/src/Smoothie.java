
public class Smoothie extends Beverage {
	private int numOfFruits;
	private boolean addProtein;
	
	Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein){
		super(bevName, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
	}
	
	public int getNumOfFruits() { //return number of fruits
		return numOfFruits;
	}
	
	public boolean getAddProtein() { //Indicates whether or not protein is added
		return addProtein;
	}
	
	public String toString() { //returns the string representation of a Smoothie drink. Contains the name , size, whether or not protein added , number of fruits and price
		return String.format("%s, %s, %s, %s, $%.2f", getBevName(), getSize(), addProtein, numOfFruits, calcPrice());
	}
	
	
	public double calcPrice() { //calculates and returns the alcohol beverage price return price of alcohol beverage
		double total = getBasePrice() + addSizePrice();
		if(addProtein)
			total += 1.50;
		if(numOfFruits > 0)
			total += numOfFruits * 0.50;
		return total;
	}
	
	
	public boolean equals(Smoothie anotherBev) { //checks if this Beverage equals to anotherBev
		return (super.equals(anotherBev) && anotherBev.addProtein == addProtein && anotherBev.numOfFruits == numOfFruits);
	}
}
