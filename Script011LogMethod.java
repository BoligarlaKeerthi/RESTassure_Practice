package restAssureScript;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Script011LogMethod {
	
	@Test(priority='1')
	public void loggingmethods()
	{
		String PMapikey = "PMAK-65447db779872f00312cdd87-7edc5fe9eab24ced97d2cfb6eb474d7b34";
		given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("X-API-Key", PMapikey)
		.when().get()
		//.then().statusCode(200).log().headers()
		//.then().log().ifError()
		//.then().statusCode(200).log().cookies();
		.then().statusCode(200).log().all();
		
		
	}

}


