/*
 * Class: CMSC203 
 * Instructor: David Kuijt
 * Description: BevShop is the storefront, Order is the order data, Beverage and it's subclasses are the product
 * Due: 12/02/2022
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Samson Pak
*/

public class BevShopDriverApp {

	public static void main(String[] args) {
		final Day today = Day.MONDAY;
		final int time = 9;
		
		BevShop shop = new BevShop();
		Customer Joe = new Customer("Joe", 22);
		
		
		System.out.println("Start a new order");
		shop.startNewOrder(time, today, Joe.getName(), Joe.getAge());
		System.out.println(shop.getCurrentOrder().toString());
		
		System.out.println("Adding alcohol...");
		shop.processAlcoholOrder("funky drink", Size.LARGE);
		
		System.out.println("Adding alcohol...");
		shop.processAlcoholOrder("wacky drink", Size.MEDIUM);
		
		System.out.println("Adding alcohol...");
		shop.processAlcoholOrder("wonky drink", Size.SMALL);
		
		
		System.out.println("Adding alcohol...");
		shop.processAlcoholOrder("crazy drink", Size.LARGE);
		
		
		System.out.printf("\nAdding a %s to order...\n", Type.COFFEE);
		shop.processCoffeeOrder("mocha", Size.SMALL, false, false);
		
		System.out.printf("\nAdding a %s to order...\n", Type.SMOOTHIE);
		shop.processSmoothieOrder("zaza juice", Size.LARGE, 30, true);
		
		System.out.println(shop.getCurrentOrder().toString());
		System.out.printf("\nYour order total is : $%.2f", shop.getCurrentOrder().calcOrderTotal());
	}

}
