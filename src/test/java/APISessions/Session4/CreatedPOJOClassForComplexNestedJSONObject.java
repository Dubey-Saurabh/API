package APISessions.Session4;

import APISessions.Session3.AddressPOJO;
import APISessions.Session3.EmployeePOJO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CreatedPOJOClassForComplexNestedJSONObject {

    @Test
    public void createUser() throws JsonProcessingException {
        //create request payload
        NestedJSONPojoClass requestPayload = new NestedJSONPojoClass();

        requestPayload.setCompanyName("XYZ Ltd");
        requestPayload.setCity("Arifac Avenue");
        requestPayload.setState("RK Puram, Delhi");
        requestPayload.setPinCode("110066");

        List<String> banks = new ArrayList<String>();
        banks.add("HDFC");
        banks.add("SBI");
        banks.add("AXIS");
        requestPayload.setBankAccount(banks);

        EmployeePOJO emp1 = new EmployeePOJO();
        emp1.setFirstname("Suresh");
        emp1.setLastname("Mehra");
        emp1.setGender("Male");
        emp1.setAge(35);
        emp1.setSalary(10000.56);

        AddressPOJO emp1Address = new AddressPOJO();
        emp1Address.setStreet("Park Avenue");
        emp1Address.setCity("vijaywada");
        emp1Address.setState("Andhra Pradesh");
        emp1Address.setPinCode(530012);
        emp1.setAddress(emp1Address);

        EmployeePOJO emp2 = new EmployeePOJO();
        emp2.setFirstname("Amit");
        emp2.setLastname("Gupta");
        emp2.setGender("Male");
        emp2.setAge(30);
        emp2.setSalary(34000);
        AddressPOJO empAddress = new AddressPOJO();
        empAddress.setStreet("Plot 7");
        empAddress.setCity("vijaywada");
        empAddress.setState("Andhra Pradesh");
        empAddress.setPinCode(530012);
        emp2.setAddress(empAddress);

        EmployeePOJO emp3 = new EmployeePOJO();
        emp3.setFirstname("Ashish");
        emp3.setLastname("Das");
        emp3.setGender("Male");
        emp3.setAge(39);
        emp3.setSalary(55000);

        empAddress.setStreet("Plot 8");
        empAddress.setCity("Dwarka");
        empAddress.setState("New Delhi");
        empAddress.setPinCode(110066);
        emp3.setAddress(empAddress);

        List<EmployeePOJO> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        requestPayload.setEmployeeList(employees);

        //Convert Class object to JSON Object as String
        ObjectMapper objectMapper = new ObjectMapper();

        String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestPayload);


        RequestSpecification requestSpec = RestAssured.given();

        //specify URL
        requestSpec.baseUri("http://httpbin.org/post");

        //specify content type and request payload
        requestSpec.contentType(ContentType.JSON);
        requestSpec.body(payload);
        Response response = requestSpec.post();

        System.out.println("------------response body-----------------");
        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 200, "check for status code.");


    }

}
