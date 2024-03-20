package API.RestAssuredAPI;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HTTPRequest {
	
	int id;
	@Test(priority=1)
	public void getUser() {

		given()
		.when().get("https://reqres.in/api/users?page=2")
		.then()
		  .statusCode(200)
		  .body("page", equalTo(2))
		  .log().all();
	}
	
    @Test(priority = 2)
	public void createUser() {
		HashMap data = new HashMap();
		data.put("name", "muna");
		data.put("job", "qa");
		
       id = given()
    	  .contentType("Application/json")
    	  .body(data)
    	
 	   .when()
 	      .post("https://reqres.in/api/users")
 	      .jsonPath().getInt("id");
 	   
	}
     
     @Test(priority = 3 ,dependsOnMethods = "createUser")
 	public void UpdateUser() {
 		HashMap data = new HashMap();
 		data.put("name", "amal");
 		data.put("job", "qc");
 		
        given()
     	  .contentType("Application/json")
     	  .body(data)
     	
  	   .when()
  	      .put("https://reqres.in/api/users/"+ id)
  	   
  	  .then()
  		  .statusCode(200)
  		  .log().all();
 	}
     
     @Test(priority = 4 )
  	public void deleteUser() {
  		
        given()
      	  
   	   .when()
   	      .delete("https://reqres.in/api/users/"+ id)
   	   
   	  .then()
   		  .statusCode(204)
   		  .log().all();
  	}
}
