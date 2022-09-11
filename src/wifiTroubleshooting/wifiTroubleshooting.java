/*
 * Class: CMSC203 
 * Instructor: David Kujit
 * Description: WiFi Diagnostics tool
 * Due: 09/12/2022
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Samson Pak
*/


package wifiTroubleshooting;

import java.util.Scanner;

public class wifiTroubleshooting {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in); //creates a scanner obj for user input

		String input; //variable for user input
		
		//header
		System.out.println("If you have a problem with internet connectivity, this WiFi diagnostics might work.\n");
		
		for(int i = 1; i <= 5; i++) { //loops through the 5 prompts
			switch(i) {
			case 1:
				System.out.println("Reboot the computer and try to connect\nDid that fix the problem? (Yes or No)");
				break;
			case 2:
				System.out.println("Reboot the router and try to connect\nDid that fix the problem? (Yes or No)");
				break;
			case 3:
				System.out.println("Make sure the cables connecting the router are firmly connectd and power is getting to the router\nDid that fix the problem? (Yes or No)");
				break;
			case 4:
				System.out.println("Move your computer closer to the router\nDid that fix the problem? (Yes or No)");
				break;
			case 5:
				System.out.println("Contact your ISP");
				continue; //Last prompt skips user input
			}
			input = console.next(); //user input
			//Tests input for a yes or no
			if (input.compareToIgnoreCase("Yes") == 0)
				break;
			else if (input.compareToIgnoreCase("No") == 0)
				continue;
			else { //If yes or no is not entered, error message and asks the question again
				System.out.println("\nPlease enter Yes or No\n");
				i--;
			}
		}
		console.close();
		
		System.out.println("\nDone"); //Program complete
		System.out.println("Programmer: Samson Pak");
	}

}
