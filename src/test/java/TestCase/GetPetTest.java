package TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Testbase.Baseclass;
import TestdataUtil.getdatafromexcel;
import genericMethod.PetStoreRelatedMethod;
import io.restassured.specification.RequestSpecification;
import resources.Utils;

public class GetPetTest extends Baseclass {

	

	int statusCode;
	String responseId;
	String responseName;
	String responseStatus;
	PetStoreRelatedMethod pet = new PetStoreRelatedMethod();
	RequestSpecification req;
	
	 @Test (dataProvider = "insertdata") 
	 public void getPetTest(String petid, String name, String status) throws IOException 
	 { 
		logger = report.createTest("getpettest"); 
		 
		 int pet_id = Utils.ConverttoInt(petid);
		 req = pet.addPathparamaspetid(pet_id);
		 pet.getHttpRequest(req,"getpetresource");
		 logger.info("Get requested performed");
		 statusCode = pet.getStatusCode();
		 logger.info("Status code is " + statusCode);
		 System.out.println(statusCode); 
		 responseId = pet.getResponseBody("id"); 
		 responseName = pet.getResponseBody("name"); 
		 responseStatus = pet.getResponseBody("status"); 
		 logger.info("Pet Id is " + responseId);
		 System.out.println(responseId); 
		 pet.verifyStatusCode(200, statusCode);
		 String petidValue = Integer.toString(pet_id);
		 Assert.assertEquals(responseName, name);
		 Assert.assertEquals(responseStatus, status);
		 Assert.assertEquals(responseId, petidValue);
		
			  
	 }
	 
	 @DataProvider(name = "insertdata")
		public Object[][] getdata() throws IOException
		{
			
			  getdatafromexcel util = new getdatafromexcel();
			  
			  Object[][] data = util.getdatafromexcel("testdata");
			  
			  return data;
			 
		}
		
}
