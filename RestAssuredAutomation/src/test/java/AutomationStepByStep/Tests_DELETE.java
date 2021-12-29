package AutomationStepByStep;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Tests_DELETE 
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
			.delete("https://reqres.in/api/users/2")
		.then()
			.statusCode(204)
			.log().all();
	}
	
	

}
