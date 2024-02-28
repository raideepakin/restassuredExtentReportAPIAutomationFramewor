package api.test;

import static org.hamcrest.Matchers.equalTo;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import api.endpoints.TodoEndPoints;
import api.payload.ToDo;
import api.payload.UserNew;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ToDoTests {
	
	public static String token = null;
	UserNew user = new UserNew();
	ToDo todoPayload = new ToDo();
	TodoEndPoints endpoints = new TodoEndPoints();
	


	
	
@BeforeClass
public void beforeClass() {
	todoPayload.setTodo("DummyJSON in the project");
	todoPayload.setCompleted(true);
	todoPayload.setUserId(5);

	
	
}
@Test
public void createTodo() {
	Response response = endpoints.postRequest(todoPayload);
	
	response.then().log().all();
	System.out.println(response.getStatusCode());
	System.out.println(response.getBody().prettyPrint());
	
	response.then().body("userId",equalTo(5));
	
	
	
}
	
@Test
public void  getTodo() {
	
	Response response = TodoEndPoints.getRequest(1);
	
	response.then().log().all();
	System.out.println(response.getStatusCode());
	System.out.println(response.asPrettyString());
	response.then().body("id",equalTo(1));
	response.then().body("userId",equalTo(26));


}
@Test
public void getWIthParams() {
	
	
	Response response  = TodoEndPoints.getWithParamsRequest(3,10);
	
	
	response.then().log().all();
	System.out.println(response.getStatusCode());
	System.out.println(response.body().asPrettyString());
	response.then().body("todos[2].completed",equalTo(false));
	
	
	
	
}

@Test
public void EditTodo() {
	
	ToDo updatePayload = new ToDo();
	todoPayload.setCompleted(false);
	
	
	todoPayload.setId(1);
	
	Response response = TodoEndPoints.putRequest(1, updatePayload);
	response.then().log().all();
	
	Assert.assertEquals(response.getStatusCode(), 200);
	

	response.then().body("completed",equalTo(true));
	response.then().body("id",equalTo(1));



}
@Test
public void deleteTodo() {
	
	Response response = TodoEndPoints.deleteTodo(1);
	response.then().log().all();
	response.then().body("completed",equalTo(true));
	response.then().body("id",equalTo(1));
}

@Test
public void loginTest() {
	
	UserNew user = new UserNew();
	
	user.setUsername("kminchelle");
	user.setPassword("0lelplR");
	
	Response response = TodoEndPoints.loginEndpoint(user);
	

	
	
	token = response.then().extract().path("token");
	
	
}
@Test(dependsOnMethods = { "loginTest" })
public void getProtectedData() {
	

	Response response = TodoEndPoints.getAuthUser(token);

	response.then().body("age",equalTo(27)); // asserting 27 instead of 26 to fail deliberately
	response.then().body("firstName",equalTo("Jeanne"));
	Assert.assertEquals(response.getStatusCode(), 200,"Response code assertion");
	Assert.assertEquals(response.then().extract().path("firstName"), "Jeanne","First Name assertion");
	
	
	
	
	
	
	

}











}
