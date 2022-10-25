
public class Property {

	//--Private fields--
	private String propertyName, city, owner;
	private double rentAmount;
	private Plot plot;
	
	//--Constructors--
	//Creates a new Property using empty strings.
	Property(){
		propertyName = "";
		city = "";
		owner = "";
		rentAmount = 0.0;
		plot = new Plot();
	}
	
	//Creates a new Property object using given values.
	Property(String propertyName, String city, double rentAmount, String owner){
		this.propertyName = propertyName;
		this.city = city;
		this.owner = owner;
		this.rentAmount = rentAmount;
		plot = new Plot();
	}
	
	//Creates a new Property object using given values.
	Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth){
		this.propertyName = propertyName;
		this.city = city;
		this.owner = owner;
		this.rentAmount = rentAmount;
		plot = new Plot(x, y, width, depth);
	}
	
	//Creates a new copy of the given property object.
	Property(Property otherProperty){
		this.propertyName = otherProperty.propertyName;
		this.city = otherProperty.city;
		this.owner = otherProperty.owner;
		this.rentAmount = otherProperty.rentAmount;
		plot = new Plot(otherProperty.plot);
	}
	
	//Gets the city.
	public String getCity() {
		return city;
	}
	
	//Gets the owner.
	public String getOwner() {
		return owner;
	}
	
	//Gets the plot.
	public Plot getPlot() {
		return plot;
	}
	
	//Gets the property name.
	public String getPropertyName() {
		return propertyName;
	}
	
	//Gets the rent amount.
	public double getRentAmount() {
		return rentAmount;
	}
	
	//Represents a Property object in the following String format: propertyName,city,owner,rentAmount
	public String toString() {
		return String.format("%s,%s,%s,%.1f",propertyName, city, owner, rentAmount);
	}
	
}
