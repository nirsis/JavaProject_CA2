package Model;
/*
 * This class stores the ID of a reader and the ID of the borrowed book
 * */
public class Borrowings {
/*
 * Attributes of Borrowings
 * */
private int readerID;
private int bookID;

/*
 * Constructor, takes all the attributes as parameters
 * */
public Borrowings(int readerID, int bookID) {
	this.readerID = readerID;
	this.bookID = bookID;
}

/**
 * @return the readerID
 */
public int getReaderID() {
	return readerID;
}

/**
 * @return the bookID
 */
public int getBookID() {
	return bookID;
}

/**
 * @param readerID the readerID to set
 */
public void setReaderID(int readerID) {
	this.readerID = readerID;
}

/**
 * @param bookID the bookID to set
 */
public void setBookID(int bookID) {
	this.bookID = bookID;
}

/*
 * toString method, required to write to the file later on
 * */
public String toString() {
	return this.readerID+","+this.bookID;
}
}
