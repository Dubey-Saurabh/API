package APITraining;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class HeadersValidation {

    @Test
    public void complexResponseBodyValidationGet() {

        String endPoint = "https://automationexercise.com/api/productsList";
        given().
                 queryParam("id", 19).
                when().
                get(endPoint).
                then().
                log().headers().
                assertThat().
                statusCode(200).
                headers("content-type", equalTo("text/html; charset=utf-8"));
    }
}
