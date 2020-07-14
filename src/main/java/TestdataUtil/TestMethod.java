package TestdataUtil;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestMethod {
	
	@Test(dataProvider = "search")
	public void test(String id, String name, String add )
	{
		double id2 = Double.parseDouble(id);
		int id3 = (int) id2;
		System.out.println(id3);
		System.out.println(name);
		System.out.println(add);
	}
	
	
	@DataProvider(name = "search")
	public Object[][] getdata() throws IOException
	{
		
		getdatafromexcel util = new getdatafromexcel();
		
		Object[][] data = util.getdatafromexcel("testdatatwo");
		
		return data;
	}

	
}
