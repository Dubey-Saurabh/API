package RestassuredTraining.Deserialization;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendingPostRequest {

    @Test
    public void postRequestJsonObject() {

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://reqres.in/");
        requestSpecification.basePath("/api/users");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Saurabh Dubey");
        jsonObject.put("job", "QA");

        Response response = requestSpecification.body(jsonObject.toString()).when().post();
        ResponseBody responseBody = response.getBody();

        ConvertedClassObjectClass convertedClassObjectClass = responseBody.as(ConvertedClassObjectClass.class);

        Assert.assertEquals(convertedClassObjectClass.name, "Saurabh");
        Assert.assertEquals(convertedClassObjectClass.job, "QA");


    }
}
