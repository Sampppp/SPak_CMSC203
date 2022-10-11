import java.util.Scanner;

public class MovieDriver {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);	
		
		Movie obj = new Movie();
		
		
		System.out.print("Enter the title of the movie: ");
		obj.setTitle(in.next());
		System.out.print("Enter the movie's rating: ");
		obj.setRating(in.next());
		System.out.print("Enter the number of tickets sold at the theatre: ");
		obj.setSoldTickets(in.nextInt());
		
		System.out.println(obj.toString());
		in.close();
		System.out.println("Goodbye");
	}
}
