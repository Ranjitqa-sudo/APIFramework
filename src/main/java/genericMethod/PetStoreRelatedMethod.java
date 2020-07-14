package genericMethod;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import TestdataUtil.TestdataBuild;
import io.restassured.specification.RequestSpecification;
import resources.Utils;

public class PetStoreRelatedMethod extends commonfunction {
	
	RequestSpecification req;
	TestdataBuild d = new TestdataBuild();
	
	
	
	public RequestSpecification addPathparamaspetid(int pet_id) throws IOException
	{
		req = given().spec(requestSpecification()).pathParam("petid", pet_id);
		return req;
	}
	
	//Create test data for Json payload
	public RequestSpecification addPayloadCreatePet(int petid, String name, String status) throws IOException
	{
		
		req = given().spec(requestSpecification()).
				body(d.addpetpayload(petid,name,status));
		return req;
	}

}
