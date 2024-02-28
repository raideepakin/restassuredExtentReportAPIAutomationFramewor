package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UsersGetResponseTests {

	Faker faker;
	User userPayload;
	
	public Logger logger; // for logs
	@BeforeClass
	public void setup() {
		faker = new Faker();
		userPayload = new User();

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());

		// logs
		logger = LogManager.getLogger(this.getClass());

		logger.debug("Assertion of GET Request Response");
		

	}

	@Test(enabled=true)
public void getResponse() {
		Response response = UserEndPoints.newReadUser(this.userPayload.getUsername());
		response.then().log().all();
		System.out.println("************************************");
		System.out.println(response.getBody().asPrettyString());
		System.out.println("************************************");
}

}
