package api.endpoints;

import io.restassured.response.Response;


import static io.restassured.RestAssured.given;
import api.payload.ReqResUserData;
import api.payload.User;
import api.payload.User1;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;



public class ReqResEndPoints {


	
	// get request
	public static Response readUser(String userName)
	{

		Response response=given()
						
		.when()
			.get(RoutesNew.get_url);
			
		return response;
	}
	// post request
	public static Response createser(User1 payload) {
		
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			.when()
				.post(Routes.post_url);
				
			return response;
		
	}
	// put request
public static Response editUser(int id , User1 body) {
	
Response response = given()
.pathParam("userId", id)
.contentType(ContentType.JSON)
.accept(ContentType.JSON)

.put(RoutesNew.put_url);
return response;

	
}
// delete request
public static Response deleteUser(int id) {
	
	Response response=given()
			.pathParam("userId",id)
.when()
.delete(RoutesNew.delete_url);

return response;
	
}

}
