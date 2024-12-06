package APISessions.Session1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SerialisationAndDeserialization {

    @Test
    public void convertJavaObjectToJsonObjectAndOppositeToo() throws JsonProcessingException {

        POJOEmployee pojoEmployee = new POJOEmployee();
        pojoEmployee.setFirstname("Suresh");
        pojoEmployee.setLastname("Kumar");
        pojoEmployee.setGender("Male");
        pojoEmployee.setAge(32);
        pojoEmployee.setSalary(3400.90);

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

        /*Deserialization*/
        POJOEmployee employee = objectMapper.readValue(employeeJson, POJOEmployee.class);
        System.out.println("firstname: " + employee.getFirstname());
        System.out.println("lastName: " + employee.getLastname());
        System.out.println("Gender: " + employee.getGender());
        System.out.println("Age: " + employee.getAge());
        System.out.println("Salary: " + employee.getSalary());


    }


}
