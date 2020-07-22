package TestCase;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Testbase.Baseclass;
import TestdataUtil.getdatafromexcel;
import genericMethod.PetStoreRelatedMethod;
import io.restassured.specification.RequestSpecification;
import resources.Utils;

public class DeletePetTest extends Baseclass {
	
	
	int statusCode;
	String responseId;
	PetStoreRelatedMethod pet = new PetStoreRelatedMethod();
	RequestSpecification req;
	

	
	@Test(dataProvider = "insertdata")
	public void deletePetTest(String petid, String name, String status) throws IOException 
	{ 
		logger = report.createTest("deletepettest");
		
		int pet_id = Utils.ConverttoInt(petid);
		
	//	req = pet.addPathparamaspetid(pet_id);
		
		  
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
		  
		  Object[][] data = util.getdatafromexcel("deletepet");
		  
		  return data;
		 
	}
}
