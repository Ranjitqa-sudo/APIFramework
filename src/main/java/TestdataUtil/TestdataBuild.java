package TestdataUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TestdataBuild {

	
	
	
	public HashMap<String,Object> addpetpayload(int petId, String name, String status) throws IOException
	
	{
		
		//GetTestData d = new GetTestData();
		//ArrayList data = d.getData("AddPet");
		
		
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", petId);
		map.put("name", name);
		map.put("status", status);
		
		return map;
		
	}
}
