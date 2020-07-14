package TestdataUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class getdatafromexcel {
	
	
	public Object[][] getdatafromexcel(String sheetname) throws IOException
	{
		
		FileInputStream fis=new FileInputStream("D:\\PetStoreAPIFramework\\src\\main\\java\\TestdataUtil\\Testdata.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		
		XSSFSheet sheet=workbook.getSheet(sheetname);
		
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i = 0; i<sheet.getLastRowNum();i++)
		{
			
			for(int k = 0; k<sheet.getRow(0).getLastCellNum(); k++)
			{
				
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
				//System.out.println(data[i][k]);
				
			}
			
			
		}
		
		
		
		return data;
	}
	
	

}
