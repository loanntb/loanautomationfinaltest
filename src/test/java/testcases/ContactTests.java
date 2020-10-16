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

    @BeforeMethod(description = "Pre-Condition: Login with a valid account and redirect to contacts page")
    public void contactPre() {
        Log.info("Login using new account");
        loginPage.login(Constant.USER_NAME, Constant.PASSWORD);

        Log.info("Open contacts page");
        contactsPagePage.selectOnContactMenu();
    }

    @Test(testName = "TC_JOOMLA_CONTACTS_004", description = "Verify user can unpublish a published contact")
    public void tcJoomlaContacts004() {
        Log.info("Verify user can unpublish a published contact");

        Log.info("Create a new contact");
        contactsPagePage.createNewContact(DataHelper.randomString(), DataHelper.randomString(), Constant.PUBLISHED_STATUS, Constant.SAMPLE_DATA_CONTACT_CATEGORY);

        Log.info("Verify successful message");
        Assert.assertEquals(contactsPagePage.getTextSuccessfulMessage(), "Contact saved.", "Cannot create a contact");

        Log.info("Sort the contact table by ID descending");
        bannerPage.selectArrow();

        Log.info("Click on unpublish Contact button");
        contactsPagePage.unpublishContact();

        Log.info("Verify successful message ");
        Assert.assertEquals(contactsPagePage.getTextSuccessfulMessage(), "1 contact unpublished.", "Cannot unpublish a contact");
    }

    @Test(testName = "TC_JOOMLA_CONTACTS_011", description = "User can sort the contact table by ID column")
    public void tcJoomlaContacts011() {
        Log.info("User can sort the contact table by ID column");

        Log.info("Click on ID column");
        contactsPagePage.clickIDColumn();

        Log.info("Verify Items ascending sorted the contact table by ID column");
        Assert.assertTrue(contactsPagePage.checkIdAscending(), "Items ascending sorted  is incorrectly");

        Log.info("Click on ID column");
        contactsPagePage.clickIDColumn();

        Log.info("Verify Items reverse sorted the contact table by ID column");
        Assert.assertTrue(contactsPagePage.checkIdReverse(), "Items reverse sorted  is incorrectly");
    }

}
