package MiniProjectOfRestAssuredAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;

public class TC_VideoGameAPI 
{
	@Test(priority =1)
	public void test_getAllVideoGame()
	{
		given()
		.when()
			.get("ULR")
		.then()
			.statusCode(200);
	}
	
	@Test(priority = 2)
	public void test_addNewVideoGame()
	{
		HashMap map = new HashMap();
		map.put("id", "100");
		map.put("name", "Spider-Man");
		map.put("releaseDate", "2019--9-20");
		map.put("reviewScore", "5");
		map.put("category", "Adventure");
		map.put("rating", "five");
		
		Response response = 
		
		given()
		.contentType(ContentType.JSON)
		.body(map)
		.when()
			.post("URL")
		.then()
			.statusCode(200)
			.log().all()
			.log().body()
			.extract().response();
		
		String jsonString = response.asString();
		
		Assert.assertEquals(jsonString.contains("Record added successfully"), true);
	}
	
	@Test(priority =3)
	public void test_getOneVideoGame()
	{
		given()
		.when()
			.get("One video url")
		.then()
			.statusCode(200)
			.log().body()
			.body("videogame.id", equalTo("100"))
			.body("Videogame.name", equalTo("Spider-Man"));
	}
	
	@Test(priority =4)
	public void test_updateVideoGame()
	{
		
		HashMap map = new HashMap();
		map.put("id", "100");
		map.put("name", "Spider-Man2");
		map.put("releaseDate", "2019--9-20");
		map.put("reviewScore", "4");
		map.put("category", "Adventure");
		map.put("rating", "five");
		
		given()
		.contentType(ContentType.JSON)
		.body(map)
		.when()
			.put("")
		.then()
			.statusCode(200)
			.log().body()
			.body("Videogame.id", equalTo("100"))
			.body("Videogame.name", equalTo("Spider-Man2"));
	}
	
	
	@Test(priority =5)
	public void test_deleteVideoGame()
	{
		Response response=
		given()
		.when()
			.delete("url")
		.then()
			.statusCode(200)
			.log().body()
			.extract().response();
		
		String jsonResponse = response.asString();
		Assert.assertEquals(jsonResponse.contains("Record deleted successfully"), true);
	}
}
