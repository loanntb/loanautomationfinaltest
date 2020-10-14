package testcases;

import common.Constant;
import common.Log;
import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.BasePage;
import pageobjects.ContactPage;
import pageobjects.LoginPage;

public class ContactTests extends BaseTest {
    private ContactPage contactPagePage = new ContactPage();
    private LoginPage loginPage = new LoginPage();
    private BasePage bannerPage = new BasePage();
    @BeforeMethod(description = "Pre-Condition: User can create new article with valid information ")
    public void articlePre() {
        Log.info("Login using new account");
        loginPage.login(Constant.USER_NAME, Constant.PASSWORD);

        Log.info("Create a new contact");
        contactPagePage.createNewContact(DataHelper.randomString(), DataHelper.randomString(), Constant.PUBLISHED_STATUS, Constant.SAMPLE_DATA_CONTACT_CATEGORY);

        Log.info("Verify successful message");
        Assert.assertEquals(contactPagePage.getTextSuccessfulMessage(), "Contact saved.", "Cannot create a contact");

        Log.info("Sort the contact table by ID descending");
        bannerPage.selectArrow();
    }

    @Test(testName = "TC_JOOMLA_CONTACTS_004", description = "Verify user can unpublish a published contact")
    public void tcJOOMLACONTACTS004() {
        Log.info("Verify user can unpublish a published contact");
        contactPagePage.unpublishContact();

        Log.info("Verify successful message ");
        Assert.assertEquals(contactPagePage.getTextSuccessfulMessage(), "1 contact unpublished.", "Cannot unpublish a contact");
    }

}
