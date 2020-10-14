package testcases;

import common.Constant;
import common.Log;
import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.WebLinksPage;

public class WebLinksTest  extends BaseTest{
    private WebLinksPage webLinksPage = new WebLinksPage();
    private LoginPage loginPage = new LoginPage();

    @BeforeMethod(description = "Pre-Condition: Log in with a valid account ")
    public void articlePre() {
        Log.info("Login using new account");
        loginPage.login(Constant.USER_NAME, Constant.PASSWORD);
    }

    @Test(testName = "TC_JOOMLA_WEBLINKS_005", description = "Verify user can move a weblink to the archive")
    public void tcJoomplaWebLinks005() {
        Log.info("Create a new weblinks");
        webLinksPage.createNewWebLinks(DataHelper.randomString(), DataHelper.randomUrl());

        Log.info("Verify successful message");
        Assert.assertEquals(webLinksPage.getTextSuccessfulMessage(), "Web link successfully saved", "Cannot create a weblinks");

        Log.info("Sort the WebLinks table by ID descending");
        webLinksPage.selectArrow();
        Log.info("Verify that user can archive a weblinks");
        webLinksPage.archiveWebLinks();

        Log.info("Verify successful message ");
        Assert.assertEquals(webLinksPage.getTextSuccessfulMessage(), "1 web link successfully archived.", "Cannot  archived a weblinks.");
    }
}
