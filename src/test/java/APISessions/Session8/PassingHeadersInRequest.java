package APISessions.Session8;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class PassingHeadersInRequest {

    @Test
    public void passOneHeadersInRequest() {

        RequestSpecification requestSpecification = RestAssured.given();
        /*Passing one header in request*/
        requestSpecification.header("Header1", "Value2");
        requestSpecification.log().headers();
        requestSpecification.baseUri("https://reqres.in/api/users?page=1");
        requestSpecification.get();

    }

    @Test
    public void passMultipleHeadersInRequest() {

        HashMap<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Header1", "value1");
        requestHeaders.put("Header2", "value2");

        RequestSpecification requestSpecification = RestAssured.given();
        /*Passing multiple headers in request*/
        requestSpecification.headers(requestHeaders);
        requestSpecification.log().headers();
        requestSpecification.baseUri("https://reqres.in/api/users?page=1");
        requestSpecification.get();


    }

    @Test
    public void passHeaderUsingHeaderClassInRequest() {

        Header header = new Header("Header1", "Value1");

        RequestSpecification requestSpecification = RestAssured.given();
        /*Passing multiple headers in request*/
        requestSpecification.header(header);
        requestSpecification.log().headers();
        requestSpecification.baseUri("https://reqres.in/api/users?page=1");
        requestSpecification.get();


    }

    @Test
    public void passMultipleHeadersUsingHeaderClassInRequest() {

        Header header1 = new Header("Header1", "Value1");
        Header header2 = new Header("Header2", "Value2");
        Header header3 = new Header("Header3", "Value3");

        ArrayList<Header> headersList = new ArrayList<>();
        headersList.add(header1);
        headersList.add(header2);
        headersList.add(header3);

        Headers headers = new Headers(headersList);

        RequestSpecification requestSpecification = RestAssured.given();
        /*Passing multiple headers in request*/
        requestSpecification.headers(headers);
        requestSpecification.log().headers();
        requestSpecification.baseUri("https://reqres.in/api/users?page=1");
        requestSpecification.get();


    }

}
