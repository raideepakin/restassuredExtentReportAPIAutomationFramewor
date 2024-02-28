package api.test;

import static org.hamcrest.Matchers.equalTo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.ReqResEndPoints;
import api.payload.User;
import api.payload.User1;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class ReqResTest {

	Faker faker;
	User1 userPayload;
	public static  Logger logger; // for logs
	
	@BeforeClass
	public void setUp() {
		userPayload = new User1();
		
		userPayload.setName("morpheus");
		userPayload.setJob("leader");
		
		
		
		logger= LogManager.getLogger(this.getClass());
		
		
		
		
		
		
		
	}
	
@Test(priority=1)
	public void GetEmployeeInfo() {
	
	
	Response response = ReqResEndPoints.readUser("1");
	response.then().log().all();
	System.out.println(response.body().asPrettyString());
	response.then().body("data[0].first_name",equalTo("George"));
	response.then().body("data[0].last_name",equalTo("Bluth"));
	Assert.assertEquals(response.getStatusCode(), 200);
	System.out.println(response.getBody().asPrettyString());
	System.out.println(response.getStatusCode());
	System.out.println(response.getStatusLine());
	System.out.println(response.getTime());
	System.out.println(response.body().asPrettyString());

	ResponseBody body = response.getBody();
	System.out.println(body.asString());
	
	
	
	
	
	
	
		
	}
	
@Test(priority=2)
public void postEmployeeData() {
	Response response = ReqResEndPoints.createser(userPayload);
	System.out.println(response.getStatusCode());
	
	Assert.assertEquals(response.getStatusCode(),200);
	
}
@Test(priority=3)
public void putEmployeeData() {
	
	Response response = ReqResEndPoints.editUser(1, userPayload);
	Assert.assertEquals(response.getStatusCode(), 200);
	
}
@Test(priority=4)
public void deleteEmployee() {
	
	Response response = ReqResEndPoints.deleteUser(1);
	System.out.println(response.getStatusCode());
	Assert.assertEquals(response.statusCode(), 204);
	
	
	
}
	
	
	
	
	
}
