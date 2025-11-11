package library_management_system;

// Library management system -> console based application
// Features -> add book, view books, issue book, return book, exit

import java.util.*;

class book {
	int id;
	String title;
	String author;
	boolean isissued;
	
	book(int id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.isissued = false;
	}

}

public class librarymanagementsystem {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<book> books = new ArrayList<>();
	static int bookidcounter = 1;
	
	public static void main(String args[]) {
		while(true) {
			System.out.println(" ---- LIBRARY MANAGEMENT SYSTEM ---- ");
			System.out.println(" 1. ADD BOOK ");
			System.out.println(" 2. VIEW BOOKS ");
			System.out.println(" 3. ISSUE BOOK ");
			System.out.println(" 4. RETURN BOOK ");
			System.out.println(" 5. EXIT ");
			System.out.println(" ENTER YOUR CHOICE : ");
			int choice = sc.nextInt();
			sc.nextLine(); //consume newline
			
			switch(choice) {
			case 1 : addbook();
			break;
			case 2 : viewbook();
			break;
			case 3 : issuebook();
			break;
			case 4 : returnbook();
			break;
			case 5 : 
				System.out.println(" EXITING.... THANK YOU!!");
				return;
			default :  System.out.println(" INVALID CHOICE.. TRY AGAIN..");
			}
		}
	}
	
	static void addbook() {
		System.out.println(" ENTER BOOK TITLE : ");
		String title = sc.nextLine();
		System.out.println(" ENTER AUTHOR NAME : ");
		String author = sc.nextLine();
		books.add(new book(bookidcounter++, title, author));
		System.out.println(" BOOK ADDED SUCCESSFULLY....");
	}
	
	static void viewbook() {
		if(books.isEmpty()) {
			System.out.println("NO BOOKS AVAILABLE..");
			return;
		}
		System.out.println("\n AVAILABLE BOOKS....");
		for(book b : books) {
			System.out.println(" Id : " + b.id + ", Title : " + b.title + ", Author : " + b.author + ",Issued : " + b.isissued);
		}
	}
	
	static void issuebook() {
		System.out.println(" ENTER BOOK ID TO ISSUE : ");
		int id=sc.nextInt();
		for(book b:books) {
			if(b.id == id) {
				if(!b.isissued) {
					b.isissued = true;
					System.out.println(" BOOK ISSUED SUCCESSFULLY..");
				} else {
					System.out.println(" BOOK ALREADY ISSUED..");
				}
				return;
			}
		}
		System.out.println(" BOOK ID NOT FOUND..");
	}
	
	static void returnbook() {
		System.out.println(" ENTER BOOK ID TO RETURN : ");
		int id = sc.nextInt();
		for(book b : books) {
			if(b.id == id) {
				if(!b.isissued) {
					b.isissued = false;
					System.out.println(" BOOK RETURNED SUCCESSFULLY..");
				} else {
					System.out.println(" THE BOOK WAS NOT ISSUED..");
				}
				return;
			}
		}
		System.out.println(" BOOK ID NOT FOUND ");
	}
}