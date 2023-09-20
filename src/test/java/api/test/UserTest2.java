package api.test;


import api.endPoints.UserEndPoints;
import api.endPoints.UserEndPoints2;
import api.payloads.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserTest2 {
    Faker faker;
    User payloads;
    public Logger logger;
    @BeforeMethod
    public void setUpData()
    {
        faker=new Faker();
        payloads=new User();
        payloads.setId(faker.idNumber().hashCode());
        payloads.setUsername(faker.name().username());
        payloads.setFirstName(faker.name().firstName());
        payloads.setLastName(faker.name().lastName());
        payloads.setEmail(faker.internet().emailAddress());
        payloads.setPassword(faker.internet().password(5,10));
        payloads.setPhone(faker.phoneNumber().cellPhone());
        logger= LogManager.getLogger(this.getClass());


    }
    @Test(priority=1)
    public void testPostReq()
    {
        logger.info("********Creating User ********");
        Response response= UserEndPoints2.createUser(payloads);
        response.then().log().all();
        ResponseBody responseBody=response.body();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("********User is created ********");

    }
   /* @Test(priority=2)
    public void testGetReq()
    {
        logger.info("********Reading User Info ********");
        Response response=UserEndPoints2.readUser(this.payloads.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json");
        logger.info("********User Info read********");
    }*/
    @Test
    public void testUpdateUserByName()
    {
        payloads.setFirstName(faker.name().firstName());
        payloads.setLastName(faker.name().lastName());
        payloads.setEmail(faker.internet().emailAddress());
        Response response=UserEndPoints2.updateUser(this.payloads.getUsername(),payloads);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200) ;
        //Checking Data afetr updation
        Response responseAfterUpdate= UserEndPoints2.readUser(this.payloads.getUsername());
        responseAfterUpdate.then().log().all();
        Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);

    }
   /* @Test
    public void testDeleteUser()
    {
        Response response= UserEndPoints2.deleteUser(this.payloads.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }*/
}
