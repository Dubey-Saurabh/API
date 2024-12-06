package APISessions.Session7;

import APISessions.Session6.POJOIgnoreFieldsInSerializationAndDeserialization;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IgnoreUnknownPropertiesFromObject {

    @Test
    public void IgnoreUnknownPropertiesFromObjects() throws JsonProcessingException {

        POJOUnknownProperties pojoEmployee = new POJOUnknownProperties();
        pojoEmployee.setFirstname("Suresh");
        pojoEmployee.setLastname("Kumar");
        pojoEmployee.setGender("Male");
        pojoEmployee.setAge(32);
        pojoEmployee.setSalary(3400.90);
        pojoEmployee.setMarried(false);

        /*Serialisation*/
        ObjectMapper objectMapper = new ObjectMapper();
        String employeeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(pojoEmployee);
        System.out.println(employeeJson);

        /*Performing post operation with json body we get in serialization*/
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://httpbin.org/post");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(employeeJson);

        Response response = requestSpecification.post();
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);

        /*Catching unrecognised property exception by Object mapper*/

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        /*Deserialization*/
        POJOUnknownProperties pj = objectMapper.readValue(employeeJson, POJOUnknownProperties.class);
        System.out.println("firstname: " + pj.getFirstname());
        System.out.println("lastName: " + pj.getLastname());
        System.out.println("Gender: " + pj.getGender());
        System.out.println("Age: " + pj.getAge());
        System.out.println("Salary: " + pj.getSalary());


    }

}
