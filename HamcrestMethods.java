package restAssureScript;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class HamcrestMethods {
	
public void containsMethod() {
		
		given()
			.baseUri("https://api.postman.com")
			.header("x-Api-key","PMAK-65447db779872f00312cdd87-7edc5fe9eab24ced97d2cfb6eb474d7b34")
		.when()
			.get("/workspaces").
		then()
			.statusCode(200)
			
			.body("workspaces.name", contains("My Workspace", "API Testing" 
					));
	}
	
	//@Test
	public void emptyMethod() {
		
		given()
			.baseUri("https://api.postman.com")
			.header("x-Api-key","PMAK-65447db779872f00312cdd87-7edc5fe9eab24ced97d2cfb6eb474d7b34")
		.when()
			.get("/workspaces").
		then()
			.statusCode(200)
			
			.body("workspaces.name", empty());
	}

	
	@Test
	public void isNotemptyMethod() {
		
		given()
			.baseUri("https://api.postman.com")
			.header("x-Api-key","PMAK-65447db779872f00312cdd87-7edc5fe9eab24ced97d2cfb6eb474d7b34")
		.when()
			.get("/workspaces").
		then()
			.statusCode(200)
			
			.body("workspaces.name", is(not(empty())));
	}
	
	@Test
	public void hassizeMethod() {
		
		given()
			.baseUri("https://api.postman.com")
			.header("x-Api-key","PMAK-61a45a21d78bd6003bdb8b21-eeb7d995daa78cb4767c6cf6828ae6eb66")
		.when()
			.get("/workspaces").
		then()
			.statusCode(200)
			
			.body("workspaces.name", hasSize(5));
	}
	
	
	//@Test
	public void everyItemStartsWithMethod() {
		
		given()
			.baseUri("https://api.postman.com")
			.header("x-Api-key","PMAK-61a45a21d78bd6003bdb8b21-eeb7d995daa78cb4767c6cf6828ae6eb66")
		.when()
			.get("/workspaces").
		then()
			.statusCode(200)
			
			.body("workspaces.name", everyItem(startsWith("My")));
	}



public void hasKeyMethod() {
	
	given()
		.baseUri("https://api.postman.com")
		.header("x-Api-key","PMAK-61a45a21d78bd6003bdb8b21-eeb7d995daa78cb4767c6cf6828ae6eb66")
	.when()
		.get("/workspaces").
	then()
		.statusCode(200)
		
		.body("workspaces[0]", hasKey("id"));
}
@Test
public void hasvalueMethod() {
	
	given()
		.baseUri("https://api.postman.com")
		.header("x-Api-key","PMAK-61a45a21d78bd6003bdb8b21-eeb7d995daa78cb4767c6cf6828ae6eb66")
	.when()
		.get("/workspaces").
	then()
		.statusCode(200)
		
		.body("workspaces[0]", hasValue("personal"));
}

@Test
public void hasKeyValueMethod() {
	
	given()
		.baseUri("https://api.postman.com")
		.header("x-Api-key","PMAK-61a45a21d78bd6003bdb8b21-eeb7d995daa78cb4767c6cf6828ae6eb66")
	.when()
		.get("/workspaces").
	then()
		.statusCode(200)
		
		.body("workspaces[0]", hasEntry("name", "My Workspace"));
}









@Test
public void AnyofMethod() {
	
	given()
		.baseUri("https://api.postman.com")
		.header("x-Api-key","PMAK-61a45a21d78bd6003bdb8b21-eeb7d995daa78cb4767c6cf6828ae6eb66")
	.when()
		.get("/workspaces").
	then()
		.statusCode(200)
		
		.body("workspaces.name", anyOf(startsWith("My"), containsString("Workspace")));
}


}
