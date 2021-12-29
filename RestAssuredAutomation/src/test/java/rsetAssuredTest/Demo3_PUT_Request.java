package rsetAssuredTest;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo3_PUT_Request 
{
	public static HashMap map = new HashMap();
	
	String name = restUtils.getName();
	String job = restUtils.getJob();

	
	@BeforeClass	
	public void putData()
	{	
		map.put("name", restUtils.getName());
		map.put("job", restUtils.getJob());
		
		RestAssured.baseURI= "https://reqres.in/api/users";
		RestAssured.basePath="/2";
	}
	
	@Test
	public void testPUT()
	{
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.put()
		.then()
			.statusCode(200)
			.log().all();
	}
	
	

}
