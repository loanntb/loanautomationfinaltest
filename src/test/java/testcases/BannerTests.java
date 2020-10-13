package testcases;

import common.Constant;
import common.Log;
import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.BannerPage;
import pageobjects.LoginPage;

public class BannerTests extends BaseTest {
    private BannerPage bannerPage = new BannerPage();
    private LoginPage loginPage = new LoginPage();

    @BeforeMethod(description = "Pre-Condition: User can create new article with valid information ")
    public void articlePre() {
        Log.info("Login using new account");
        loginPage.login(Constant.USER_NAME, Constant.PASSWORD);

        Log.info("Create a new banner");
        bannerPage.createNewBanner(DataHelper.randomString(), DataHelper.randomString(), Constant.STATUS, Constant.CATEGORY);

        Log.info("Verify successful message");
        Assert.assertEquals(bannerPage.getTextSuccessfulMessage(), "Banner saved.", "Cannot create a banner");
    }

    @Test(testName = "TC_JOOMLA_BANNERS_BANNERS_004", description = "Verify user can publish a published banner")
    public void tcJOOMLABANNERS004() {
        Log.info("Verify user can publish a published banner");
        bannerPage.publishBanner();

        Log.info("Verify successful message ");
        Assert.assertEquals(bannerPage.getTextSuccessfulMessage(), "0 banners published.", "Cannot publish a banner");
    }

}
