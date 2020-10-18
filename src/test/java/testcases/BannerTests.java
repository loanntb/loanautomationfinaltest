package testcases;

import common.Constant;
import common.Log;
import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.banners.BannersPage;
import pageobjects.LoginPage;

public class BannerTests extends BaseTest {
    private BannersPage bannersPage = new BannersPage();
    private LoginPage loginPage = new LoginPage();

    @BeforeMethod(description = "Pre-Condition: Login with a valid account and redirect to banners page")
    public void bannersPre() {
        Log.info("Login using new account");
        loginPage.login(Constant.USER_NAME, Constant.PASSWORD);

        Log.info("Open banners page");
        bannersPage.selectOnBannerMenu();
    }

    @Test(testName = "TC_JOOMLA_BANNERS_004", description = "Verify that user can unpublish a banner")
    public void tcJoomlaBanners004() {
        Log.info("Verify that user can unpublish a banner");
        String value = DataHelper.randomString();

        Log.info("Click on the new button");
        bannersPage.clickNewButton();

        Log.info("Create a new banner");
        bannersPage.createNewBanner(value, DataHelper.randomString(), Constant.PUBLISHED_STATUS, Constant.SAMPLE_DATA_BANNERS_CATEGORY);

        Log.info("Verify successful message");
        Assert.assertEquals(bannersPage.getTextSuccessfulMessage(), "Banner saved.", "Cannot create a banner");

        Log.info("Sort the banner table by ID descending");
        bannersPage.selectArrowIDColumn();

        Log.info("Unpublish a banner with title is " + value);
        bannersPage.unpublishBanner(value);

        Log.info("Verify successful message ");
        Assert.assertEquals(bannersPage.getTextSuccessfulMessage(), "1 banner unpublished.", "Cannot unpublish a banner");
    }


}
