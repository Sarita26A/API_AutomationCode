package api.endPoints;
/*
Get User : https://petstore.swagger.io/v2/user/{username}
Create User:https://petstore.swagger.io/v2/user
Update User:https://petstore.swagger.io/v2/user/{username}
Delete User:https://petstore.swagger.io/v2/user/{username}
 */

public class Routers {
    public static String base_Url="https://petstore.swagger.io/v2";
    //User Module
    public static String post_url=base_Url+"/user";
    public static String get_url=base_Url+"/user/{username}";
    public static String update_url=base_Url+"/user/{username}";
    public static String delete_url=base_Url+"/user/{username}";

    //Store Module
    //Pet Module

}
