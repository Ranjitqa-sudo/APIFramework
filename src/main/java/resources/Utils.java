package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;



public class Utils {
	
	
	public static RequestSpecification req;
	public RequestSpecification requestSpecification() throws IOException
	{
		
		if(req==null)
		{
		PrintStream log =new PrintStream(new FileOutputStream("D:\\PetStoreAPIFramework\\Logfiles\\Logfile"+Utils.getCurrentDateTime()+".text"));
		 req=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
		.setContentType(ContentType.JSON).build();
		 return req;
		}
		return req;
		
		
	}
	
	
	
	public static String getResponse(Response response,String key)
	{
		 
		String resp=response.asString();
		JsonPath   js = new JsonPath(resp);
		return js.get(key).toString();
	}

	
	
	
	public static String getGlobalValue(String key) throws IOException
	{
		Properties prop =new Properties();
		FileInputStream fis =new FileInputStream("D:\\PetStoreAPIFramework\\src\\main\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentdateDate = new Date();
		return customformat.format(currentdateDate);
	}
	
	public static int ConverttoInt(String S)
	{
		double d = Double.parseDouble(S);
		int a = (int)d; 
		return a;
		
	}


		
		
}


