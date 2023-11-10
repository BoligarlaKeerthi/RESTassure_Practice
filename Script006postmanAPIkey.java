package restAssureScript;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Script006postmanAPIkey {
	
	@Test(priority='1')
	public void postmangetreq()
	{
		String PMapikey = "PMAK-65447db779872f00312cdd87-7edc5fe9eab24ced97d2cfb6eb474d7b34";
		given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("X-API-Key", PMapikey)
		.when().get()
		.then().statusCode(200).log().all();
		
		
	}
	
	
	@Test(priority='2')
	public void extract_value_response()
	{
		String PMapikey = "PMAK-65447db779872f00312cdd87-7edc5fe9eab24ced97d2cfb6eb474d7b34";
		
		String responseoutput = given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("X-API-Key", PMapikey)
		.when().get()
		.then()
		.extract().path("workspaces[1].name"); // extracting the name and save it in a string
		
		System.out.println("The name of the workspace extracted is: " + responseoutput);
		
	}
	
	
	

	@Test(priority='3')
	public void extract_response_JSONPath()
	{
		String PMapikey = "PMAK-65447db779872f00312cdd87-7edc5fe9eab24ced97d2cfb6eb474d7b34";
		
		Response res = given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("X-API-Key", PMapikey)
		.when().get()
		.then()
		.extract().response(); // extracting the response and save it in a Response object
		
		JsonPath json = new JsonPath(res.asString());
		
		System.out.println(json.getString("workspaces[1]"));
		
	}
}
	