package TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Testbase.Baseclass;
import TestdataUtil.getdatafromexcel;
import genericMethod.PetStoreRelatedMethod;

import genericMethod.commonfunction;
import io.restassured.specification.RequestSpecification;
import resources.Utils;

public class AddPetTest extends Baseclass{

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
	
	@DataProvider(name = "insertdata")
	public Object[][] getdata() throws IOException
	{
		
		  getdatafromexcel util = new getdatafromexcel();
		  
		  Object[][] data = util.getdatafromexcel("addpettest");
		  
		  return data;
		 
	}
	
	
	
	
	 
	  
	  
	  
	  
	  
	 
	
	
}



