package API.RestAssuredAPI;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class JSONSchemaValidation {
    @Test
	void testJSONSchemaValidation() {
		given()
		.when()
		 .get("http://localhost:3000/posts")
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));
		
	}
	
}
