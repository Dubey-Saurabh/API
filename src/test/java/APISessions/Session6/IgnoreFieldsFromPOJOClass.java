package APISessions.Session6;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IgnoreFieldsFromPOJOClass {

    @Test
    public void ignoreFieldsInSerializationAndDeserialization() throws JsonProcessingException {

        POJOIgnoreFieldsInSerializationAndDeserialization pojoEmployee = new POJOIgnoreFieldsInSerializationAndDeserialization();
        pojoEmployee.setFirstname("Suresh");
        pojoEmployee.setLastname("Kumar");
        pojoEmployee.setGender("Male");
        pojoEmployee.setAge(32);
        pojoEmployee.setSalary(3400.90);
        pojoEmployee.setMarried(false);
        pojoEmployee.setFullName("Suresh Kumar");

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
        POJOIgnoreFieldsInSerializationAndDeserialization pj = objectMapper.readValue(employeeJson, POJOIgnoreFieldsInSerializationAndDeserialization.class);
        System.out.println("firstname: " + pj.getFirstname());
        System.out.println("lastName: " + pj.getLastname());
        System.out.println("Gender: " + pj.getGender());
        System.out.println("Age: " + pj.getAge());
        System.out.println("Salary: " + pj.getSalary());
        System.out.println("fullName: " + pj.getFullName());

/*        Converting Json Object to POJO Class Object
        POJOIgnoreFieldsInSerializationAndDeserialization emp=requestSpecification.get().as(POJOIgnoreFieldsInSerializationAndDeserialization.class);
        System.out.println("firstname: " + emp.getFirstname());
        System.out.println("lastName: " + emp.getLastname());
        System.out.println("Gender: " + emp.getGender());
        System.out.println("Age: " + emp.getAge());
        System.out.println("Salary: " + emp.getSalary());*/

    }


}
