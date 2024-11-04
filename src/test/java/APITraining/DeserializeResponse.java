package APITraining;

import Models.ProductBody;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DeserializeResponse {

    @Test
    public void complexResponseBodyValidationGet() {

        String endPoint = "http://localhost:8888/api_testing/category/read.php";

        ProductBody expectedProduct = new ProductBody(
                3,
                "Skate band",
                "Skate band in red color",
                19,
                3,
                "Great bands"

        );


        ProductBody actualProduct = given().
                queryParam("id", 26).
                when().
                get(endPoint).as(ProductBody.class);

        assertThat(actualProduct, samePropertyValuesAs(expectedProduct));

    }
}
