/*
 * Class: CMSC203 
 * Instructor: David Kujit
 * Description: A property managing tool to keep track of plots, rent, and fees
 * Due: 10/24/2022
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Samson Pak
*/
public class ManagementCompany {
	
	//--Constant fields--
	public static final int 
	MAX_PROPERTY = 5,
	MGMT_DEPTH = 10,
	MGMT_WIDTH = 10;
	
	//--Private fields--
	private String name, taxID;
	private double mgmFee;
	private Property[] properties;
	private Plot plot;
	private int numberOfProperties;
	
	//--Constructors--
	//Creates a ManagementCompany object using empty strings 
	//creates a default Plot with maximum width and depth and it initializes the properties array.
	ManagementCompany(){
		name = "";
		taxID = "";
		mgmFee= 0.0;
		
		properties = new Property[MAX_PROPERTY];
		for(int i = 0; i < MAX_PROPERTY; i++) {
			properties[i] = new Property();
		}
		
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		numberOfProperties = 0;
	}
	
	//Creates a ManagementCompany object using the given values
	//creates a default Plot with maximum width and depth and it initializes the properties array.
	ManagementCompany(String name, String taxID, double mgmFee){
		this.name = name;
		this.taxID = taxID;
		this.mgmFee= mgmFee;

		properties = new Property[MAX_PROPERTY];
		for(int i = 0; i < MAX_PROPERTY; i++) {
			properties[i] = new Property();
		}
		
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		numberOfProperties = 0;
	}
	
	//Creates a ManagementCompany object using the given values
	//creates a Plot using the given values and it initializes the properties array.
	ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth){
		this.name = name;
		this.taxID = taxID;
		this.mgmFee= mgmFee;

		properties = new Property[MAX_PROPERTY];
		for(int i = 0; i < MAX_PROPERTY; i++) {
			properties[i] = new Property();
		}
		
		plot = new Plot(x, y, width, depth);
		numberOfProperties = 0;
	}
	
	//Creates a new ManagementCompany copy of the given ManagementCompany.
	ManagementCompany(ManagementCompany otherCompany){
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFee= otherCompany.mgmFee;
		
		for(int i = 0; i < otherCompany.properties.length; i++) {
			this.properties[i] = new Property(otherCompany.properties[i]);
		}
		
		this.plot = new Plot(otherCompany.plot);
		this.numberOfProperties = otherCompany.numberOfProperties;
	}
	
	//--Methods--
	//Adds a new property to the properties array, this method should call an appropriate existing overloaded method.
	public int addProperty(String name, String city, double rent, String owner) {
		return addProperty(new Property(name, city, rent, owner));
	}
	
	//Adds a new property to the properties array, this method should call an appropriate existing overloaded method.
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
	}
	
	//Creates a property object by copying from another property and adds it to the properties array.
	public int addProperty(Property property) {
		//if the array is full
		if(isPropertiesFull())
			return -1;
		
		//if the Property object is null
		if(property == null)
			return -2;
		
		properties[numberOfProperties] = new Property(property); 	//if space is available and data is valid, property is added to array
		
		//if management company does not encompass the property plot
		if(!plot.encompasses(properties[numberOfProperties].getPlot())) {
			properties[numberOfProperties] = null; 	//property is reset
			return -3;
		}
		
		//if property plot overlaps ANY of properties in array
		for(int i = 0; i < numberOfProperties; i++) {
			if(properties[numberOfProperties].getPlot().encompasses(properties[i].getPlot())) {
				properties[numberOfProperties] = null; 	//property is reset
				return -4;
			}	
		}
					
		//if space is available, passed data is valid, property is within mgmCo's plot, and property doesn't overlap anyother property, property is kept and index increments
		numberOfProperties++;
		
		//return the index of the array where the property was added
		return (numberOfProperties - 1); 	//returns the index
	}
	
	//Removes(nullifies) the LAST property in the properties array
	public void removeLastProperty() {
		properties[numberOfProperties] = null;
	}
	
	//Checks if the properties array has reached the maximum capacity
	public boolean isPropertiesFull() {
		if(numberOfProperties == MAX_PROPERTY)
			return true;
		else
			return false;
	}
	
	//Gets the number of existing properties in the array
	public int getPropertiesCount() {
		return numberOfProperties;
	}
	
	
	//Returns the total rent of the properties in the properties array *
	public double getTotalRent() {
		double temp = 0.0;
		for(int i = 0; i < properties.length; i++) {
			temp += properties[i].getRentAmount();
		}
		return temp;
	}
	
	//Gets the property in the array with the maximum amount of rent
	public Property getHighestRentPropperty() {
		double temp = 0.0;
		int index = 0;
		for(int i = 0; i < numberOfProperties; i++) {
			if(temp < properties[i].getRentAmount()) {
				temp = properties[i].getRentAmount();
				index = i;
			}
		}
		return properties[index];
	}
	
	//Checks if the management company has a valid (between 0-100) fee
	public boolean isMangementFeeValid() {
		if(mgmFee < 0 || mgmFee > 100)
			return false;
		return true;
	}	
	
	//Gets the name.
	public String getName() {
		return name;
	}
	
	//Gets the tax ID.
	public String getTaxID() {
		return taxID;
	}	
	
	//Gets the properties.
	public Property[] getProperties() {
		return properties;
	}
	
	//Gets the management fee per.
	public double getMgmFeePer() {
		return mgmFee;
	}	
	
	//Gets the plot.
	public Plot getPlot() {
		return plot;
	}

	//Represents the information of all the properties in the properties array.
	public String toString() {
		double totalMgmFee = 0.0;
		for(int i = 0; i < numberOfProperties; i++) {
			totalMgmFee += (mgmFee / 100.0) * properties[i].getRentAmount();
		}
		
		String temp  = String.format("List of the properties for %s, taxID: %s", name, taxID);
		temp += "\n______________________________________________________\n";
		
		int i = 0;
		for(; i < numberOfProperties; i++) {
			if(properties[i] == null)
				break;
			temp += properties[i].toString() + "\n";
		}
		
		temp += "______________________________________________________\n";
		temp += String.format("total management Fee: %.1f", totalMgmFee);

		return temp;
	}
}