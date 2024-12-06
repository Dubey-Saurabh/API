package APISessions.Session3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatedPOJOClassForNestedJsonObjects {

    @Test
    public void CreatedPOJOClassForNestedJsonObject() throws JsonProcessingException {

        EmployeePOJO pojoEmployee = new EmployeePOJO();
        pojoEmployee.setFirstname("Suresh");
        pojoEmployee.setLastname("Kumar");
        pojoEmployee.setGender("Male");
        pojoEmployee.setAge(32);
        pojoEmployee.setSalary(3400.90);

        AddressPOJO addressPOJO = new AddressPOJO();
        addressPOJO.setCity("Morena");
        addressPOJO.setState("Madhya Pradesh");
        addressPOJO.setPinCode(476001);
        addressPOJO.setStreet("New Street");

        pojoEmployee.setAddress(addressPOJO);

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


    }


}
