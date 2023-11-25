package Day3;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.github.scribejava.core.model.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class Cookies {
	//@Test(priority = 1)
	void cookies_Path() {
		given()

				.when().get("https://www.google.com/").then().log().all();
	}

	@Test(priority = 1)
	void Singlecookies_Path() {
		io.restassured.response.Response res =given()

				.when().get("https://www.google.com/");
		
		String cookies_Single = res.cookie("AEC"); 
		System.out.println(cookies_Single);
		
		// get all cookies info
		Map<String, String> cookies_values=res.getCookies();
		//System.out.println(cookies_v es_values, keySet());
		for (String k :cookies_values.keySet())
		{
		String cookie_value=res.getCookie(k);
		System.out.println(k+" "+cookie_value);
		}
	}
}
