package testcases;

import common.Constant;
import common.Log;
import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.BannersBannersPage;
import pageobjects.LoginPage;

public class BannersBannersTest  extends BaseTest {
    private LoginPage loginPage = new LoginPage();
    private BannersBannersPage bannersBannersPage = new BannersBannersPage();
    @BeforeMethod(description = "Pre-Condition: User can create new article with valid information ")
    public void articlePre() {
        Log.info("Login using new account");
        loginPage.login(Constant.USER_NAME, Constant.PASSWORD);
    }

    @Test(testName = "TC_JOOMLA_BANNERS_BANNERS_011", description = "Verify that user can create many banners by using Save & New button")
    public void tcJoomlaBannersBanners011() {
        Log.info("Create a client");
        bannersBannersPage.createNewClient(DataHelper.randomString(), DataHelper.randomName(), DataHelper.randomEmail());

        Log.info("Verify successful message");
        Assert.assertEquals(bannersBannersPage.getTextSuccessfulMessage(), "Client saved.", "Cannot create a client");


//        Log.info("Verify successful message ");
//        Assert.assertEquals(bannerPage.getTextSuccessfulMessage(), "1 banner unpublished.", "Cannot unpublish a banner");
    }
}
