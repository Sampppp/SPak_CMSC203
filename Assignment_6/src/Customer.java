
public class Customer {
	private String name;
	private int age;
	
	public Customer(String name, int age){ //Constructor
		this.name = name;
		this.age = age;
	}
	public Customer(Customer c) {
		name = c.name;
		age = c.age;
	}
	
	public int getAge() { //get method for age
		return age;
	}
	
	public void setAge(int age) { //Set method for age
		this.age = age;
	}
	
	
	public String getName() { //get method for name
		return name;
	}
	
	
	public void setName(String name) { //set method for name
		this.name = name;
	}
	
	
	public String toString() { //String representation of the customer includes the name and age of the customer.
		return String.format("Name: %s\nAge:%d\n", name, age);
	}
	
}
