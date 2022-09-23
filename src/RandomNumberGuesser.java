import java.util.Scanner;
import java.lang.Math;

public class RandomNumberGuesser {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		RNG.resetCount();

		System.out.println("This application generates a random integer between 0 and 100 and asks the user to guess repeatedly until they guess correctly.");
		
		int input, low = 0, high = 0, randomNumber = 0;
		boolean tryAgain, error;
		
		for(; RNG.getCount() < 7;) {
			do {
				tryAgain = false;
				if (RNG.getCount() == 0) {
					low = 0;
					high = 100;
					randomNumber = RNG.rand();
					System.out.print("Enter your first guess:\n");
				}
				else
					System.out.printf("Enter your next guess between %d and %d\n",low, high);
				do {
				input = in.nextInt();
				}while(!RNG.inputValidation(input, low, high));
				if(input == randomNumber) {	//
					System.out.println("Congradulations, you guessed correctly");
					do {
						System.out.println("Try again? (yes or no)");
						error = false;
						switch(in.next()) {
						case "yes":
						case "Yes":
							tryAgain = true;
							RNG.resetCount();
							break;
						case "no":
						case "No":
							tryAgain = false;
							System.out.println("Thanks for playing...");
							in.close();
							System.exit(0);
						default:
							System.out.println("Please enter yes or no");
							error = true;
							break;
						}
					}while(error);
				}
				else if(input < randomNumber) {	//
					System.out.println("your guess is too low");
					low = input;
					System.out.println("Number of guesses is: " + RNG.getCount());
				}
				else if (input > randomNumber) {
					System.out.println("your guess is too high");
					high = input;
					System.out.println("Number of guesses is: " + RNG.getCount());
				}
			}while(tryAgain);
		}
		System.out.println("You have exceeded the maximum number of guesses, 7. Try again.");
		in.close();
		System.exit(0);
	}
}
