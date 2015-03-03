import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.*;
import jxl.read.biff.BiffException;


/**
 * Creates a library from a spreadsheet with book data.
 * Uses Java Excel API.
 * 
 * @author Allie Rose Brenon
 * @version 12/12/2014
 */
public class LibCreate {

	public List<Book> libBooks = null;

	/**
	 * @param fileName	the file to be read in
	 * @throws BiffException
	 * @throws IOException
	 */
	public LibCreate(String fileName) throws BiffException, IOException {
		libBooks = new ArrayList<Book>();
		File file = new File(fileName);
		Workbook workbook = Workbook.getWorkbook(file);
		Sheet sheet = workbook.getSheet(0);
		String title;
		String first; 
		String last; 
		String shelf; 
		String onShelf;
		String words;
		String isitIn;
		String date;

		for (int i = 0; i< 266; i++){

			Cell a1 = sheet.getCell(0,i);
			shelf = a1.getContents();

			Cell b1 = sheet.getCell(1,i);
			onShelf = b1.getContents();

			Cell c1 = sheet.getCell(2,i);
			last = c1.getContents();

			Cell d1 = sheet.getCell(3,i);
			first = d1.getContents();

			Cell e1 = sheet.getCell(4,i);
			title = e1.getContents();

			Cell f1 = sheet.getCell(5,i);
			words = f1.getContents();

			Cell g1 = sheet.getCell(6,i);
			isitIn = g1.getContents();

			Cell h1 = sheet.getCell(7,i);
			date = h1.getContents();

			Book book = new Book(title,first,last,shelf, onShelf, date, isitIn);
			book.addDescription(words);
			libBooks.add(book);
		}

		workbook.close();
	}

}
