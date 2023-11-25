package Day2;

import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class DiffwaytoCreatePostRequest {
	/*
	 * Different ways to create POST request body 1) Post request body using Hashmap
	 * 2) Post request body creation using using org.JSON 3) Post request body
	 * creation using POJO class 4) Post request using external json file data
	 */
	// 1) Post request body using Hashmap
	@Test(priority = 1)
	void testPostusingHashMap() {
		HashMap data = new HashMap();
		data.put("name", "Anand");
		data.put("location", "France");
		data.put("phone", "123456");
		String courseArr[] = { "C", "C++" };
		data.put("courses", courseArr);
		given().contentType("application/json").body(data).when().post("http://localhost:3000/students").then()
				.statusCode(201).body("name", equalTo("Anand")).body("location", equalTo("France"))
				.body("phone", equalTo("123456")).body("courses[0]", equalTo("C")).body("courses [1]", equalTo("C++"))
				.header("Content-Type", "application/json; charset=utf-8").log().all();
	}

	// deleting |
	@Test(priority = 2)
	void testDelete() {
		given().when().delete("http://localhost:3000/students").then().statusCode(404);
	}
	
	//Using org.JSON
	//@Test(priority = 3)
	void testPostusingJSON() {
		JSONObject data = new JSONObject();
		data.put("name", "Scott");
		data.put("location", "France");
		data.put("phone", "123456");
		String courseArr[] = { "C", "C++" };
		data.put("courses", courseArr);
		given().contentType("application/json").body(data.toString()).when().post("http://localhost:3000/students").then()
				.statusCode(201).body("name", equalTo("Scott")).body("location", equalTo("France"))
				.body("phone", equalTo("123456")).body("courses[0]", equalTo("C")).body("courses [1]", equalTo("C++"))
				.header("Content-Type", "application/json; charset=utf-8").log().all();
	}

	// deleting |
	//@Test(priority = 4)
	void testDeleteJson() {
		given().when().delete("http://localhost:3000/students/4").then().statusCode(200);
	}
}
