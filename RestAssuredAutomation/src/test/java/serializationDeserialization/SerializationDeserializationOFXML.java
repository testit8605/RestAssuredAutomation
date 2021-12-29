package serializationDeserialization;

import java.util.ArrayList;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class SerializationDeserializationOFXML 
{
	
	
	@Test(priority=1)
	public void testSerialization()
	{
		VideoGame myVideoGame = new VideoGame();
		myVideoGame.setId(100);
		myVideoGame.setName("Akshay");
		myVideoGame.setReleaseData("2019-06-17");
		myVideoGame.setReviewScore(90);
		myVideoGame.setCategory("Driveing");
		myVideoGame.setRating("five");
		
		given()
			.contentType(ContentType.XML)
			.body(myVideoGame)
		.when()
			.post("post URL")
		.then()
			.statusCode(200)
			.log().all()
			.body(equalTo("{\"status\": \"Record added\"}"));
	}
	
	@Test(priority=2)
	public void testDeserialization()
	{		
		VideoGame myVideoGame = get("get url").as(VideoGame.class);
		System.out.println(myVideoGame.toString());	
	}
}
