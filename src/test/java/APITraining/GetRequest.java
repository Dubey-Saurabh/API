package APITraining;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest {

    //Get complete response body
    @Test
    public void getAllCategories() {
        String endPoint = "https://reqres.in/api/users?page=2";
        var response = given().when().get(endPoint).then();
        response.log().body();

    }
    //Validating response via status code
    @Test
    public void responseValidationViaStatusCode() {
        String endPoint = "https://reqres.in/api/users?page=2";
        var response = given().when().get(endPoint).then().statusCode(200);
        response.log().body();

    }

    //Validating response via status code and with response parameter value
    @Test
    public void responseValidationViaStatusCodeAndWithJsonResponseParameter() {
        String endPoint = "https://reqres.in/api/users?page=2";
        var response = given().when().get(endPoint).then().statusCode(200).body("page",equalTo(2)).log().body();

    }
    @Test
    public void getProduct() {
        String endPoint = "http://localhost:8888/api_testing/category/read.php";
        var response = given().queryParam("id", 2).when().get(endPoint).then();
        response.log().body();

    }

}
