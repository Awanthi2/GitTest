package testScripts;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.mapper.factory.JsonbObjectMapperFactory;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetRequestSample {
  @Test
  public void testResposeStatus() {
	  RequestSpecification request=RestAssured.given();
	  request.baseUri("https://demoqa.com/utilities/weather/city");
	  Response response=request.get("/chennai");
	  String resString=response.asString();
	  System.out.println("Response:"+resString);
	 ValidatableResponse valRes=response.then();
	 valRes.statusCode(200);
	 JsonPath jsonob=response.jsonPath();
	 System.out.println("City:"+jsonob.get("city"));
	
  }
  
  @Test
  public void testResposeBDD()
  {
	  RestAssured.given().baseUri("https://demoqa.com/utilities/weather/city").when()
	  .get("Hyderabad").then().statusCode(200);
  }
}

