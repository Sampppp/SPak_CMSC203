import java.util.ArrayList;
public class BevShop implements BevShopInterface {
	private int numOfAlcoholDrink = 0;
	
	ArrayList<Order> orders = new ArrayList<Order>();
	
	public BevShop() {
	}
	
	public boolean isValidTime(int time) {
		return (time >= MIN_TIME && time <= MAX_TIME);
	}

	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}

	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	public boolean isMaxFruit(int numOfFruits) {
		return (numOfFruits == MAX_FRUIT);
	}

	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	public boolean isEligibleForMore() {
		return (numOfAlcoholDrink < MAX_ORDER_FOR_ALCOHOL);
	}

	
	public int getNumOfAlcoholDrink() {
		return numOfAlcoholDrink;
	}

	public boolean isValidAge(int age) {
		return (age >= MIN_AGE_FOR_ALCOHOL);
	}

	
	public int findOrder(int orderNo) {
		for(int i = 0; i < orders.size(); i++) {
			if(orderNo == orders.get(i).getOrderNo())
				return i;
		}
		return -1;
	}

	public double totalOrderPrice(int orderNo) {
		return orders.get(findOrder(orderNo)).calcOrderTotal();
	}

	public double totalMonthlySale() {
		double total = 0;
		for(int i = 0; i < orders.size(); i++) {
			total += orders.get(i).calcOrderTotal();
		}
		return total;
	}

	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}

	public Order getCurrentOrder() {
		return orders.get(orders.size() - 1);
	}

	public Order getOrderAtIndex(int index) {
		try{
			return orders.get(index);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

	public void sortOrders() { //Would be nice if the type of sort was stated
		for(int i = 0; i < orders.size() - 1; i++) { //sorted by order total
			int min_index = i;
			for(int j = i + 1; j < orders.size(); j++) {
				if(orders.get(j).calcOrderTotal() < orders.get(min_index).calcOrderTotal())
					min_index = j;
				
				//deep copy swap
				Order temp = new Order(orders.get(min_index));
				orders.set(min_index, new Order(orders.get(i)));
				orders.set(i, new Order(temp));
			}
		}
	}

	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		orders.add(new Order(time, day, new Customer(customerName, customerAge)));
	}

	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		getCurrentOrder().bev.add(new Coffee(bevName, size, extraShot, extraSyrup));
		System.out.println("Drink added.\n");
	}

	public void processAlcoholOrder(String bevName, Size size) { //Where is isWeekend param?
		if(isEligibleForMore()) {
			getCurrentOrder().bev.add(new Alcohol(bevName, size, false)); //set @param to false
			numOfAlcoholDrink++;
			System.out.println("Drink added.\n");
		}
		else
			System.out.println("Maximum alcohol drink for this order");
	}

	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		getCurrentOrder().bev.add(new Smoothie(bevName, size, numOfFruits, addProtein));
		System.out.println("Drink added.\n");
	}

}
