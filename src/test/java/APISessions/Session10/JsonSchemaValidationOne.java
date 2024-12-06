package APISessions.Session10;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.File;

    public class JsonSchemaValidationOne {

    @Test
    public void validateJsonSchema() {

        String requestPayload = "{\r\n"
                + "    \"username\" : \"admin\",\r\n"
                + "    \"password\" : \"password123\"\r\n"
                + "}";


        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .contentType(ContentType.JSON)
                .body(requestPayload)

                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(200)
                .body("token", Matchers.notNullValue())
//                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"))
                .body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\Saurabh_Dubey\\Downloads\\schema.json")));
    }


}
