package Day4;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.github.scribejava.core.model.Response;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class parseJSONResponse {
	@Test
	void testJsonResponse() {
//		// Appoach1
//		given().contentType("ContentType.JSON").when().get("http://localhost:3000/store").then().statusCode(200)
//				.header("Content-Type", "application/json; charset=utf-8")
//				.body("book [3].title", equalTo("The Lord of the Rings"));
		// Approach2

		io.restassured.response.Response res = given().contentType(ContentType.JSON).when()
				.get("http://localhost:3000/store");
		Assert.assertEquals(res.getStatusCode(), 200); // validation 1
		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
		String bookname = res.jsonPath().get("book [3].title").toString();
		Assert.assertEquals(bookname, "The Lord of the Rings");
	}

	@Test
	void testJsonResponseBodyData() {
		io.restassured.response.Response res = given().contentType(ContentType.JSON).when()
				.get("http://localhost:3000/store");
		// using JSONObject class
		JSONObject jo = new JSONObject(res.toString()); // converting response to JSON Object
		// print all titles of books
		for (int i = 0; i < jo.getJSONArray("book").length(); i++) {
			String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println(bookTitle);
			// search for title of the book in json validation 1
			boolean status = false;
			for (int j = 0; j < jo.getJSONArray("book").length(); j++) {
				String bookTitle1 = jo.getJSONArray("book").getJSONObject(j).get("title").toString();
				if (bookTitle1.equals("The Lord of the Ring"))
					;
				{
					status = true;
					break;
				}
			}
		}
	}
}
