package APISessions.Session9;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ResponseSpecificationResponseBuilder {

    ResponseSpecification responseSpecification = null;

    @BeforeClass
    public void createResponseSpec() {

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(200);
        responseSpecBuilder.expectStatusLine("HTTP/1.1 200 OK");
        responseSpecBuilder.expectContentType(ContentType.JSON);
        responseSpecBuilder.expectResponseTime(Matchers.lessThan(3000L));

        responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void getAllBookingIds() {

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com/booking")
                .when().get().then().spec(responseSpecification);


    }

    @Test
    public void getAllBookingByFirstName() {

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com/booking?firstname=sally")
                .when().get().then().spec(responseSpecification);


    }


}
