package RestassuredTraining;

import org.testng.annotations.Test;

public class SerializationAndDeserialization {

    //Convert Java object to Json Object
    @Test
    public void pojoToJson() {

        POSTRequestCreationUsingPOJOClass data = new POSTRequestCreationUsingPOJOClass();
        String subjectsArr[] = {"Math", "Physics", "English"};
        data.setName("Test Abc");
        data.setAge(12);
        data.setGrade("9");
        data.setSubjectsArr(subjectsArr);

//        ObjectMapper ob = new ObjectMapper() {

        };



    }


