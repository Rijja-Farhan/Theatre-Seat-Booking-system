import java.time.*;
import java.util.Scanner;
public class Seats {
	private int price;
	private int seat_number;
	private String status;
	private int row_number;
	LocalDate date= LocalDate.now();
	LocalTime time= LocalTime.now();
	Scanner sc =new Scanner(System.in);
	
	
   //--constructor--
	public Seats(int price,int seat_number,String status,int row_number) {
		this.price=price;
		this.seat_number=seat_number;
		this.status=status;
		this.row_number=row_number;
	}
	

	
	//---getters---
	public int getSeatNumber() {
		return this.seat_number;
	}
	public int getPrice() {
		return this.price;
	}
	public String getStatus() {
		return this.status;
	}
	
	//---setters---
	public void setStatus(String status) {
		this.status=status;
	}
	
	
	
	//---display method---
	public void display() {
		System.out.println("price: "+price);
		System.out.println("Seat number: "+seat_number);
		System.out.println("Status: "+ status);
		System.out.println("row number: "+ row_number);
		
	}
	
	//---invoice method---
	public void invoice() {
		
		System.out.println("===DISPLAYING INVOICE==");
		System.out.println("Price of seat: "+ price);
		System.out.println("Seat number: "+ seat_number);
		System.out.println("Date: "+ date);
		System.out.println("Time: "+ time);
		System.out.println();
		
		
	}

}
