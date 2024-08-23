package demotest;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary {
	String filepath;
	
	public ExcelLibrary(String filepath) {
		
		this.filepath=filepath;
		
	}

	public  String[][] getExcelData() {
		
		
		
		
			XSSFWorkbook wb=null;
			try {
				wb = new XSSFWorkbook(filepath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			XSSFSheet s=wb.getSheet("login");
			int lastRow=s.getLastRowNum();
			short lastcell=s.getRow(0).getLastCellNum();
			
			String[][] data= new String[lastRow][lastcell];
				for (int i = 1; i <=lastRow ; i++) {
				XSSFRow r = s.getRow(i);
				for (int j = 0; j <lastcell; j++) {
					XSSFCell c = r.getCell(j);
					DataFormatter dft= new DataFormatter();
					String value=dft.formatCellValue(c);
					//String value = c.getStringCellValue();
					data[i-1][j]=value;
				}
			}try {
				wb.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return data; 
			
		
	}

}
