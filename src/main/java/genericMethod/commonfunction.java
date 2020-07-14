package genericMethod;



import java.io.IOException;

import org.testng.Assert;

import TestdataUtil.TestdataBuild;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.Utils;

public class commonfunction extends Utils {
	
	
	
	Response response;
	
	
	//Perform all kind of post http request
	public void postHttpRequest(RequestSpecification req,String resource) throws IOException
	{
		
		response = req.when().post(getGlobalValue(resource));
	}
	
	
	//Perform all kind of get http request
	public void getHttpRequest(RequestSpecification req, String resource) throws IOException 
	{
		
		response = req.when().get(getGlobalValue(resource));
		
	}
	
	
	public void deleteHttpRequest(RequestSpecification req,String resource) throws IOException 
	{
		
		response = req.when().delete(getGlobalValue(resource));
		
	}
	
	//Return status code of all responses
	public int getStatusCode()
	{
		
		int statuscode = response.getStatusCode();
		return statuscode;
	}
	
	//Return response body value
	public String getResponseBody(String key)
	{
		String Responsevalue = getResponse(response, key);
		return Responsevalue;
	}
	
	//Verify Status Code
	public void verifyStatusCode(int expectedcode,int actualcode)
	{
		Assert.assertEquals(actualcode, expectedcode);
	}
	
	
	

}
