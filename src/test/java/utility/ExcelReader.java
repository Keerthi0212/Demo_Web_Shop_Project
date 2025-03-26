package utility;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	private static final String FILE_PATH = "C:\\Users\\geeth\\OneDrive\\Documents\\capstonedata.xlsx";
	 public static String getData(int row,int col) throws IOException {
		 FileInputStream fis = new FileInputStream(FILE_PATH);
		 Workbook workBook = new XSSFWorkbook(fis);
		 Sheet sheet = workBook.getSheetAt(0);
		 Row excelRow = sheet.getRow(row);
		// System.out.println(row);
		 Cell cell = excelRow.getCell(col);
		// System.out.println(cell);
		 String data = cell.getStringCellValue();
		 return data;
	 }

}
