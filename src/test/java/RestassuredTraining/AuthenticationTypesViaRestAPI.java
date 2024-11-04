package RestassuredTraining;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AuthenticationTypesViaRestAPI {

    @Test
    public void basicAuth() {

        String endPoint = "https://postman-echo.com/basic-auth";

        given()
                .auth().basic("postman", "password")
                .when().get(endPoint).then().statusCode(200).log().body();


    }

    @Test
    public void digestAuth() {

        String endPoint = "https://postman-echo.com/basic-auth";

        given()
                .auth().digest("postman", "password")
                .when().get(endPoint).then().statusCode(200).body("authenticated", equalTo(true)).log().body();


    }

    @Test
    public void preemptiveAuth() {

        String endPoint = "https://postman-echo.com/basic-auth";

        given()
                .auth().preemptive().basic("postman", "password")
                .when().get(endPoint).then().statusCode(200).body("authenticated", equalTo(true)).log().body();


    }

    @Test
    public void tokenAuthentication() {

        String endPoint = "https://api.github.com/user/repos";
        String bearerToken = "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";

        given()
                .headers("Authorization", "Bearer " + bearerToken)
                .when().get(endPoint).then().statusCode(200);


    }

    @Test
    public void oauth1Authentication() {

        String endPoint = "https://postman-echo.com/basic-auth";
        given()
                .auth().oauth("ConsumerKey", "ConsumerSecret", "accessToken", "TokenSecret")
                .when().get(endPoint).then().statusCode(200);


    }

    @Test
    public void oauth2Authentication() {

        String endPoint = "https://api.github.com/user/repos";
        String bearerToken = "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";

        given()
                .auth().oauth2(bearerToken)
                .when().get(endPoint).then().statusCode(200);


    }

    @Test
    public void apiKeyBasedAuthentication() {

        String endPoint = "https://api.github.com/user/repos";

        given()
                .queryParam("ApiKey", "Api password")
                .when().get(endPoint).then().statusCode(200);


    }
}
