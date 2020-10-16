package testcases;

import common.Constant;
import common.Log;
import helper.DataHelper;
import helper.DriverHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.WebLinksPage;

public class WebLinksTest  extends BaseTest{
    private WebLinksPage webLinksPage = new WebLinksPage();
    private LoginPage loginPage = new LoginPage();

    @BeforeMethod(description = "Pre-Condition: Log in with a valid account ")
    public void webLinksPre() {
        Log.info("Login using new account");
        loginPage.login(Constant.USER_NAME, Constant.PASSWORD);

        Log.info("Open weblinks page");
        webLinksPage.selectOnWebLinksMenu();
    }

    @Test(testName = "TC_JOOMLA_WEBLINKS_005", description = "Verify user can move a weblink to the archive")
    public void tcJoomplaWebLinks005() {
        Log.info("Verify user can move a weblink to the archive");

        Log.info("Click on the new button");
        webLinksPage.clickNewButton();

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

    @Test(testName = "TC_JOOMLA_WEBLINKS_012", description = "User can paging the weblinks using the paging control")
    public void tcJoomplaWebLinks012() {
        Log.info("User can paging the weblinks using the paging control");

        Log.info("Select 5 item of the Display dropdown list");
        webLinksPage.selectPagingWebLinksControl(Constant._5_Paging_Control);

        Log.info("Get Current5Url of this page  ");
        String actual5URL = DriverHelper.getWebDriver().getCurrentUrl();
        Log.info("CurrentUrl:  " + actual5URL);

        Log.info("Verify CurrentURL and ExpectedURL ");
        Assert.assertEquals(actual5URL, webLinksPage.getExpectedURL(), "Actual URL of the 5 item is not same expected url");

        Log.info("Select all items of the Display dropdown list");
        webLinksPage.selectPagingWebLinksControl(Constant.ALL_Paging_Control);

        Log.info("Get Current5Url of this page  ");
        String actualAllURL = DriverHelper.getWebDriver().getCurrentUrl();
        Log.info("CurrentUrl:  " + actual5URL);

        Log.info("Verify CurrentURL and ExpectedURL ");
        Assert.assertEquals(actualAllURL, webLinksPage.getExpectedURL(), "Actual URL of the all items is not same expected url");
    }
}
