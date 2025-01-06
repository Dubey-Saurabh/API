package APISessions.Session11;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerConcept {

    //Used to create random data

    @Test
    public void fakeData(){

        Faker f = new Faker();
        String firstName= f.name().firstName();
        String userName = f.name().username();

        System.out.println(firstName);
        System.out.println(userName);

    }
}
