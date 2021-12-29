package rsetAssuredTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo1_GET_Request 
{
	@Test
	public void getWeatherDetails()
	{
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.assertThat().body("page", equalTo(2))
			.header("Server", "cloudflare");
	}
}
