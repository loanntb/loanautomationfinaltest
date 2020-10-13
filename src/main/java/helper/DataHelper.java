package helper;

import com.github.javafaker.Faker;

public class DataHelper {
    private static Faker faker = new Faker();

    /***
     * random title, content article
     *
     * @return
     */
    public static String randomString() {
        return  faker.lorem().sentence();
    }


}

