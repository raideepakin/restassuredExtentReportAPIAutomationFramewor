package api.endpoints;

import io.restassured.response.Response;

import api.payload.ToDo;
import static io.restassured.RestAssured.given;
import api.payload.ReqResUserData;
import api.payload.User;
import api.payload.User1;
import api.payload.UserNew;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;

public class TodoEndPoints {

	
public  Response postRequest(ToDo payLoad) {
	
	 Response response = given().contentType(ContentType.JSON)
	 .accept(ContentType.JSON)
	 .body(payLoad)
	 .when()
	 .post(ToDoRoutes.postRoute);
	 return response;
	
	
}

public Response userLogin(UserNew user) {
	Response response = given().contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(user).log().all()
			.when()
			.post(RoutesNew.user_login_url);
	return response;
	
}


public static  Response getWithParamsRequest(int limit , int skip) {
	Response response = given()
			.pathParam("limit", limit)
			.pathParam("skip", skip)
			.when().log().all()
			.get(ToDoRoutes.getwithParamsRoute);
	return response;
	
}






public static Response getRequest(int TodoId) {
	
	Response result =  given()
			.pathParam("todoId", TodoId)
			.when().get(ToDoRoutes.getRoute);
	return result;
}

public static Response  putRequest(int todo_id, ToDo payload) {
	
	Response response =  given()
	.pathParam("todoId", todo_id).body(payload)
	
	.when()
	.put(ToDoRoutes.putRoute);
	return response;
}

public static  Response deleteTodo(int todo_id) {
	
	System.out.println(todo_id);
	
	return given().log().all()
	.pathParam("todoId", todo_id)
	.when()
	.delete(ToDoRoutes.deleteRoute);
	
}

public static Response loginEndpoint(UserNew user) {
	
	return given().contentType(ContentType.JSON).accept(ContentType.JSON)
	.body(user).when().post(ToDoRoutes.loginUrl);
	
}

public static Response getAuthUser(String token) {
	
	return given().header("Authorization",token)
			.when().get(ToDoRoutes.getCurentAuthUser);
}

}












