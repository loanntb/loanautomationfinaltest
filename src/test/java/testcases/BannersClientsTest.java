package testcases;


import common.Constant;
import common.Log;
import helper.ClientHelper;
import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.BannersClientsPage;
import pageobjects.LoginPage;


public class BannersClientsTest extends BaseTest {
    private LoginPage loginPage = new LoginPage();
    private BannersClientsPage bannersClientsPage = new BannersClientsPage();

    @BeforeMethod(description = "Pre-Condition: Login with a valid account ")
    public void articlePre() {
        Log.info("Login using new account");
        loginPage.login(Constant.USER_NAME, Constant.PASSWORD);
    }

    @Test(testName = "TC_JOOMLA_BANNERS_BANNERS_011", description = "User can browse Banner client help page")
    public void tcJoomlaBannersBanners011() {
        Log.info("User can browse Banner client help page");
        bannersClientsPage.findClientBannerHelperPage();

        Log.info("Verify Banner Help Page Title");
        Assert.assertEquals(ClientHelper.verifyHelpPageTitle(Constant.COMPONENTS_BANNERS_CLIENTS),bannersClientsPage.isTitleClientHelperEqual(Constant.COMPONENTS_BANNERS_CLIENTS),"The title client helper page is different");
    }

    @Test(testName = "TC_JOOMLA_BANNERS_CLIENTS_014", description = "Verify that user cannot create a new client without entering the name of the client")
    public void tcJoomlaBannersBanners014() {
        Log.info("Verify that user cannot create a new client without entering the name of the client");
        bannersClientsPage.createNewClient("", DataHelper.randomName(), DataHelper.randomEmail());

        Log.info("Verify the error message");
        Assert.assertEquals(bannersClientsPage.getTextErrorMessage(), "Invalid field:  Name", "Error message was not found");
        Assert.assertEquals(bannersClientsPage.getColorErrorMessage(), Constant.ERROR_MESSAGE_COLOR, "The color of Client name textbox does not change to red");
    }

}
