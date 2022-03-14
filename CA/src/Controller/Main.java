package Controller;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


import Model.Books;
import Model.Borrowings;
import Model.BubbleSort;
import Model.LinearSearch;
import Model.Reader;

public class Main {
/*Here I initiatied the variables I will need in the main file
 * I chose to have 2 different scanners for input so the main loop is not affected by input in the IF statements 
 * */
	Scanner sc = new Scanner(System.in);
	Scanner sc2 = new Scanner(System.in);
	LoadFiles lf = new LoadFiles();
	LinearSearch ls = new LinearSearch();
	BubbleSort bs = new BubbleSort();
	
	private int chooser = -1;
	private String input;
	private String input2;
	
	//As I am using FileReader, the main method required a try-catch in case there was an exception of file not found.
	public static void main(String[] args) {		
    try {
		new Main();
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	}
	
	//Here I loaded the arrays that are read from the files, Books, Readers and borrowings
	public Main() throws FileNotFoundException {				

		ArrayList<Books> arrayBooks = lf.loadBooks();
		ArrayList<Reader> arrayReader = lf.loadReader();
		ArrayList<Borrowings> arrayBorrowings = lf.loadBorrowings2();
		
		//A method to display the menu
		displayOptions();
		//A menu to promt the user for a number, used to choose what action the user wants to perform
		chooseValue();
				
		do {	
					
		//Search for a specific book by title and/or author name.
		/*
		 * This part of the program prompts the user for a title or author of a book, then the array is sorted using the BubbleSort method and finds the
		 * desired book using the LinearSearch method for books
		 * */	
		if(chooser == 1) {
					
		System.out.println("Enter the title of the book or author name");
					
		input2 = sc2.nextLine();				
					
		bs.bubbleSortByID(arrayBooks);	
					
		if(ls.linearSearchBook(arrayBooks, input2) != -1) {
						
		System.out.println(arrayBooks.get(ls.linearSearchBook(arrayBooks, input2)));	
					
		}								
					
		chooser = -1;
		displayOptions();
		chooseValue();
		}
				
		//List all books by title and/or author name in alphabetical order
		/*
		 * This part of the program asks the user if they want to sort the array of books by title or author, then
		 * sorts the array by the chosen category and prints the whole array.
		 * There is a validation loop that will prompt the user for a valid category if the user does not type author or title
		 * */		
				else if (chooser == 2) {					
					
				
					System.out.println("Sort books by title or author?");
					input2 = sc2.nextLine();
					
				while(!input2.equalsIgnoreCase("author") && !input2.equalsIgnoreCase("title")) {
					System.out.println("Invalid input, choose between author and title");
					input2 = sc2.nextLine();
					}
					
					if(input2.equalsIgnoreCase("author")) {
						
						bs.bubbleSortByAuthor(arrayBooks);
						System.out.println(arrayBooks);
						
					}
					else if(input2.equalsIgnoreCase("title")){
						
						bs.bubbleSortByTitle(arrayBooks);
						System.out.println(arrayBooks);}
				
					
					
						
					chooser = -1;
					displayOptions();
					chooseValue();
				}
					

					
					
				
				
				//Search for a specific reader by name and/or ID.
				/*
				 * In this part the user is asked for an ID or a name of a reader
				 * if the typed name or ID is in the array, then the program sorts the array using the BubbleSort method and
				 * finds the reader using the LinearSearch method, then the reader is printed to the console
				 * */
				else if (chooser == 3) {
				
					System.out.println("Enter the ID or name of the reader");					
					
					input2 = sc2.nextLine();				
					bs.bubbleSortReaderByID(arrayReader);
						
					
					if(ls.linearSearchReader(arrayReader, input2) != -1) {
						
					System.out.println(arrayReader.get(ls.linearSearchReader(arrayReader, input2)));	
					
					}					
					
					chooser = -1;
					displayOptions();
					chooseValue();
				}
					
				
				
				//List all readers by alphabetical and/or ID order.
				/*
				 * This part of the program will ask the user to choose a category to sort the array
				 * ID or name, if the input is correct the array is sorted using the BubbleSort method
				 * and printed in the console
				 * */
				else if (chooser == 4) {
					
					System.out.println("Sort readers by ID or name?");
					input2 = sc2.nextLine();
					
				while(!input2.equalsIgnoreCase("ID") && !input2.equalsIgnoreCase("name")) {
					System.out.println("Invalid input, choose between ID and name");
					input2 = sc2.nextLine();
					}
				if(input2.equalsIgnoreCase("ID")) {
					bs.bubbleSortReaderByID(arrayReader);
					System.out.println(arrayReader);
					}
				if(input2.equalsIgnoreCase("name")) {
					bs.bubbleSortReaderByName(arrayReader);
					System.out.println(arrayReader);
				}
					
					
					chooser = -1;
					displayOptions();
					chooseValue();
					
				}
				
				
				
				//Register that a reader has borrowed a book.
				/*
				 * This part asks the user to enter the ID or name of the reader then the title of the book that is being borrowed
				 * if both exist, I get the ID of the reader and the ID of the book, then add them to the
				 * borrowings array and rewrite to the file the whole array
				 * */
				else if (chooser == 5) {
					
					System.out.println("Please enter the name or ID of the reader");
					input2 = sc2.nextLine();
					bs.bubbleSortReaderByID(arrayReader);
					int result = ls.linearSearchReader(arrayReader, input2);
					
					
					System.out.println("Please enter the title or ID of the book");
					input2 = sc2.nextLine();
					bs.bubbleSortByID(arrayBooks);
					int result2 = ls.linearSearchBook(arrayBooks, input2);
					
					
					if( result != -1 && result2 != -1) {
						
						arrayBorrowings.add(new Borrowings(arrayReader.get(result).getID(), arrayBooks.get(result2).getID()));
						
						
						
						try {
							
							// Need to use the array of borrowings to rewrite the whole file
							FileWriter myWriter = new FileWriter("borrowings.txt");
							for ( Borrowings br: arrayBorrowings) {
								myWriter.write(br.toString());
								myWriter.write(System.lineSeparator());
								
							}
							myWriter.close();
							System.out.println("Book borrowed");
							} 
							catch (IOException e) {
								
							      System.out.println("An error occurred.");
							      e.printStackTrace();
							      
							    }
						
					}
					
					
					chooser = -1;
					displayOptions();
					chooseValue();
					
				}
				//Add reader to the queue if a book is already booked
				/*Did not manage to get the queues working*/
				else if (chooser == 6) {
					
					System.out.println("6");
					chooser = -1;
					displayOptions();
					chooseValue();
				}
				//Register that a reader has returned a book.
		/*
		 * This part asks the user to enter the ID or name of the reader then the title of the book that is being revoked
		 * if both exist, I get the ID of the reader and the ID of the book, then use it to find the respective book and reader and remove them from the
		 * borrowings array and rewrite to the file the whole array
		 * */
				else if (chooser == 7) {
					
					
					System.out.println("Please enter the name or ID of the reader returning a book");
					
					input2 = sc2.nextLine();
					bs.bubbleSortReaderByID(arrayReader);
					int result = ls.linearSearchReader(arrayReader, input2);
					
					
					System.out.println("Please enter the title or ID of the book being returned");
					input2 = sc2.nextLine();
					bs.bubbleSortByID(arrayBooks);
					int result2 = ls.linearSearchBook(arrayBooks, input2);
					
					
					if( result != -1 && result2 != -1) {
						System.out.println(arrayBorrowings);
						int search = ls.linearSearchBorrowing(arrayBorrowings, arrayReader.get(result).getID(), arrayBooks.get(result2).getID());
						if(search != -1) {
							arrayBorrowings.remove(arrayBorrowings.get(search));
							try {
								
								// Need to use the array of borrowings to rewrite the whole file
								FileWriter myWriter = new FileWriter("borrowings.txt");
								for ( Borrowings br: arrayBorrowings) {
									myWriter.write(br.toString());
									myWriter.write(System.lineSeparator());
									
								}
								myWriter.close();
								System.out.println("Book returned");
								} 
								catch (IOException e) {
									
								      System.out.println("An error occurred.");
								      e.printStackTrace();
								      
								    }
							
						}
						
						
						
					}
					
					
					chooser = -1;
					displayOptions();
					chooseValue();
					
				}
				//If a book is returned and has a waiting queue, display to the user the next reader waiting for that book.
				/*
				 * Did not manage to get the queues working
				 * */
				else if (chooser == 8) {
					System.out.println("8");
					chooser = -1;
					displayOptions();
					chooseValue();
					
				}
				//For a specific reader, list the books that they have borrowed
				/*
				 * This part asks the user to enter the ID or name of a reader, finds all the books that are currently borrowed
				 * by that user in the borrowings array and prints them 
				 * */
		
				else if (chooser == 9) {
				System.out.println("Enter the name or ID of the reader");
				input2 = sc2.nextLine();
				ArrayList<Books> books = new ArrayList<>();
				
				bs.bubbleSortReaderByID(arrayReader);
				int result = ls.linearSearchReader(arrayReader, input2);
				
				if(result != -1) {
					int readerID = arrayReader.get(result).getID();
				for(Borrowings br: arrayBorrowings)
				{
					if(br.getReaderID() == readerID) {
						books.add(arrayBooks.get(ls.linearSearchBook(arrayBooks, String.valueOf(br.getBookID()))));
						
					}
				}}
				if(!books.isEmpty()) {
				System.out.println(books);}
					chooser = -1;
					displayOptions();
					chooseValue();
				}
				
				}while(chooser != 0);
			}
	
	/*
	 * Method to validate the input of the main loop
	 * The user must enter an integer with a value between 0 to 9
	 * if the input is not correct, the user is prompted again
	 * */
	public void chooseValue() {
		   
		this.input = sc.next();
		   while(chooser == -1) {
			if(Validators.isNumeric(input) == true && Integer.valueOf(input) >= 0 && Integer.valueOf(input) <= 9 ) {
				this.chooser = Integer.valueOf(input);
			} else {
				
				System.out.println("Invalid input, please enter a valid number (between 0 and 9) ");
				this.input = sc.next();
			}}}
	/*
	 * This method is used to display all the options that the user can choose from
	 * */
	public void displayOptions() {

		System.out.println("***************************************************************************");
		System.out.println("Welcome to the library");
		System.out.println();	
		
		System.out.println("Please select and operation you want to perform by choosing a number");
		System.out.println();
		
		System.out.println("1 For searching a specific book by title and/or author name");
		
		System.out.println("2 For listing all books by title and/or author name in alphabetical order");
		
		System.out.println("3 For searching for a specific reader by name and/or ID");
		
		System.out.println("4 For listing all readers by alphabetical and/or ID order");
		
		System.out.println("5 For registering that a reader has borrowed a book.");
		
		System.out.println("6 For adding a reader to the queue if a book is already booked");
		
		System.out.println("7 For registering that a reader has returned a book. ");
		
		System.out.println("8 For displaying the next reader waiting for a specific book.");
		
		System.out.println("9 For listing the books that a specific reader has borrowed");
		
		System.out.println("0 To end the program");		

	}
	}


