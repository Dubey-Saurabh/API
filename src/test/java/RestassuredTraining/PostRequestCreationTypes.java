package RestassuredTraining;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRequestCreationTypes {

    String endUrl = "http://localhost:3000/students/";

    //by using HashMap
    @Test(priority = 1)
    public void postUsingHashMap() {

        String subjectsArr[] = {"Math", "Physics", "English"};

        HashMap data = new HashMap();
        data.put("name", "John Doe");
        data.put("age", 18);
        data.put("grade", "12th");
        data.put("subjects", subjectsArr);

        given().contentType("application/json").body(data).when().post(endUrl).then().statusCode(201)
                .body("name", equalTo("John Doe")).body("subjects[0]", equalTo("Math"))
                .header("Content-type", "application/json").log().all();

    }

    //By using json request body
    @Test(priority = 2)
    public void postUsingJsonRequestBody() {

        String subjectsArr[] = {"Math", "Physics", "English"};

        JSONObject data = new JSONObject();
        data.put("name", "John Singh");
        data.put("age", 19);
        data.put("grade", "11th");
        data.put("subjects", subjectsArr);

        given().contentType("application/json").body(data.toString()).when().post(endUrl).then().statusCode(201)
                .body("name", equalTo("John Singh")).body("subjects[0]", equalTo("Math"))
                .header("Content-type", "application/json").log().body();

    }

    //By using POJO Class request body
    @Test(priority = 3)
    public void postUsingPojoBody() {

        POSTRequestCreationUsingPOJOClass data = new POSTRequestCreationUsingPOJOClass();
        String subjectsArr[] = {"Math", "Physics", "English"};
        data.setName("Test Abc");
        data.setAge(12);
        data.setGrade("9");
        data.setSubjectsArr(subjectsArr);


        given().contentType("application/json").body(data).when().post(endUrl).then().statusCode(201)
                .body("name", equalTo("Test Abc")).body("subjectsArr[0]", equalTo("Math"))
                .header("Content-type", "application/json").log().body();

    }

    //By using POJO Class request body
    @Test(priority = 4)
    public void postUsingExternalJsonFile() throws FileNotFoundException {


        File file = new File("C:\\Api-testing\\src\\test\\java\\RestassuredTraining\\body.json");
        FileReader fr = new FileReader(file);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject data = new JSONObject(jt);

        given().contentType("application/json").body(data.toString()).when().post(endUrl).then().statusCode(201)
                .body("name", equalTo("Jane Dubey")).body("subjects[0]", equalTo("Biology"))
                .header("Content-type", "application/json").log().body();

    }
}
