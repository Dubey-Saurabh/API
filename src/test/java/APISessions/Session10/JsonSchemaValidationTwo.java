package APISessions.Session10;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import java.io.File;

public class JsonSchemaValidationTwo {

    @Test
    public void validateJsonSchema() {

        String json = """
                {
                  "Id": 12,
                    "firstName":"Saurabh",
                      "email": "saurabh@gmail.com"         	
                }
                """;

        MatcherAssert.assertThat(json,JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\Saurabh_Dubey\\Downloads\\schemavalidation.json")));
    }


}
