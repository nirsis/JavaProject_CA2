package Model;

import java.util.ArrayList;

public class BubbleSort {

	/*
	 * This method gets an ArrayList of books as a parameter and then sorts
	 * the array using the comapare method I created in the Books class. 
	 * I used the bubblesort method we saw in class and added the compare method
	 * I found in stackoverflow 
	 * */
	public void bubbleSortByID(ArrayList<Books> list) {
	    Books temp;
	    boolean sorted = false;

	    while (!sorted) {
	        sorted = true;
	        for (int i = 0; i < list.size()-1; i++) {
	            if (list.get(i).compare(list.get(i + 1)) > 0) {
	                temp = list.get(i);
	                list.set(i, list.get(i + 1));
	                list.set(i + 1, temp);
	                sorted = false;
	            }
	        }
	    }
	}
	/*
	 * This method gets an ArrayList of books as a parameter and then sorts
	 * the array by title using the comapareTo method that is built in the String class
	 * */
	public void bubbleSortByTitle(ArrayList<Books> list) {
	    Books temp;
	    boolean sorted = false;

	    while (!sorted) {
	        sorted = true;
	        for (int i = 0; i < list.size()-1; i++) {
	            if (list.get(i).getTitle().compareTo(list.get(i + 1).getTitle()) > 0) {
	                temp = list.get(i);
	                list.set(i, list.get(i + 1));
	                list.set(i + 1, temp);
	                sorted = false;
	            }
	        }
	    }
	}
	/*
	 * This method gets an ArrayList of books as a parameter and then sorts
	 * the array by author using the comapareTo method that is built in the String class
	 * */
	public void bubbleSortByAuthor(ArrayList<Books> list) {
	    Books temp;
	    boolean sorted = false;

	    while (!sorted) {
	        sorted = true;
	        for (int i = 0; i < list.size()-1; i++) {
	            if (list.get(i).getAuthor().compareTo(list.get(i + 1).getAuthor()) > 0) {
	                temp = list.get(i);
	                list.set(i, list.get(i + 1));
	                list.set(i + 1, temp);
	                sorted = false;
	            }
	        }
	    }
	}
	/*
	 * This method gets an ArrayList of readers as a parameter and then sorts
	 * the array by name using the comapareTo method that is built in the String class
	 * */
	public void bubbleSortReaderByName(ArrayList<Reader> list) {
	    Reader temp;
	    boolean sorted = false;

	    while (!sorted) {
	        sorted = true;
	        for (int i = 0; i < list.size()-1; i++) {
	            if (list.get(i).getFirstName().compareTo(list.get(i + 1).getFirstName()) > 0) {
	                temp = list.get(i);
	                list.set(i, list.get(i + 1));
	                list.set(i + 1, temp);
	                sorted = false;
	            }
	        }
	    }
	}
	/*
	 * This method gets an ArrayList of readers as a parameter and then sorts
	 * the array by author ID the comapare method that is built in the reader class
	 * */
	public void bubbleSortReaderByID(ArrayList<Reader> list) {
	    Reader temp;
	    boolean sorted = false;

	    while (!sorted) {
	        sorted = true;
	        for (int i = 0; i < list.size()-1; i++) {
	            if (list.get(i).compare(list.get(i + 1))> 0) {
	                temp = list.get(i);
	                list.set(i, list.get(i + 1));
	                list.set(i + 1, temp);
	                sorted = false;
	            }
	        }
	    }
	}
}
