package AutomationStepByStep;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDriver 
{
	@Test(priority = 1, dataProvider = "DataForPost")
	public void test_1(String name, String job)
	{
		
		Map<String, Object> map = new HashMap();
		map.put("name", name);
		map.put("job", job);
		JSONObject request = new JSONObject(map);
		
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
	
	
	@DataProvider(name="DataForPost")
	public Object[][] dataForPost()
	{
//		Object[][] data = new Object[2][2];
//		
//		data[0][0]="Akshay";
//		data[0][1]="Selenium";
//		
//		data[1][0]="Sanjay";
//		data[1][1]="Java";
//		
//		return data;
		
		
		return new Object[][]
				{
					{"Akshay" , "Bhagat"},
					{"Sanjay" , "Bhagat"}
				};
	}
}
