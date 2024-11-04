package APITraining;

import Models.ProductBody;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SerializedRequest {

    @Test
    public void serializedRequestPost() {

        String endPoint = "http://localhost:8888/api_testing/category/read.php";
        ProductBody product = new ProductBody(
                "Sweatband",
                "Sweatband in a jar",
                5,
                3
        );

        var response = given().body(product).when().post(endPoint).then();
        response.log().body();


    }

    @Test
    public void serializedRequestPut() {

        String endPoint = "http://localhost:8888/api_testing/category/read.php";
        ProductBody product = new ProductBody(
                19,
                "Sweatband",
                "Sweatband in a jar",
                6,
                3
        );

        var response = given().body(product).when().put(endPoint).then();
        response.log().body();


    }

    @Test
    public void serializedRequestGet() {

        String endPoint = "http://localhost:8888/api_testing/category/read.php";
        var response = given().queryParam("id", 26).when().get(endPoint).then();
        response.log().body();

    }

    @Test
    public void serializedRequestDelete() {

        String endPoint = "http://localhost:8888/api_testing/category/read.php";
        ProductBody product = new ProductBody(
                26
        );

        var response = given().body(product).when().delete(endPoint).then();
        response.log().body();


    }
}
