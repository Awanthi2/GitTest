package testScripts;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class basicAuthTest {
	@Test(enabled = false)
	public void preemtiveTest() {
		RestAssured.given().auth().preemptive().basic("postman", "password").when()
				.get("http://postman-echo.com/basic-auth").then().log().body();
	}

	@Test(enabled = false)
	public void challengedTest() {
		RestAssured.given().auth().basic("postman", "password").when().get("http://postman-echo.com/basic-auth").then()
				.log().body();
	}

	// f1ce728b07ef3fa3ee2805305d5fd9b1
	@Test(enabled = false)
	public void getWeatherwithAPIKey() {
		RestAssured.given().queryParam("q", "Ongole").queryParam("appid", "f1ce728b07ef3fa3ee2805305d5fd9b1").when()
				.get("https://api.openweathermap.org/data/2.5/weather").then().log().body();
	}

	@Test(enabled = false)
	public void validateCountry() {
		String strCountry = RestAssured.given().queryParam("q", "Ongole")
				.queryParam("appid", "f1ce728b07ef3fa3ee2805305d5fd9b1").when()
				.get("https://api.openweathermap.org/data/2.5/weather").then().extract().path("sys.country");
		Assert.assertTrue(strCountry.equalsIgnoreCase("IN"));
	}

	@Test(enabled = false)
	public void getWeather() {
		String mainWeather = RestAssured.given().queryParam("q", "Ongole")
				.queryParam("appid", "f1ce728b07ef3fa3ee2805305d5fd9b1").when()
				.get("https://api.openweathermap.org/data/2.5/weather").then().extract().path("weather[0].main");
		// Assert.assertTrue(strCountry.equalsIgnoreCase("IN"));
		System.out.println("Main Weather is :" + mainWeather);
	}

	@Test
	public void updateUser() {
		int userId = 2;
		RestAssured.baseURI = "https://reqres.in/api/users";
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "Peter");
		requestParams.put("job", "Project Leader");
		Response resp = RestAssured.given().accept(ContentType.JSON).contentType("Application/json").and()
				.body(requestParams.toString()).put("/2");
		System.out.println("Status Code:" + resp.getStatusCode());
		Assert.assertTrue(resp.asString().contains("Project Leader"));

	}
	@Test
	public void deleteUser() {
		int userId = 2;
		RestAssured.baseURI = "https://reqres.in/api/users";
				Response resp = RestAssured.given().delete("/2");
		System.out.println("Status Code:" + resp.getStatusCode());
		//Assert.assertTrue(resp.asString().contains("Project Leader"));

	}
}
