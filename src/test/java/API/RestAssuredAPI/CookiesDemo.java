package API.RestAssuredAPI;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Map;
public class CookiesDemo {

	//@Test(priority = 1)
	void testCookies() {
		
		given()
		.when()
		 .get("https://www.google.com/")
		.then()
		 .cookie("AEC","Ad49MVEqpFMIGAwBPb9WekUNm722Hv5XUGp4pR4-fksYpF4uPykn0lU4SFQ")
		 .log().all();
		
	}
	
	@Test(priority = 2)
	void getCookiesInfo() {
		
		Response res =  given()
		.when()
		 .get("https://www.google.com/");
		//get single cookie
		//String Cookie_value =  res.getCookie("AEC");
	//	System.out.println("Value of cookie is : "+ Cookie_value);
		
		//get all cookies
		Map<String,String> Cookie_values =res.getCookies();
		//System.out.println("Value of cookies key is : "+ Cookie_values.keySet());
		for(String K :Cookie_values.keySet()) {
			String Cookie_value =res.getCookie(K);
			System.out.println(K + "         "+Cookie_value);
		}
		
	}
}
