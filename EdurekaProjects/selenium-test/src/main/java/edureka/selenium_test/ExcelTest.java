package edureka.selenium_test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import utils.ExcelReader;

public class ExcelTest {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		// TODO Auto-generated method stub
		String[][] data = ExcelReader.getCellData("excel//TestScript.xlsx", "Configuration");
	    
		System.out.println(data[0][1]);
	}

}
