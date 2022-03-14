package Model;

import java.util.ArrayList;

import Controller.Validators;

public class LinearSearch {
/*
 * In this class I have 2 methods of LinearSearch, one for the readers and one for the books 
 * 
 * */	
	int valueofID = 0;
	
/*
 * This methods receives and array of books and a target(String) and loops
 * through the array line by line until the target is found, if not it returns -1
 * */	
public int linearSearchBook(ArrayList<Books> array, String target) {
	
	if(Validators.isNumeric(target)) {
		valueofID = Integer.parseInt(target);
	}
	
    	for (int i=0; i < array.size(); i++) {
    		
            if (target.equalsIgnoreCase(array.get(i).getAuthor()) | target.equals(array.get(i).getTitle()) | valueofID == array.get(i).getID()) {
                return i;
            }
        }
        return -1;
    }
/*
 * This methods receives and array of readers and a target(String) and loops
 * through the array line by line until the target is found, if not it returns -1.
 * 
 * */	    
public int linearSearchReader(ArrayList<Reader> array, String target) {
    	
    	if(Validators.isNumeric(target)) {
    		valueofID = Integer.parseInt(target);
    	}

    	
    	for (int i=0; i < array.size(); i++) {
    		
            if (target.equalsIgnoreCase(array.get(i).getFirstName()) | valueofID == array.get(i).getID()){
                return i;
            }
        }
        return -1;
    }

public int linearSearchBorrowing(ArrayList<Borrowings> array, int target, int target2) {
	


	
	for (int i=0; i < array.size(); i++) {
		
        if (target == array.get(i).getReaderID() && target2 == array.get(i).getBookID()){
            return i;
        }
    }
    return -1;
}
    
}

