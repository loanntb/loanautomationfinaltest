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
        bannerPage.createNewBanner(DataHelper.randomString(), DataHelper.randomString(), Constant.PUBLISHED_STATUS, Constant.SAMPLE_DATA_BANNERS_CATEGORY);

        Log.info("Verify successful message");
        Assert.assertEquals(bannerPage.getTextSuccessfulMessage(), "Banner saved.", "Cannot create a banner");

        Log.info("Sort the banner table by ID descending");
        bannerPage.selectArrow();
    }

    @Test(testName = "TC_JOOMLA_BANNERS_BANNERS_004", description = "Verify that user can unpublish a banner")
    public void tcJOOMLABANNERS004() {
        Log.info("Verify that user can unpublish a banner");
        bannerPage.unpublishBanner();

        Log.info("Verify successful message ");
        Assert.assertEquals(bannerPage.getTextSuccessfulMessage(), "1 banner unpublished.", "Cannot unpublish a banner");
    }

}
