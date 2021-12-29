package serializationDeserialization;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

public class ArrayJSON {
	
public static HashMap map = new HashMap();
	
	@Test(priority=1)
	public void createNewEntry()
	{
		map.put("name", "Akshay");
		map.put("job", "Software");
				
		ArrayList<String> al = new ArrayList<String>();
		al.add("Software");
		al.add("Kat");
		al.add("testing");
		
		map.put("Cources", al);
		
		
		given()
		.contentType("application/json") //.contentType(ContentType.JSON)
		.body(map)
		
		.when()
		.post("https://reqres.in/api/users")
		
		.then()
		.statusCode(201)
		.log().all()
		.assertThat().body("msg", equalTo("Student Added"));
		
	}

}
