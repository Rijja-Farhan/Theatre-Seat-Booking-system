import java.util.Scanner;

public class Reservation {
	public static void main(String args[]) {

	Tickets s = new Tickets();
		Scanner sc = new Scanner(System.in);
		int choice = 1;

		// ==MENU==//
		while (choice != 0) {
			System.out.println("===RESERVATION MENU===");
			System.out.println("Press 1 to book a ticket");
			System.out.println("Press 2 to cancel a ticket");
			System.out.println("Press 3 to check available tickets");
			System.out.println("Press 4 to check total revenue");
			System.out.printf("Press 0 to end the program %n %n");

			// choices of the user
			choice = sc.nextInt();
			if (choice == 1) {
				s.bookTicket();
			} 
			else if(choice==2) {
				s.cancelTicket();
			}
			else if (choice == 3) {
				s.displaySeats();
				
			} else if (choice == 4) {
				s.totalRevnue();
			}

		}

	}
	
}


