package api.endPoints;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

//User Endpoints
// Created to perform CRUD operations
public class UserEndPoints {
    public static Response createUser(User payload)
    {
       Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when().post(Routers.post_url);
       return response;
    }
    public static Response readUser(String username)
    {
        Response response= given()
                .pathParam("username",username)

                .when().get(Routers.get_url);
        return response;
    }
    public static Response updateUser(String username, User payload)
    {
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .pathParam("username",username)
                .when().put(Routers.update_url);
        return response;
    }
    public static Response deleteUser(String username)
    {
        Response response= given()
                .pathParam("username",username)
                .when().delete(Routers.delete_url);
        return response;
    }


}
