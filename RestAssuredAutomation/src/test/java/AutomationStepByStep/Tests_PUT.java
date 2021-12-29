package AutomationStepByStep;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Tests_PUT 
{
	@Test(priority = 1)
	public void test_1()
	{
		
		Map<String, Object> map = new HashMap();
		map.put("name", "Bhagat");
		map.put("job", "leader");
		
		JSONObject request = new JSONObject(map);
		
		given()
		.header("Content-Type", "application/json")
		.body(request.toJSONString())
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
	.when()
		.put("https://reqres.in/api/users/2")
	.then()
		.statusCode(200)
		.log().all();
	}
	
	
	@Test(priority = 2)
	public void test_2()
	{
		
		Map<String, Object> map = new HashMap();
		map.put("name", "KK");
		map.put("job", "leader");
		
		JSONObject request = new JSONObject(map);
		
		given()
		.header("Content-Type", "application/json")
		.body(request.toJSONString())
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
	.when()
		.patch("https://reqres.in/api/users/2")
	.then()
		.statusCode(200)
		.log().all();
	}

}
