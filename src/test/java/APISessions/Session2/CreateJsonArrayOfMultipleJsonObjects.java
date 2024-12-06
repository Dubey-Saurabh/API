package APISessions.Session2;

import APISessions.Session1.POJOEmployee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateJsonArrayOfMultipleJsonObjects {

    @Test
    public void CreateJsonArrayOfMultipleJsonObject() throws JsonProcessingException {

        POJOEmployee pojoEmployee = new POJOEmployee();
        pojoEmployee.setFirstname("Suresh");
        pojoEmployee.setLastname("Kumar");
        pojoEmployee.setGender("Male");
        pojoEmployee.setAge(32);
        pojoEmployee.setSalary(3400.90);

        POJOEmployee pojoEmployee2 = new POJOEmployee();
        pojoEmployee2.setFirstname("Ramesh");
        pojoEmployee2.setLastname("Sharma");
        pojoEmployee2.setGender("Male");
        pojoEmployee2.setAge(36);
        pojoEmployee2.setSalary(2400.90);

        POJOEmployee pojoEmployee3 = new POJOEmployee();
        pojoEmployee3.setFirstname("Amar");
        pojoEmployee3.setLastname("Singh");
        pojoEmployee3.setGender("Male");
        pojoEmployee3.setAge(39);
        pojoEmployee3.setSalary(5400.90);

        ArrayList<POJOEmployee> list = new ArrayList<>();
        list.add(pojoEmployee);
        list.add(pojoEmployee2);
        list.add(pojoEmployee3);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonArrayWithMultipleObjects = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        System.out.println(jsonArrayWithMultipleObjects);

        /*Performing post operation with json body we get in serialization*/
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://httpbin.org/post");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonArrayWithMultipleObjects);

        Response response = requestSpecification.post();
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);

        /*Printing values of json object parameters*/
        ResponseBody responseBody = response.getBody();
        JsonPath jsonPathView = responseBody.jsonPath();
        List<POJOEmployee> allEmployee = jsonPathView.getList("json");

        for (POJOEmployee emp : allEmployee) {
            System.out.println(emp.getFirstname());
            System.out.println(emp.getLastname());
            System.out.println(emp.getGender());
            System.out.println(emp.getAge());
            System.out.println(emp.getSalary());
        }

    }


}
