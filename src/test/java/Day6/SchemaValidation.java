package Day6;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;

public class SchemaValidation {
	@Test
	void JsonSchemavalidation() {
		// For XML Validation Schema
		// https://www.youtube.com/watch?v=CyPsHcvl0vE&list=PLUDwpEzHYYLuW9XEvFEJk2kqsk6HqscI4&index=16
		
		//For Serialization and DeSerilization 
		//https://www.youtube.com/watch?v=CyPsHcvl0vE&list=PLUDwpEzHYYLuW9XEvFEJk2kqsk6HqscI4&index=17
		
		given()

			 	.when().get(" http://localhost:3000/students")

				.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchema.json"));

	}

}
