package Model;

public class Reader {
	/*
	 * Attributes of the class Reader
	 * */
private int ID;
private String firstName;
private String lastName;
private String email;
private int numBooksBorrowed;
private Books booksBorrowed;

/**
 * @param booksBorrowed the booksBorrowed to set
 */
public void setBooksBorrowed(Books booksBorrowed) {
	this.booksBorrowed = booksBorrowed;
}

/*
 * Constructor of class Reader takes all the attributes as parameters excepting the books borrowed
 * */
public Reader(int ID, String firstname, String lastname, String email, int numBooksBorrowed) {

this.ID = ID;
this.firstName = firstname;
this.lastName = lastname;
this.email = email;
this.numBooksBorrowed = numBooksBorrowed;

}

/**
 * @return the iD
 */
public int getID() {
	return ID;
}

/**
 * @return the firstName
 */
public String getFirstName() {
	return firstName;
}

/**
 * @return the lastName
 */
public String getLastName() {
	return lastName;
}

/**
 * @return the email
 */
public String getEmail() {
	return email;
}

/**
 * @return the booksBorrowed
 */
public Books getBooksBorrowed() {
	return booksBorrowed;
}

/**
 * @param iD the iD to set
 */
public void setID(int iD) {
	ID = iD;
}

/**
 * @param firstName the firstName to set
 */
public void setFirstName(String firstName) {
	this.firstName = firstName;
}

/**
 * @param lastName the lastName to set
 */
public void setLastName(String lastName) {
	this.lastName = lastName;
}

/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}
/*
 * Compare method I read that was necessary to be able to sort the arrays
 * when using integers 
 * */
public int compare(Reader reader) {
    
	 int res = 0;
       
       if (this.ID < reader.getID()) {
           res =- 1;
       }else if (this.ID > reader.getID()) {
           res = 1;
       } else if (this.ID == reader.getID()) {
       	res = this.firstName.compareTo(getFirstName());
       }
       return res;
   }

/*
 * toString method to print reader objects to the console
 * */
@Override
public String toString() {
	
	return "[ID: "+Integer.toString(ID)+", First name: "+this.firstName+", Last name: "+this.lastName+", Email: "+this.email+", Books borrowed: "+this.numBooksBorrowed+", "+this.booksBorrowed+"]";
}

/**
 * @return the numBooksBorrowed
 */
public int getNumBooksBorrowed() {
	return numBooksBorrowed;
}

/**
 * @param numBooksBorrowed the numBooksBorrowed to set
 */
public void setNumBooksBorrowed(int numBooksBorrowed) {
	this.numBooksBorrowed = numBooksBorrowed;
}
}
