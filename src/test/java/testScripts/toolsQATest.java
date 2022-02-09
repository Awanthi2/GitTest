package testScripts;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class toolsQATest {
	@Test(enabled = false)
	public void getBooks() {

		// https://bookstore.toolsqa.com/BookStore/v1/Books
		RestAssured.baseURI = "https://bookstore.toolsqa.com/BookStore/v1/Books";
		RestAssured.given().get().then().log().body();
	}

	@Test
	public void getAuthToken() {
		// https://demoqa.com/Account/v1/Authorized
		RestAssured.baseURI = "https://demoqa.com/Account/v1/GenerateToken";
		JSONObject requestParam = new JSONObject();
		requestParam.put("userName", "TOOLSQA-Test");
		requestParam.put("password", "Test@@123");
		Response response = RestAssured.given().accept(ContentType.JSON).contentType("Application/json").and()
				.body(requestParam.toString()).post();
		// System.out.println("RZesponse recieved:"+response.asString());

		JsonPath jsonob = response.jsonPath();

		System.out.println("Token:" + jsonob.get("token"));
	}

	@Test
	public void authorizeUser() {
		//https://bookstore.toolsqa.com/Account/v1/User
		RestAssured.baseURI="https://bookstore.toolsqa.com/Account/v1/User";
		JSONObject requestParam = new JSONObject();
		requestParam.put("userName", "Awanthii");
		requestParam.put("password", "Aadivik@18");
		Response response = RestAssured.given().accept(ContentType.JSON).contentType("Application/json").and()
				.body(requestParam.toString()).post();
		// System.out.println("RZesponse recieved:"+response.asString());

		JsonPath jsonob = response.jsonPath();

		System.out.println("User Id:" + jsonob.getUUID("userID"));
	}
}
