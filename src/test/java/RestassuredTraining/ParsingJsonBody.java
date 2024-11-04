package RestassuredTraining;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParsingJsonBody {

    String endPoint = "http://localhost:3000/book/";

    //When yoy have some small response parameter to validate
    @Test
    public void validatingBookTitle() {

        given().when().get(endPoint).then().body("book[3].title", equalTo("The lord of the rings")).log().body();

    }

    //When yoy have some more response parameter to validate
    @Test
    public void validatingBookTitleAnotherWay() {

        Response response = given().when().get(endPoint);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.header("Content-Type"), "application/json");
        String bookTitle = response.jsonPath().get("book[3].title").toString();
        Assert.assertEquals(bookTitle, "The lord of the rings");

    }

    //When yoy have some more response parameter to validate
    @Test
    public void validatingBookTitleUsingJsonObject() {

        Response response = given().when().get(endPoint);

        JSONObject jo = new JSONObject(response.toString()); // convert response to Json Object

        for (int i = 0; i < jo.getJSONArray("book").length(); i++) {
            String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();

            if (bookTitle.equalsIgnoreCase("The lord of the rings")) {
                System.out.println("book is found");
            }

            //Total prices of the books
//            double totalPricesOfTheBooks = 0;
//            String price = jo.getJSONArray("book").getJSONObject(i).get("price").toString();
//            totalPricesOfTheBooks = totalPricesOfTheBooks + Double.parseDouble(price);
//            System.out.println(totalPricesOfTheBooks);
        }

    }

}
