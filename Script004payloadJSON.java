package restAssureScript;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;

public class Script004payloadJSON {
	
	@Test
	public void postusingJSON()
	{
		
		JSONObject body = new JSONObject();
		body.put("name", "mark");
		body.put("salary", "14567");
		body.put("age", "30");
		
		int responseid =RestAssured.given()
		.baseUri("https://dummy.restapiexample.com/api/v1")
		.contentType(ContentType.JSON)
		.body(body.toString())
		.when().post("/create")
		.then()
		.statusCode(200)
		.log().all()
		.body("data.name", equalTo("mark")) 
		.extract().path("data.id");
	
	System.out.println(responseid);
		
	}

}
