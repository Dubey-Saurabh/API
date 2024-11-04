package RestassuredTraining;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PathAndQueryParamConcept {

    //https://reqres.in/api/users?page=2&id=5

    @Test
    public void pathAndQueryParam(){

        given().pathParam("users","users")
                .queryParam("page",2).queryParam("id",5)
                .when().get("https://reqres.in/api/{users}").then().statusCode(200).log().body();

    }


}
