package APITraining;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ComplexResponseBodyValidation {

    @Test
    public void complexResponseBodyValidationGet() {

        String endPoint = "http://localhost:8888/api_testing/category/read.php";
        given().
                queryParam("id", 26).
                when().
                get(endPoint).
                then().
                log().body().
                assertThat().
                statusCode(200).
                body("records.size", greaterThan("0")).
                body("records.id", everyItem(notNullValue())).
                body("records.name", everyItem(notNullValue()));


    }
}
