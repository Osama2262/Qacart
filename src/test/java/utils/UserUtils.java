package utils;

import Objects.User;
import com.github.javafaker.Faker;

public class UserUtils {

    public static User FakerData()
    {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        User user;
        user = new User(firstName,lastName,email,password);
        return user;
    }
}
