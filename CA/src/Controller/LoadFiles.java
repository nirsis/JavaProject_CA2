package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Books;

import Model.Borrowings;
import Model.BubbleSort;
import Model.LinearSearch;
import Model.Reader;

public class LoadFiles {
/*
 * This class contains the methods that I use to read the text files and load them to the memory
 * in form of ArrayLists of their respective class
 * */
private String leFile = "";
  
Scanner sc = null;
BubbleSort bs = new BubbleSort();
LinearSearch ls = new LinearSearch();

/*
 * This method reads the file where all the readers are written in a CSV file (readers.txt).
 * I use a File, Scanner and a loop to go through all the lines  and then 
 * return the values in form of an ArrayList of readers
 * */
public ArrayList<Reader> loadReader() throws FileNotFoundException {
	
	this.leFile = "readers.txt";
	File file = new File(leFile);
	sc = new Scanner(file);
	String line = "";
	ArrayList<Reader> rd = new ArrayList<>();

	while(sc.hasNext()) {
		
		line = sc.nextLine();
		String[] result = line.split(",");
		rd.add(new Reader(Integer.valueOf(result[0]), result[1], result[2], result[3], Integer.valueOf(result[4])));
		
	}
	
	
	return rd;
	
}
/*
 * This method reads the file where all the books are written in a CSV file (books.txt).
 * I use a File, Scanner and a loop to go through all the lines  and then 
 * return the values in form of an ArrayList of books
 * */
public ArrayList<Books> loadBooks() throws FileNotFoundException {
	
	this.leFile = "books.txt";
	File file = new File(leFile);
	sc = new Scanner(file);
	String line = "";
	ArrayList<Books> rd = new ArrayList<>();

	while(sc.hasNext()) {
		
		line = sc.nextLine();
		String[] result = line.split(",");
		rd.add(new Books(Integer.valueOf(result[0]), result[1], result[2]));
		
	}
	
	
	return rd;
	
}
/*
 * This method reads the file where all the borrowings are written in a CSV file (books.txt).
 * The file stores the ID of a reader and the ID of the book separated by comas
 * */

public ArrayList<Borrowings> loadBorrowings2() throws FileNotFoundException {
	
	this.leFile = "borrowings.txt";
	File file = new File(leFile);
	sc = new Scanner(file);
	String line = "";
	ArrayList<Borrowings> rd = new ArrayList<>();

	while(sc.hasNext()) {
		
		line = sc.nextLine();
		String[] result = line.split(",");
		rd.add(new Borrowings(Integer.valueOf(result[0]),Integer.valueOf(result[1])));
		
	}
	
	
	return rd;
	
}
}
