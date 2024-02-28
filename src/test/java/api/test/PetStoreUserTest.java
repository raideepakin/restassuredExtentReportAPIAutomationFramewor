package api.test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class PetStoreUserTest {

	User user = new User();
	public static String username ="deepakr";
	
@BeforeClass
	public void beforeCLass() {
	user.setUsername(username);
	user.setFirstName("Deepak");
	user.setLastName("Rai");
	user.setEmail("user#example.com");
	user.setPassword("secret password");
	user.setPhone("9090909090");
	

	}
@Test
public void createUser() {
	
	Response response = UserEndPoints.createUser(user);
	
	System.out.println(response.getStatusCode());
}
@Test(dependsOnMethods = { "createUser" })
public void getUser() {
	Response response = UserEndPoints.readUser(user.getUsername());
	
	System.out.println(response.asPrettyString());
//	
	response.then().body("username",equalTo(username));
	
	
}



}
