package com.asp.stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import com.asp.pojo.AddPlace;
import com.asp.pojo.Location;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RSAMap {

	static Response response;
	static RequestSpecification rs;

	@Given("Add Place Payload")
	public void add_place_payload() {

		AddPlace ap = new AddPlace();

		Location location = new Location();
		location.setLat(-38.383494);
		location.setLng(33.345678);

		List<String> l = new ArrayList<>();
		l.add("shoe park");
		l.add("shop");

		ap.setTypes(l);
		ap.setAccuracy(50);
		ap.setAddress("3rd Main, B Channasadra, Bengaluru");
		ap.setLanguage("English-IN");
		ap.setLocation(location);
		ap.setName("Anjan");
		ap.setPhone_number("+91 8576565357");
		ap.setWebsite("http://google.com");

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		rs = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").body(ap);
	}

	@When("user calls AddPlaceAPI with Post http request")
	public void user_calls_with_post_http_request() {
		response = rs.when().post("maps/api/place/add/json");
	}

	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		response.then().log().all().assertThat().statusCode(int1);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is_ok(String string1, String string2) {
		response.then().body(string1, equalTo(string2));
	}
}
