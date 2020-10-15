package testcases;

import common.Constant;
import common.Log;
import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.BasePage;
import pageobjects.ContactsPage;
import pageobjects.LoginPage;

public class ContactTests extends BaseTest {
    private ContactsPage contactsPagePage = new ContactsPage();
    private LoginPage loginPage = new LoginPage();
    private BasePage bannerPage = new BasePage();
    @BeforeMethod(description = "Pre-Condition: User can create new article with valid information ")
    public void articlePre() {
        Log.info("Login using new account");
        loginPage.login(Constant.USER_NAME, Constant.PASSWORD);

    }

    @Test(testName = "TC_JOOMLA_CONTACTS_004", description = "Verify user can unpublish a published contact")
    public void tcJoomlaContacts004() {
        Log.info("Verify user can unpublish a published contact");
        contactsPagePage.unpublishContact();

        Log.info("Verify successful message ");
        Assert.assertEquals(contactsPagePage.getTextSuccessfulMessage(), "1 contact unpublished.", "Cannot unpublish a contact");

        Log.info("Create a new contact");
        contactsPagePage.createNewContact(DataHelper.randomString(), DataHelper.randomString(), Constant.PUBLISHED_STATUS, Constant.SAMPLE_DATA_CONTACT_CATEGORY);

        Log.info("Verify successful message");
        Assert.assertEquals(contactsPagePage.getTextSuccessfulMessage(), "Contact saved.", "Cannot create a contact");

        Log.info("Sort the contact table by ID descending");
        bannerPage.selectArrow();
    }

    @Test(testName = "TC_JOOMLA_CONTACTS_011", description = "User can sort the contact table by ID column")
    public void tcJoomlaContacts011() {
        Log.info("User can sort the contact table by ID column");
        contactsPagePage.sortContactByID();
    }


}
