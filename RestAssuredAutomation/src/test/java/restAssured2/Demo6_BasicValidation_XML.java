package restAssured2;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Demo6_BasicValidation_XML 
{
	@Test(priority = 1)
	public void singleContent()
	{
		given()
		.when().get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
		.statusCode(200)
		.body("CUSTOMER.ID", equalTo("15"))
		.log().all();
	}
	
	@Test(priority = 2)
	public void multipleContent()
	{
		given()
		.when().get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
		.statusCode(200)
		.body("CUSTOMER.ID", equalTo("15"))
		.body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
		.body("CUSTOMER.LASTNAME", equalTo("Clancy"))
		.body("CUSTOMER.STREET", equalTo("319 Upland Pl."))
		.body("CUSTOMER.CITY", equalTo("Seattle"));	
	}
	
	@Test(priority = 3)
	public void multipleContentInOneGo()
	{
		given()
		.when().get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
		.statusCode(200)
		.body("CUSTOMER.text()", equalTo("15BillClancy319 Upland Pl.Seattle"));
	}
	
	
	@Test(priority = 4)
	public void usingXpath()
	{
		given()
		.when().get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
		.statusCode(200)
		.body(hasXPath("/CUSTOMER/FIRSTNAME", containsString("Bill")));
	}
	
	@Test(priority = 5)
	public void usingXpath2()
	{
		given()
		.when().get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
		.statusCode(200)
		.body(hasXPath("/CUSTOMER/FIRSTNAME[text() = 'Bill']"));
	}
	

}


