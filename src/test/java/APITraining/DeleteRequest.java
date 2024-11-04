package APITraining;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteRequest {

    @Test
    public void deleteProduct() {

        String endPoint = "https://automationexercise.com/api/productsList";

        String body = """
                {
                "id": 19      
                }
                """;

        var response = given().body(body).when().delete(endPoint).then();
        response.log().body();
    }
}
