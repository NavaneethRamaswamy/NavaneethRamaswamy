package week5.day2.assignments;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataFromExcel {

	public String[][] dataFromExcel() throws IOException {
		
		XSSFWorkbook workBook = new XSSFWorkbook("./testData/ExcelData.xlsx");
		XSSFSheet datasheet = workBook.getSheet("CreateLead");
		int rowcount = datasheet.getLastRowNum();
		int columncount = datasheet.getRow(0).getLastCellNum();
		
		String[][] leadTestData = new String[rowcount][columncount];
		
		for (int i=1;i<=rowcount;i++ ) { 
			for (int j=0;j<columncount; j++ ) { 
				leadTestData[i-1][j] = datasheet.getRow(i).getCell(j).toString();
			}
		}
		
		
		
		
		workBook.close();
		return leadTestData;
			
		}
		
	}

