import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * Creates Book objects to add to the library. 
 * 
 * @author Allie Rose Brenon
 * @version 12/12/2014
 */
public class Book {
	public String title;
	public String authorFirst;
	public String authorLast;
	public String locationShelf;
	public String locationOnShelf;
	public String description;
	public String dateOut;
	public String dateIn;
	public enum Inorout{
		IN, OUT
	}
	public Inorout status;


	/**
	 * @param title	the title of the book
	 * @param first	the author's first name
	 * @param last	the author's last name
	 * @param shelf	the shelf the book is on
	 * @param onShelf	where on the shelf the book is
	 * @param dateInorOut	the date the book was last checked in or out
	 * @param isitIn	the status of the book - in or out
	 */
	public Book(String title, String first, String last, String shelf, String onShelf, String dateInorOut, String isitIn){
		this.title = title;
		this.authorFirst = first;
		this.authorLast = last;
		this.locationShelf = shelf;
		this.locationOnShelf = onShelf;
		if (isitIn.equals("IN")){
			this.dateIn = dateInorOut;
			this.status = Inorout.IN;
		} else if (isitIn.equals("OUT")){
			this.dateOut = dateInorOut;
			this.status = Inorout.OUT;
		}
	}
	/**
	 * Changes the status of the book to checked out
	 */
	public void checkOut(){
		dateOut = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
		dateIn = null;
		status = Inorout.OUT;
	}
	/**
	 * Changes the status of the book to checked in
	 */
	public void checkIn(){
		dateIn = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
		dateOut = null;
		status = Inorout.IN;
	}
	/**
	 * Sets the description of the book
	 * @param words	the description
	 */
	public void addDescription(String words){
		this.description = words;
	}


}
