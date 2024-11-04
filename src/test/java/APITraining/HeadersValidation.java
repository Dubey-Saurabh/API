package APITraining;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class HeadersValidation {

    @Test
    public void complexResponseBodyValidationGet() {

        String endPoint = "http://localhost:8888/api_testing/category/read.php";
        given().
                 queryParam("id", 26).
                when().
                get(endPoint).
                then().
                log().headers().
                assertThat().
                statusCode(200).
                headers("content-type", equalTo("application/json; charset=utf-8"));
    }
}
