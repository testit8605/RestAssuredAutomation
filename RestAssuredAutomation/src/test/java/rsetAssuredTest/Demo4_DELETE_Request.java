package rsetAssuredTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo4_DELETE_Request 
{
	
	@Test
	public void deleteEmployeeRecord()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.basePath="/2";
		Response response = 
		given()
		.when()
			.delete()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all()
			.extract().response();
		
		
		String jsonAsString  = response.asString();
		Assert.assertEquals(jsonAsString.contains("Successfully! deleted Records"), true);
		
	}
	
	

}
