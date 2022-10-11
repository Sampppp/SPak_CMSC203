import java.util.Scanner;

public class MovieDriver2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		Movie obj = new Movie();
		
		boolean loop = false, error = false;
		
		do {
		System.out.print("Enter the title of the movie: ");
		obj.setTitle(in.next());
		System.out.print("Enter the movie's rating: ");
		obj.setRating(in.next());
		System.out.print("Enter the number of tickets sold at the theatre: ");
		obj.setSoldTickets(in.nextInt());
		
		System.out.println(obj.toString());
				
		do {
			error = false;
			System.out.print("\nDo you want to enter another movie? (y/n): ");

			switch(in.next().charAt(0)) {
			case 'Y':
			case 'y':
				loop = true;
				break;
			case 'N':	
			case 'n':
				loop = false;
				break;
			default:
				System.out.println("\nPlease enter a y/n");
				error = true;
				break;
			}
		} while(error);
		} while(loop);
		
		in.close();
		System.out.println("Goodbye");
	}
}
