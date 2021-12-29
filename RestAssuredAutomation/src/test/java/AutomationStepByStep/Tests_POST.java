package AutomationStepByStep;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Tests_POST 
{
	
	@Test(priority = 1)
	public void test_1()
	{
		
		Map<String, Object> map = new HashMap();
		map.put("name", "Akshay");
		map.put("job", "leader");
		
		System.out.println(map);
		
		JSONObject request = new JSONObject(map);
		System.out.println(request);
		
		given()
			.header("Content-Type", "application/json")
			.body(request.toJSONString())
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.log().all();
	}
	
	

}
