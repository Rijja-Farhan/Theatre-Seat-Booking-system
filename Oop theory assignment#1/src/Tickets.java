import java.util.Scanner;

public class Tickets {
	private int no_of_seats;
	private int revenue = 0;
	Scanner sc = new Scanner(System.in);
	private Seats[][] seat = new Seats[15][];
	
	//initializing prices
	int price[] = { 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000 ,1100,1200,1300,1400,1500};

	
	
	// ----constructor---//
	// first 10 rows have variable number of seats 
	// price of seats of row 1 is 100 and and its increased as row number increases

	public Tickets() {
		//there are 5 seats in 1st row and seats are increased as row number increases
		int j=5;
		//memory allocation of array using variable length of column
		for(int i = 0; i < seat.length-5; i++) {
			   seat[i] = new Seats[j+1];
			   j++;
			}
		
	    //last 5 rows have 15 seats each
		for(int i = 10; i < seat.length; i++) {
			   seat[i] = new Seats[j];
			  
			}
		
		
		//Initialization of array
		int counter = 0;
		j = 0;
		for (int i = 0; i < 15; i++) {
			for (j = 0; j <seat[i].length; j++) {
				seat[i][j] = new Seats(price[i], counter++, "available",i+1);
				
				no_of_seats++;
			}

		}

	}

	// ---displaying seats method---//
	public void displaySeats() {

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j <seat[i].length; j++) {
				seat[i][j].display();
				System.out.println();
				System.out.println();

			}

		}
		System.out.println("TOTAL AVAILABLE SEATS ARE: "+this.availableNumberOfSeats());
	}

	//---booking movie ticket method---
	public void bookTicket() {

		int no, ch;
		int seat_number;

		System.out.printf("How many tickets you want to book %n%n");
		no = sc.nextInt();
		//check if enough seats are available
		if (no <= this.availableNumberOfSeats()) {   
			System.out.printf("There are enough number of seats available for you %n%n");
			int counter = 0;
			while (counter != no) {
				System.out.printf("Enter number of seat which you want to book  %n%n");
				seat_number = sc.nextInt();
				//check if this seat number is available or no
				if((this.checkAvailability(seat_number)==true))
				{
					for (int i = 0; i < seat.length; i++) {
				
					for (int j = 0; j < seat[i].length; j++) {
						if (seat[i][j].getSeatNumber() == seat_number) {
							//prints invoice
							seat[i][j].invoice();
							System.out.println("You want to book or cancel");
							System.out.println("To continue booking press 1. To cancel press 0");
							ch = sc.nextInt();
							if (ch == 1) {
								seat[i][j] = new Seats(seat[i][j].getPrice(), seat[i][j].getSeatNumber(),
										"not available",i+1);
								System.out.println("TICKET BOOKED SUCCESSFULLY");
								
							} else if (ch == 0) {
								break;
							}

						}
					}

				}
				counter++;
			}
				else if(this.checkAvailability(seat_number)==false) {
					System.out.println("This number of seat is already booked choose another number");
				}
			}
			

		}
		//if enough seats are not present
		else if(no > this.availableNumberOfSeats()) {
			System.out.println("Enough seats are not present for you");
		}

	}
	
	
	
	//---total revenue method---
	public void totalRevnue() {
		for(int i=0;i<seat.length;i++) {
			for(int j=0;j<seat[i].length;j++) {
				if(seat[i][j].getStatus()=="not available") {
					revenue=revenue+seat[i][j].getPrice();
				}
			}
		}
		System.out.println("==Total revenue of cinema is "+ revenue+" ==");
		
	}
	
	
	
	//---total available seats method--
	public int  availableNumberOfSeats() {
		int counter=0;
		for(int i=0;i<seat.length;i++) {
			for(int j=0;j<seat[i].length;j++) {
				if(seat[i][j].getStatus()=="available") {
					counter++;
				}
			}
		}
		return counter;
		
		
	}
	
	
	
	//---check if seat is available or no---
	public boolean checkAvailability(int seatnumber ) {
		boolean t =true;
		for(int i=0;i<seat.length;i++) {
			for(int j=0;j<seat[i].length;j++) {
				if(seat[i][j].getSeatNumber()==seatnumber) {
					if(seat[i][j].getStatus()=="available") {
						t=true;
						
					}
					else if(seat[i][j].getStatus()=="not available") {
						t=false;
					}
				}
			}
		}
		return t;
	}
	
	
	
	
	
	
	//--method to cancel the ticket--
	public void cancelTicket() {
		int cancel_seat;
		System.out.println("Enter the seat number which you want to cancel");
		cancel_seat=sc.nextInt();
		for(int i=0;i<seat.length;i++) {
			for(int j=0;j<seat[i].length;j++) {
				if(seat[i][j].getSeatNumber()==cancel_seat) {
				 if(seat[i][j].getStatus()=="not available"){
					 seat[i][j].setStatus("available");
					 System.out.println("TICKET CANCELED SUCCESSFULLY");
				 }
				}
			}
		}
	}
}


