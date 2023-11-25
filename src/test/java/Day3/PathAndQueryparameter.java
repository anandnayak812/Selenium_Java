package Day3;

import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class PathAndQueryparameter {
	@Test
	void testQueryAndPathParameters() {
		given().pathParam("mypath", "users") // path parameters
				.queryParam("page", 2) // query parameter
				.queryParam("id", 3) // query parameters I
				.when().get("https://reqres.in/api/{mypath}").then().statusCode(200).log().all();
	}

}
