package testScripts;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class postRequestTest {
  @Test
  public void post() {
	  RestAssured.baseURI="https://reqres.in/api/users";
	  JSONObject jsonobj=new JSONObject();
	  jsonobj.put("name", "TestUser");
	  jsonobj.put("job", "TestArchitect");
	  Response response=RestAssured.given().accept(ContentType.JSON)
			  .contentType("Application/json").and()
			  .body(jsonobj.toString())
			  .post();
	  System.out.println("Status Code:"+response.getStatusCode());
	  org.testng.Assert.assertEquals(201, response.getStatusCode());
  }
  @Test
  public void postWithAuth() {
	  RestAssured.baseURI="https://gorest.co.in/public/v2/users";
	  JSONObject jsonobj=new JSONObject();
	  jsonobj.put("name", "TestUser");
	  jsonobj.put("email", "testin0g123@gmail.com");
	  jsonobj.put("gender", "Female");
	  jsonobj.put("status", "Active");
	  Response response=RestAssured.given()
			  .header("Authorization", "Bearer e73f7dee774d2fdff9f47843a362b60d8be4b9fa56cb1afe6ee11297a41ec20a")
			  .accept(ContentType.JSON)
			  .contentType("Application/json").and()
			  .body(jsonobj.toString())
			  .post();
	  System.out.println("Status Code:"+response.getStatusCode());
	  org.testng.Assert.assertEquals(201, response.getStatusCode());
  }
  

}
