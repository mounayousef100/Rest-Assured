package API.RestAssuredAPI;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParsinhXMLResponse {
	//Apposch1
	//@Test
	void testXMLResponse() {
	
		/*	given()
			.when()
			 .get("http://restapi.adequateshop.com/api/Traveler?page=1")
			.then()
			  .statusCode(200)
			  .header("Content-Type","application/xml; charset=utf-8")
			  .body("TravelerinformationResponse.page", equalTo("1"))
			  .body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo));*/
		
	  //Apposch2
		Response res =
		given()
		.when()
	    	.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		Assert.assertEquals(res.statusCode(),200);
		Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
	    String pageNumber = res.xmlPath().get("TravelerinformationResponse.page").toString();
	    String travelName = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		Assert.assertEquals(pageNumber,"1");
		Assert.assertEquals(travelName,"Developer");
		
	}
	
	@Test
	void testXMLResponseBody() {
	
		
		Response res =
		given()
		.when()
	    	.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		XmlPath xmlobj = new XmlPath(res.asString());
		List<String> travellers = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation");
		Assert.assertEquals(travellers.size(), 10);
		
		List<String> travelNames = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		boolean status = false;
		 for(String travelN :travelNames)
		 {
			 if(travelN.equals("Developer"))
			 {
				 status = true;
				 break;
			 }
		 }
		Assert.assertEquals(status, true);
	}
}
