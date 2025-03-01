package APISessions.Session11;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CookieConcept {

    @Test
    public void validateSameCookie(){

        given().when().get("https://www.google.com").then().cookie("AEC","hbsiabiacboacoacoancoan").log().body();

    }

    @Test
    public void gateCookie(){

        Response respone = given().when().get("https://www.google.com");
        String cookieValue= respone.getCookie("AEC");
        System.out.println(cookieValue);

    }

    @Test
    public void gateAllCookies(){

        Response response = given().when().get("https://www.google.com");

        Map<String,String> data = response.getCookies();
        System.out.println(data.keySet()); // Cookies name

        for (String cookie : data.keySet()){
            String cookieValues = response.getCookie(cookie);
            System.out.println(cookie+ " : " + cookieValues);
        }

    }
}
