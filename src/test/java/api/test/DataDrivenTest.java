package api.test;

import api.endPoints.UserEndPoints;
import api.payloads.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataDrivenTest {
    @Test(dataProvider="Data", dataProviderClass=DataProviders.class)
    public void testPostUser(String userId,String userName, String userFirstName,String userLastName,String userEmail,String userPassword,String userPhoneNumber )
    {
        User payloads=new User();
        payloads.setId(Integer.parseInt(userId));
        payloads.setUsername(userName);
        payloads.setFirstName(userFirstName);
        payloads.setLastName(userLastName);
        payloads.setEmail(userEmail);
        payloads.setPassword(userPassword);
        payloads.setPhone(userPhoneNumber);
        Response response= UserEndPoints.createUser(payloads);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test(priority=1,dataProvider = "UserName",dataProviderClass = DataProviders.class)
    public void testDeleteUser(String userName)
    {
        Response response=UserEndPoints.deleteUser(userName);
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
