package testcases;

import common.Constant;
import common.Log;
import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.BannersBannersPage;
import pageobjects.BannersCategoriesPage;
import pageobjects.BannersClientsPage;
import pageobjects.LoginPage;

public class BannersBannersTest extends BaseTest {
    private LoginPage loginPage = new LoginPage();
    private BannersBannersPage bannersBannersPage = new BannersBannersPage();
    private BannersClientsPage bannersClientsPage = new BannersClientsPage();
    private BannersCategoriesPage bannersCategoriesPage = new BannersCategoriesPage();

    @BeforeMethod(description = "Pre-Condition: User can create new article with valid information ")
    public void articlePre() {
        Log.info("Login using new account");
        loginPage.login(Constant.USER_NAME, Constant.PASSWORD);
    }

    @Test(testName = "TC_JOOMLA_BANNERS_BANNERS_011", description = "Verify that user can create many banners by using Save & New button")
    public void tcJoomlaBannersBanners011() {
        Log.info("Create a client");
        bannersClientsPage.createNewClient(DataHelper.randomString(), DataHelper.randomName(), DataHelper.randomEmail());

        Log.info("Verify successful message");
        Assert.assertEquals(bannersClientsPage.getTextSuccessfulMessage(), "Client saved.", "Cannot create a client");

        Log.info("Create a category");
        bannersCategoriesPage.createNewCategory(DataHelper.randomString());

        Log.info("Verify successful message");
        Assert.assertEquals(bannersCategoriesPage.getTextSuccessfulMessage(), "Category saved.", "Cannot create a category");

        Log.info("Create a Banner");
        bannersBannersPage.createNewBanner(DataHelper.randomString(), Constant.SAMPLE_DATA_BANNERS_CATEGORY, Constant.NO_CLIENT);

        Log.info("Verify successful message");
        Assert.assertEquals(bannersBannersPage.getTextSuccessfulMessage(), "Banner saved.", "Cannot create a banner");

    }
    @Test(testName = "TC_JOOMLA_BANNERS_BANNERS_004", description = "Verify that user can unpublish a banner")
    public void tcJoomlaBannersBanners004() {
        Log.info("Create a client");
        bannersClientsPage.createNewClient(DataHelper.randomString(), DataHelper.randomName(), DataHelper.randomEmail());

        Log.info("Verify successful message");
        Assert.assertEquals(bannersClientsPage.getTextSuccessfulMessage(), "Client saved.", "Cannot create a client");

        Log.info("Create a category");
        bannersCategoriesPage.createNewCategory(DataHelper.randomString());

        Log.info("Verify successful message");
        Assert.assertEquals(bannersCategoriesPage.getTextSuccessfulMessage(), "Category saved.", "Cannot create a category");

        Log.info("Create a Banner");
        bannersBannersPage.createNewBanner(DataHelper.randomString(), Constant.SAMPLE_DATA_BANNERS_CATEGORY, Constant.NO_CLIENT);

        Log.info("Verify successful message");
        Assert.assertEquals(bannersBannersPage.getTextSuccessfulMessage(), "Banner saved.", "Cannot create a banner");

        Log.info("Sort the banner table by ID descending");
        bannersBannersPage.selectArrow();

        Log.info("Verify that user can unpublish a banner");
        bannersBannersPage.unpublishBanner();

        Log.info("Verify successful message ");
        Assert.assertEquals(bannersBannersPage.getTextSuccessfulMessage(), "1 banner unpublished.", "Cannot unpublish a banner");
    }
}
