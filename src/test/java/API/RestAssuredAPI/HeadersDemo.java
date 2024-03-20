package API.RestAssuredAPI;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class HeadersDemo {

	@Test(priority = 1)
	void testHeaders() {
		
		given()
		.when()
		 .get("https://www.google.com/")
		.then()
		 .header("Content-Type","text/html; charset=ISO-8859-1")
		 .and()
		 .header("Expires","-1")
		 .and()
		 .header("Cache-Control","private, max-age=0")
		 .and()
		 .header("X-Frame-Options","SAMEORIGIN")
		.log().headers();
	}
	
	
	@Test(priority = 2)
	void getHeaders() {
		
		Response res = given()
		.when()
		 .get("https://www.google.com/");
		
		 //get single header info
		//String hearerValue =  res.getHeader("Content-Type");
		//System.out.println("Value of Content-Type is :" + hearerValue);
		
		//get all header info
		Headers myHeaders = res.getHeaders();
		for(Header hd:myHeaders) {
			System.out.println(hd.getName()+"            "+hd.getValue());
		}
	}
	
}
