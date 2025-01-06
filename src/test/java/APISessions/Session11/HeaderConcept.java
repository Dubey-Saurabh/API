package APISessions.Session11;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class HeaderConcept {

    @Test
    public void getHeadersValues() {

        Response response = given().when().get("https://www.google.com");

        Headers headers = response.getHeaders();

        for (Header h : headers) {
            System.out.println(h.getName() + " : " + h.getValue());
        }
    }


    @Test
    public void headerValidation() {

        given().when().get("https://www.google.com").then().header("Content-Type", "text/html; charset=ISO-8859-1")
                .header("Server", "gws").log().body();

    }

    @Test
    public void logConcept() {
        given().when().get("https://www.google.com").then().header("Content-Type", "text/html; charset=ISO-8859-1")
                .header("Server", "gws")
//                .log().body(); // only response body will print
//                .log().all(); //all response will print
//                .log().cookies(); // response cookies will print
                .log().headers(); // only response headers will print

    }
}
