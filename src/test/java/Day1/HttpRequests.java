package Day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

/*
 * RestAssured - https://github.com/rest-assured/rest-assured/wiki
 * request - https://reqres.in/
 * https://reqres.in/api/users/2
 */
public class HttpRequests {
	int id;

	 @Test(priority=1)
	void getUsers() {
		given()
		
    	.when()
				.get("https://reqres.in/api/users?page=2")
				
		.then()
				.statusCode(200)
				.body("page", equalTo(2))
				.log().all();
	}

	@Test(priority=2)
	void createUser() {
		HashMap mp = new HashMap();
		mp.put("name", "Anand");
		mp.put("type", "Automation");
		id = given()
				.contentType("application/json").body(mp)
			.when()
				.post("https://reqres.in/api/users")
				.jsonPath().getInt("id");
//		.then()
//				.statusCode(201).log().all();
	}
	@Test(priority=3,dependsOnMethods= {"createUser"})
	void updateUser() {
		HashMap mp = new HashMap();
		mp.put("name", "Anand");
		mp.put("type", "Developer");
		  given()
				.contentType("application/json")
				.body(mp)
		 .when()
		        .put("https://reqres.in/api/users/"+id)
		 .then()
				.statusCode(200)
				.log().all();
	}
	@Test(priority=4,dependsOnMethods= {"updateUser"})
	void deleteUser() {
		given()
		
		.when()
		  .delete("https://reqres.in/api/users/"+id)
		  
		.then()
		    .statusCode(204)
		    .log().all();
	}

}
