package restAssureScript;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Script007HamcrestValidateMethods {

	@Test(priority='1')
	public void ValidateRepsonseBody()
	{
		String PMapikey = "PMAK-65447db779872f00312cdd87-7edc5fe9eab24ced97d2cfb6eb474d7b34";
		given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("X-API-Key", PMapikey)
		.when().get()
		.then().statusCode(200)
		// fetch the repsonse body and validate if response includes corrrect values or not
		.body("workspaces[1].id", equalTo("9eba3f45-6289-46c7-b9bd-4b09a8dee4cd"),
			  "workspaces[1].name",equalTo("API Testing"),
			   "workspaces[1].type",equalTo("personal"));
		
		
	}
	@Test(priority='2')
	public void ValidateRepsonseBody_equlaTo()
	{
		
		given().baseUri("https://petstore.swagger.io")
		.basePath("/v2/user/Uname001")
		.when().get()
		.then().statusCode(200)
		// fetch the repsonse body and validate if response includes corrrect values or not
		.body("username", equalTo("Uname001"),
			  "email", equalTo("Positive@Attitude.com"),
			  "userStatus", equalTo(1));
		
		
	}
	
	
	
	
	@Test(priority='3')
	public void ValidateRepsonseBody_hasitems()
	{
		String PMapikey = "PMAK-65447db779872f00312cdd87-7edc5fe9eab24ced97d2cfb6eb474d7b34";
		given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("X-API-Key", PMapikey)
		.when().get()
		.then().statusCode(200)
		// fetch the repsonse body and validate if response includes corrrect values or not
		.body("workspaces.name", hasItems("My Workspace","API Testing"),
				"workspaces.type", hasItems("personal","personal"));
		
		
	}
	
	
	
}
