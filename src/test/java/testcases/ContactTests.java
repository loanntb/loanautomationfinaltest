package testcases;

import common.Constant;
import common.Log;
import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.ContactPage;
import pageobjects.LoginPage;

public class ContactTests extends BaseTest {
    private ContactPage contactPagePage = new ContactPage();
    private LoginPage loginPage = new LoginPage();

    @BeforeMethod(description = "Pre-Condition: User can create new article with valid information ")
    public void articlePre() {
        Log.info("Login using new account");
        loginPage.login(Constant.USER_NAME, Constant.PASSWORD);

        Log.info("Create a new contact");
        contactPagePage.createNewContact(DataHelper.randomString(), DataHelper.randomString(), Constant.STATUS, Constant.CATEGORY);

        Log.info("Verify successful message");
        Assert.assertEquals(contactPagePage.getTextSuccessfulMessage(), "Contact saved.", "Cannot create a contact");
    }

    @Test(testName = "TC_JOOMLA_CONTACTS_004", description = "Verify user can publish a published contact")
    public void tcJOOMLACONTACTS004() {
        Log.info("Verify user can publish a published contact");
        contactPagePage.publishContact();

        Log.info("Verify successful message ");
        Assert.assertEquals(contactPagePage.getTextSuccessfulMessage(), "0 contacts published.", "Cannot publish a article");
    }

}
