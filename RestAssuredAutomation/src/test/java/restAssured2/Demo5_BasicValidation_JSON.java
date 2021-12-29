package restAssured2;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Demo5_BasicValidation_JSON 
{
	
	@Test(priority = 1)
	public void testStatusCode()
	{
		
		given()
		.when()
			.get("http://jsonplaceholder.typicode.com/posts/2")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all();
	}
	
	@Test(priority = 2)
	public void testLogging()
	{
		given()
		.when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
		.then()
			.statusCode(200)
			.log().all();	
	}
	
	@Test(priority = 3)
	public void testSingleContent()
	{
		
		given()
		.when()
			.get("http://jsonplaceholder.typicode.com/posts/2")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.body("title", equalTo("qui est esse"));
	}
	
	@Test(priority = 4)
	public void testMultipleContent()
	{
		
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.body("data.email", hasItems("tobias.funke@reqres.in", "michael.lawson@reqres.in", "lindsay.ferguson@reqres.in", "byron.fields@reqres.in", "george.edwards@reqres.in", "byron.fields@reqres.in"));	
	}
	
	@Test(priority = 5)
	public void testParametersAndHeaders()
	{
		
		given()
		.param("MyName", "Akshay")
		.header("My c", "Bhagat")
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all();
	}
	
	
	
	

}
