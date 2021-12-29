package rsetAssuredTest;

import java.util.HashMap;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class Demo2_POSTRequest 
{
	public static HashMap map = new HashMap();
	
	public void postData()
	{
		map.put("name", restUtils.getName());
		map.put("job", restUtils.getJob());
		
		RestAssured.baseURI="https://reqres.in/api";
		RestAssured.basePath="/users";
	}
	
	@Test
	public void testPost()
	{
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.post()
		.then()
			.statusCode(201)
			.body("name", equalTo("morpheus"))
			.and()
			.body("job", equalTo("leader")); //.body(equalTo({"\status\": \"Record Added Successfully"\}));
	}

}
