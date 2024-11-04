package APITraining;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PutRequest {


    @Test
    public void updateProduct() {

        String endPoint = "http://localhost:8888/api_testing/category/read.php";
        
        String body = """
                {
                "id": 19,
                "description": "Blue Bottle with open cap",
                "price": 15,
                "category"; "Bottles"            
                }
                """;

        var response = given().body(body).when().put(endPoint).then();
        response.log().body();
    }


}
