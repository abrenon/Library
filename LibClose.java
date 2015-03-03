import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.*;


/**
 * Writes a library to a spreadsheet with the updated book data.
 * Uses Java Excel API.
 * 
 * @author Allie Rose Brenon
 * @version 12/12/2014
 */
public class LibClose {

	/**
	 * @param libBooks - the List of Books in the library
	 * @throws BiffException
	 * @throws IOException
	 * @throws WriteException
	 */
	public LibClose(List<Book> libBooks) throws BiffException, IOException, WriteException {
		WritableWorkbook workbook = Workbook.createWorkbook(new File("libraryBooks.xls"));
		WritableSheet sheet = workbook.createSheet("Library", 0);

		for (int i = 0; i< libBooks.size(); i++){

			Label a1 = new Label(0, i, libBooks.get(i).locationShelf); 
			sheet.addCell(a1); 

			Label b1 = new Label(1, i, libBooks.get(i).locationOnShelf); 
			sheet.addCell(b1); 

			Label c1 = new Label(2, i, libBooks.get(i).authorLast); 
			sheet.addCell(c1); 

			Label d1 = new Label(3, i, libBooks.get(i).authorFirst); 
			sheet.addCell(d1); 

			Label e1 = new Label(4, i, libBooks.get(i).title); 
			sheet.addCell(e1); 

			Label f1 = new Label(5, i, libBooks.get(i).description); 
			sheet.addCell(f1); 

			Label g1 = new Label(6, i, libBooks.get(i).status.toString()); 
			sheet.addCell(g1); 

			if (libBooks.get(i).status == Book.Inorout.IN){
				Label h1 = new Label(7, i, libBooks.get(i).dateIn); 
				sheet.addCell(h1); 
			} else if (libBooks.get(i).status == Book.Inorout.OUT){
				Label h1 = new Label(7, i, libBooks.get(i).dateOut); 
				sheet.addCell(h1); 
			}
		}

		workbook.write();
		workbook.close();
	}

}
