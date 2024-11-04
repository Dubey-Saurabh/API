package APITraining;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ResponseBodyValidation {

    @Test
    public void responseBodyValidationGet() {

        String endPoint = "http://localhost:8888/api_testing/category/read.php";
               given().
                   queryParam("id", 26).
                when().
                    get(endPoint).
                then().
                    assertThat().
                       statusCode(200).
                          body("id", equalTo("26")).
                          body("name", equalTo("Sweat band"));

    }
}
