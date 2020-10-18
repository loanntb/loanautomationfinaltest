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
        return  faker.letterify("???????");
    }

    /***
     * random contact name
     * @return
     */
    public static String randomName(){
       return faker.name().fullName();
    }

    /***
     * random valid email
     * @return
     */
    public static String randomEmail() {
        String emailId = faker.internet().emailAddress();
        return emailId;
    }

    public static String randomUrl(){
        return faker.internet().url();
    }

}

