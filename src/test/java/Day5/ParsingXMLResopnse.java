package Day5;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;

public class ParsingXMLResopnse {
	// @Test
	void testXMLResponse() {
		// Approach1
		/*
		 * given ( ) .when() .get("http://restapi.adequateshop.com/api/Traveler?page=1")
		 * .then() .statusCode (200) .header("Content-Type",
		 * "application/xml; charset=utf-8") .body ("Travelerinformation Response.page",
		 * equalTo("1"))
		 * .body("Travelerinformation Response.travelers. Travelerinformation [0].name",
		 * equalTo("Developer"));
		 */

		// Approach2
		Response res = given().when().get("http://restapi.adequateshop.com/api/Traveler?page=1");
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
		String page = res.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(page, "1");
	}

	@Test
	void testXMLResponseData() {
		
		//To upload the file 
		//https://www.youtube.com/watch?v=IB3G7IbdD1k&list=PLUDwpEzHYYLuW9XEvFEJk2kqsk6HqscI4&index=15
		Response res = given().when().get("http://restapi.adequateshop.com/api/Traveler?page=1");
		XmlPath path = new XmlPath(res.asString());
		List<String> traveller = path.getList("TravelerinformationResponse.travelers.Travelerinformation");
		System.out.println(traveller.size());
		Assert.assertEquals(traveller.size(), 10);
		List<String> name = path.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		for (String getName : name) {
			System.out.println(getName);
		}

	}
}
