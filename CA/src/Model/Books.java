package Model;

public class Books {
	/*
	 * Attributes of the class Books
	 * */
	private int ID;
	private String title;
	private String author;
	
	/*
	 * Constructor for the class Books, takes all the attributes from this class as parameters
	 * */
	public Books(int ID, String title, String author) {
		
		this.ID = ID;
		this.title = title;
		this.author = author;
	
	}
	
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @return the name
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.title = name;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/*
	 * Compare method I read that was necessary to be able to sort the arrays
	 * when using integers 
	 * */
	 public int compare(Books book) {
	        
		 int res = 0;
	        
	        if (this.ID < book.getID()) {
	            res =- 1;
	        }else if (this.ID > book.getID()) {
	            res = 1;
	        } else if (this.ID == book.getID()) {
	        	res = this.title.compareTo(getTitle());
	        }
	        return res;
	    }

	/*
	 * toString method to be able to print a Book to the console instead of the hashcode
	 * */ 
	@Override
	public String toString() {
		  
		return "ID = "+Integer.toString(this.ID) +", Title: "+this.title+", Author: "+this.author; 
	}


}
