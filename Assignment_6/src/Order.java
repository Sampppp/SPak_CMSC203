import java.util.ArrayList;
public class Order implements OrderInterface, Comparable<Order> {
	private int orderTime;
	private Day orderDay;
	private Customer cust;
	
	ArrayList<Beverage> bev = new ArrayList<Beverage>();
	
	private int orderNo = 10000;
	
	public Order(int orderTime, Day orderDay, Customer cust){
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = cust;
	}
	
	public Order(Order copy) {
		orderTime = copy.orderTime;
		orderDay = copy.orderDay;
		cust = new Customer(copy.cust);
		
		bev.addAll(copy.bev);
		
		orderNo = copy.orderNo;
	}
	
	public int generateOrder() { //Automatically generate order number
		return orderNo++;
	}
	
	public int getOrderNo() { //returns the order number
		return orderNo;
	}
	
	public int getOrderTime() { //returns the order time
		return orderTime;
	}
	
	public Day getOrderDay() { //returns the order day
		return orderDay;
	}
	
	public Customer getCustomer() {
		return cust;
	}
	
	/* WHY DOES THIS EXIST!?!
	public Day getDay() { //return order day (MONDAY, TUESDAY.....,SUNDAY)
		return orderDay;
	}
	*/
	
	public boolean isWeekend() {
		return (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY);
	}
	
	public Beverage getBeverage(int itemNo) {
		try {
			return bev.get(itemNo);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public int getTotalItems() { //returns the total number of beverages ordered within this order
		return bev.size();
	}
	
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		bev.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}

	public void addNewBeverage(String bevName, Size size) {
		bev.add(new Alcohol(bevName, size, isWeekend()));
	}
	
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		bev.add(new Smoothie(bevName, size, numOfFruits, addProtein));
	}
	
	public double calcOrderTotal() {
		double total = 0;
		for(int i = 0; i < bev.size(); i++) {
			total += bev.get(i).calcPrice();
		}
		return total;
	}
	
	public int findNumOfBeveType(Type type) {
		int count = 0;
		for(int i = 0; i < bev.size(); i++) {
			if(bev.get(i).getType() == type)
				count++;
		}
		return count;
	}
	
	public String toString() { //String representation of the order, Includes order number, time , day, customer name and age and the list of beverages
		String bevList = "";
		for(int i = 0; i < bev.size(); i++) {
			bevList += bev.get(i).toString() + "\n";
		}
		return String.format("Order#: %d\nTime: %d\nDay: %s\n%s\n%s",orderNo, orderTime, orderDay, cust.toString() ,bevList);
	}

	public int compareTo(Order anotherOrder) {
		if(anotherOrder.orderNo < orderNo)
			return -1;
		if(anotherOrder.orderNo > orderNo)
			return 1;
		return 0;
	}


	
}
