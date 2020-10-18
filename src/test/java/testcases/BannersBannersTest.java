package testcases;

import common.Constant;
import common.Log;
import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.banners.BannersBannersPage;
import pageobjects.banners.BannersCategoriesPage;
import pageobjects.banners.BannersClientsPage;
import pageobjects.LoginPage;

public class BannersBannersTest extends BaseTest {
    private LoginPage loginPage = new LoginPage();
    private BannersBannersPage bannersBannersPage = new BannersBannersPage();
    private BannersClientsPage bannersClientsPage = new BannersClientsPage();
    private BannersCategoriesPage bannersCategoriesPage = new BannersCategoriesPage();

    @BeforeMethod(description = "Pre-Condition: User can create new article with valid information ")
    public void bannerBannersPre() {
        Log.info("Login using new account");
        loginPage.login(Constant.USER_NAME, Constant.PASSWORD);
    }

    @Test(testName = "TC_JOOMLA_BANNERS_BANNERS_011", description = "Verify that user can create many banners by using Save & New button")
    public void tcJoomlaBannersBanners011() {
        Log.info("Verify that user can create many banners by using Save & New button");
        String title = DataHelper.randomString();

        Log.info("Open Banners Clients Page");
        bannersClientsPage.selectClientPage();

        Log.info("Click new button at Banners Clients Page");
        bannersClientsPage.clickNewButton();

        Log.info("Create a client");
        bannersClientsPage.createNewClient(title, DataHelper.randomName(), DataHelper.randomEmail());

        Log.info("Verify successful message");
        Assert.assertEquals(bannersClientsPage.getTextSuccessfulMessage(), "Client saved.", "Cannot create a client");

        Log.info("Open Banners Category Page");
        bannersCategoriesPage.selectCategoryPage();

        Log.info("Click new button at Banners Categories Page");
        bannersCategoriesPage.clickNewButton();

        Log.info("Create a category");
        bannersCategoriesPage.createNewCategory(title);

        Log.info("Verify successful message");
        Assert.assertEquals(bannersCategoriesPage.getTextSuccessfulMessage(), "Category saved.", "Cannot create a category");

        Log.info("Open Banners Banner Page");
        bannersBannersPage.selectBannersPage();

        Log.info("Click new button at Banners Banners Page");
        bannersBannersPage.clickNewButton();

        Log.info("Create a Banner");
        bannersBannersPage.createNewBannerUsingSaveAndNew(title, Constant.SAMPLE_DATA_BANNERS_CATEGORY, Constant.NO_CLIENT);

        Log.info("Verify successful message");
        Assert.assertEquals(bannersBannersPage.getTextSuccessfulMessage(), "Banner saved.", "Cannot create a banner");

    }
    @Test(testName = "TC_JOOMLA_BANNERS_BANNERS_004", description = "Verify that user can unpublish a banner")
    public void tcJoomlaBannersBanners004() {
        Log.info("Verify that user can unpublish a banner");
        String title = DataHelper.randomString();

        Log.info("Open Banners Clients Page");
        bannersClientsPage.selectClientPage();

        Log.info("Click new button at Banners Clients Page");
        bannersClientsPage.clickNewButton();

        Log.info("Create a client");
        bannersClientsPage.createNewClient(title, DataHelper.randomName(), DataHelper.randomEmail());

        Log.info("Verify successful message");
        Assert.assertEquals(bannersClientsPage.getTextSuccessfulMessage(), "Client saved.", "Cannot create a client");

        Log.info("Open Banners Categories Page");
        bannersCategoriesPage.selectCategoryPage();

        Log.info("Click new button at Banners Categories Page");
        bannersCategoriesPage.clickNewButton();

        Log.info("Create a category");
        bannersCategoriesPage.createNewCategory(title);

        Log.info("Verify successful message");
        Assert.assertEquals(bannersCategoriesPage.getTextSuccessfulMessage(), "Category saved.", "Cannot create a category");

        Log.info("Open Banners Banners Page");
        bannersBannersPage.selectBannersPage();

        Log.info("Click new button at Banners Banners Page");
        bannersBannersPage.clickNewButton();

        Log.info("Create a Banner");
        bannersBannersPage.createNewBannerUsingSaveAndClose(title, Constant.SAMPLE_DATA_BANNERS_CATEGORY, Constant.NO_CLIENT);

        Log.info("Verify successful message");
        Assert.assertEquals(bannersBannersPage.getTextSuccessfulMessage(), "Banner saved.", "Cannot create a banner");

        Log.info("Sort the banner table by ID descending");
        bannersBannersPage.selectArrowIDColumn();

        Log.info("Unpublish a banner with title is " + title);
        bannersBannersPage.unpublishBanner(title);

        Log.info("Verify successful message ");
        Assert.assertEquals(bannersBannersPage.getTextSuccessfulMessage(), "1 banner unpublished.", "Cannot unpublish a banner");
    }
}
