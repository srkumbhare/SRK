package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ReadExFile {
	
	
	public static String readData(int r, int c) throws IOException {
		String path = System.getProperty("user.dir")+"\\Data\\Test.xlsx";
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(1);
		XSSFRow row = sheet.getRow(r);
		XSSFCell cell = row.getCell(c);
		String value = cell.getStringCellValue();
		
		System.out.println(value);
		System.out.println("Read Data Successfully.");
		//workbook.close();
		return value;		
	}
}
