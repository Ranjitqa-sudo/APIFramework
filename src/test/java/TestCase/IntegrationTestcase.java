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

public class IntegrationTestcase extends Baseclass {
	
	
	int statusCode;
	String responseId;
	PetStoreRelatedMethod pet = new PetStoreRelatedMethod();
	RequestSpecification req;
	
	@Test(dataProvider = "insertdata")
	public void addpettest(String petid, String name, String status) throws IOException {
		
		
		  logger =  report.createTest("addpettest");
		
		  int pet_id = Utils.ConverttoInt(petid);
		  req = pet.addPayloadCreatePet(pet_id,name,status);
		  pet.postHttpRequest(req,"PetCeateresource"); 
		  logger.info("Post requested performed");
		  statusCode = pet.getStatusCode();
		  logger.info("Status code is " + statusCode);
		  System.out.println(statusCode);
		  responseId = pet.getResponseBody("id");  
		  logger.info("Pet Id is " + responseId);
		  System.out.println(responseId); 
		  pet.verifyStatusCode(200, statusCode);
		
		  
	}
	
	 @Test(priority = 2)
	 public void getPetTest() throws IOException 
	 { 
		logger = report.createTest("getpettest"); 
		 
		 int pet_id = Utils.ConverttoInt(responseId);
		 req = pet.addPathparamaspetid(pet_id);
		 pet.getHttpRequest(req,"getpetresource");
		 logger.info("Get requested performed");
		 statusCode = pet.getStatusCode();
		 logger.info("Status code is " + statusCode);
		 System.out.println(statusCode); 
		 responseId = pet.getResponseBody("id"); 
		 logger.info("Pet Id is " + responseId);
		 System.out.println(responseId); 
		 pet.verifyStatusCode(200, statusCode);
			  
	 }
	 
	 @Test(priority = 3)
		public void deletePetTest() throws IOException 
		{ 
			logger = report.createTest("deletepettest");
			
			int pet_id = Utils.ConverttoInt(responseId);			  
			req = pet.addPathparamaspetid(pet_id); 
			pet.deleteHttpRequest(req,"deletepetresource"); 
			logger.info("Delete requested performed");
		    logger.info("Delete Pet Id " + pet_id); 
		    statusCode = pet.getStatusCode();
			logger.info("Status code is " + statusCode); 
			System.out.println(statusCode);
			pet.verifyStatusCode(200, statusCode); 
			
			  
		}
	
	@DataProvider(name = "insertdata")
	public Object[][] getdata() throws IOException
	{
		
		  getdatafromexcel util = new getdatafromexcel();
		  
		  Object[][] data = util.getdatafromexcel("IntegrationTest");
		  
		  return data;
		 
	}

}
