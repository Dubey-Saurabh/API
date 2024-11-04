package APITraining;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRequest {

    int id;  // to get the value of id from response just created this

    //Creating user Using String body
    @Test(priority = 1)
    public void createProduct() {

        String endPoint = "https://reqres.in/api/users";

        String body = """
                {
                "name": "Test Singh",
                "job": "Leader"
                }
                """;

        var response = given().contentType("application/json").body(body).when().post(endPoint).then().statusCode(201)
                .log().body();


    }

    //Creating user  Using body created by Hashmap
    @Test(priority = 2)
    public void createProductUsingHashmap() {

        String endPoint = "https://reqres.in/api/users";

        HashMap<String, String> body = new HashMap();
        body.put("name", "Test Tomar");
        body.put("job", "Trainer");

        //validating user is being created
       var response = given().contentType("application/json").body(body).when().post(endPoint).then().statusCode(201)
               .body("name",equalTo("Test Tomar")) .log().body();


    }

    //First we'll create the user and then we will get it iD
    @Test(priority = 3)
    public void gettingValuesFromResponse() {

        String endPoint = "https://reqres.in/api/users";

        HashMap<String, String> body = new HashMap();
        body.put("name", "Test Kumar");
        body.put("job", "HR person");

        //validating user is being created
        var id = given().contentType("application/json").body(body).when().post(endPoint)
                .jsonPath().getInt("id");

    }

    //Once user is created we will update its details
    @Test(priority = 4,dependsOnMethods = {"gettingValuesFromResponse"})
    public void updateUser() {

        String endPoint = "https://reqres.in/api/users/";

        HashMap<String, String> body = new HashMap();
        body.put("name", "Paban Kumar");
        body.put("job", "HR Manager");

        //added id of the gettingValuesFromResponse method created user to update its details
        var response = given().contentType("application/json").body(body).when().put(endPoint +id)
                .then().statusCode(200).log().body();
    }

    @Test(priority = 5)
    public void deleteUser() {

        String endPoint = "https://reqres.in/api/users";

        //added id of the gettingValuesFromResponse method created user to update its details
        var response = given().when().delete(endPoint +id)
                .then().statusCode(204).log().body();
    }

}
