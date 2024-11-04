package APITraining;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class StatusCodeValidation {

    @Test
    public void statusCodeValidationGet() {

        String endPoint = "http://localhost:8888/api_testing/category/read.php";
        given().queryParam("id", 26).when().get(endPoint).then().assertThat().statusCode(200);


    }
}
