package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class WriteExcelFile {
	
	public static void writeData(int r, int c, String val) throws IOException {
		String path= System.getProperty("user.dir")+"\\Data\\Test.xlsx";
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet3");
		XSSFRow row = sheet.createRow(r);
		XSSFCell cell = row.createCell(c);
		cell.setCellValue(val);
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		System.out.println("Successfully Write Value");
		
	}

}
