package APISessions.Session5;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveDefaultEmptyNullValueFromJsonObjects {

    @Test
    public void removeDefaultEmptyNullValueFromJsonObjects() throws JsonProcessingException {

        POJOClassJsonIncludeAnnotationConcept pojoEmployee = new POJOClassJsonIncludeAnnotationConcept();
        pojoEmployee.setFirstname("Suresh");
//        pojoEmployee.setLastname("Kumar");
        pojoEmployee.setGender("Male");
//        pojoEmployee.setAge(32);
        pojoEmployee.setSalary(3400.90);
        pojoEmployee.setMarried(false);

        String[] hobbies=new String[2];
        hobbies[0] = "Reading";
        hobbies[1] = "Music";
        pojoEmployee.setHobbies(hobbies);

        List<String> degrees=new ArrayList<>();
        degrees.add("BCA");
        degrees.add("MCA");
        pojoEmployee.setDegrees(degrees);

        Map<String,String> familyMembers = new HashMap<>();
        familyMembers.put("1", "Mother");
        familyMembers.put("2", "Father");
        pojoEmployee.setFamilyMembers(familyMembers);


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
