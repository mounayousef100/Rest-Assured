package API.RestAssuredAPI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;



public class ParsingJsonResponsData {

   //Apposch1
	@Test(priority = 1)
	void testJsonResponse() {
		
		given()
		  .contentType("ContentType.JSON")
     	.when()
		 .get(" http://localhost:3000/posts/50")
		.then()
		 .statusCode(200)
		 .header("Content-Type","application/json; charset=utf-8")
	     .body("title",equalTo("Rest API"));
		
	}
	
   //Apposch2
	@Test(priority = 2)
	void testJsonResponseBodyData() {
		
		Response res =  given()
		  .contentType("ContentType.JSON")
     	.when()
		 .get(" http://localhost:3000/posts/50");
	/*	Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
		String title = res.jsonPath().get("title").toString();
		Assert.assertEquals(title,"Rest API");*/
		
  //JSONObject Class
		JSONObject jo = new JSONObject(res.toString());
		
	}
	

}
