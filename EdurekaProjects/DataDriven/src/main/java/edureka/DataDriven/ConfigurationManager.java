package edureka.DataDriven;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import utils.ExcelReader;

public class ConfigurationManager {
	
	public static String[][] getConfigs() throws InvalidFormatException, IOException {
		
			String cofigData[][] = ExcelReader.getCellData("Data//TestScript.xlsx", "Configuration");	
			
			return cofigData;
		}
	}


