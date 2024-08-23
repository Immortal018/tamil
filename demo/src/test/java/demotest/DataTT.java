package demotest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataTT {
	
	@Test(dataProvider ="dp")
	public void ff(String[] data) {
		
		String row1= data[0];
		String col1= data[1];
		
		System.out.println(row1);
		System.out.println(col1);
		
	}
	
	@DataProvider(name="dp")
	
	public String[][] getUtils(){
		
		ExcelLibrary xlib= new ExcelLibrary("./testdata/Data.xlsx");
		
		String[][] ss=xlib.getExcelData();
		
		
		return ss;
		
	}

}
