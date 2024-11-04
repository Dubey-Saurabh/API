package APITraining;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ComplexResponseBodyValidation {

    @Test
    public void complexResponseBodyValidationGet() {

        String endPoint = "https://automationexercise.com/api/productsList";
        given().
                queryParam("id", 42).
                when().get(endPoint).
                then().log().body().assertThat().statusCode(200).
//                body("products.id", greaterThan(0)).
                body("products.price", everyItem(notNullValue())).
                body("products.name", everyItem(notNullValue())).log().body();


    }
}
