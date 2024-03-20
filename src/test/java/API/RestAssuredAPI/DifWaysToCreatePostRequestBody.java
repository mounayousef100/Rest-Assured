package API.RestAssuredAPI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.json.JSONTokener;

import org.testng.annotations.Test;

public class DifWaysToCreatePostRequestBody {
	
	// You can use a Map or HashMap object to represent 
  //  @Test(priority = 1)
	void testPostUsingHashMap() {
		
		HashMap data = new HashMap();
		data.put("title", "qa");
		data.put("author", "muna");
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		 .post("http://localhost:3000/posts")
		 
		.then()
		 .statusCode(201)
		 .body("title",equalTo("qa"))
		 .body("author",equalTo("muna"))
		 .header("Content-Type","application/json; charset=utf-8")
		 .log().all();
	}

	 // You can use a POJO object to represent 
	 //  @Test(priority = 1)
		void testPostUsingPOJOClass() {
			
			Pojo_PostRequest data = new Pojo_PostRequest();
			data.setTitle("HR");
			data.setAuthor("ahmad");
			
			given()
			.contentType("application/json")
			.body(data)
			
			.when()
			 .post("http://localhost:3000/posts")
			 
			.then()
			 .statusCode(201)
			 .body("title",equalTo("HR"))
			 .body("author",equalTo("ahmad"))
			 .header("Content-Type","application/json; charset=utf-8")
			 .log().all();
		}
    //org.JSON 
	 // @Test(priority = 1)
		void testPostUsingJsonLibrary() {
		  JSONObject data = new JSONObject();
			data.put("title", "qc");
			data.put("author", "amal");
			
			
			given()
			.contentType("application/json")
			.body(data.toString())
			
			.when()
			 .post("http://localhost:3000/posts")
			 
			.then()
			 .statusCode(201)
			 .body("title",equalTo("qc"))
			 .body("author",equalTo("amal"))
			 .header("Content-Type","application/json; charset=utf-8")
			 .log().all();
		}
	    
		 // You can use a External Json file to represent 
		   @Test(priority = 1)
			void testPostUsingJsonFile() throws FileNotFoundException {
				
				File f = new File(System.getProperty("user.dir")+"\\src\\test\\java\\Body.json");
				FileReader fr = new FileReader(f);
				JSONTokener jk = new JSONTokener(fr);
				JSONObject data = new JSONObject(jk);
				
				given()
				.contentType("application/json")
				.body(data.toString())
				
				.when()
				 .post("http://localhost:3000/posts")
				 
				.then()
				 .statusCode(201)
				 .body("title",equalTo("HR"))
				 .body("author",equalTo("ahmad"))
				 .header("Content-Type","application/json; charset=utf-8")
				 .log().all();
			}
  //  @Test(priority = 2)
    void testDelete() {
    	
    	given()
    	
    	.when()
    	 .delete("http://localhost:3000/posts/29")
    	
    	.then()
    	 .statusCode(200);
    }
	
	
}
