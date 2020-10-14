package testcases;

import common.Constant;
import common.Log;
import helper.DataHelper;
import helper.DriverHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.BannerPage;
import pageobjects.CategoryPage;
import pageobjects.LoginPage;

public class CategoryTest extends BaseTest {
    private CategoryPage categoryPage = new CategoryPage();
    private LoginPage loginPage = new LoginPage();
    private BannerPage bannerPage = new BannerPage();

    @BeforeMethod(description = "Pre-Condition: Log in with a valid account ")
    public void articlePre() {
        Log.info("Login using new account");
        loginPage.login(Constant.USER_NAME, Constant.PASSWORD);
    }

    @Test(testName = "TC_JOOMLA_CATEGORY_MANAGER_005", description = "Verify that user can archive a category ")
    public void tcJoomplaCategoryManager005() {
        Log.info("Create a new article");
        categoryPage.createNewCategory(DataHelper.randomString());

        Log.info("Verify successful message");
        Assert.assertEquals(categoryPage.getTextSuccessfulMessage(), "Category saved.", "Cannot create a Category");

        Log.info("Sort the Category table by ID descending");
        bannerPage.selectArrow();
        Log.info("Verify that user can archive a category");
        categoryPage.archiveCategory();

        Log.info("Verify successful message ");
        Assert.assertEquals(categoryPage.getTextSuccessfulMessage(), "1 category archived.", "Cannot  unpublish a archived.");
    }

    @Test(testName = "TC_JOOMLA_CATEGORY_MANAGER_012", description = "Verify that user can cancel adding action while adding a new create")
    public void tcJoomplaCategoryManager012() {
        Log.info("Verify that user can cancel adding action while adding a new create");
        categoryPage.cancelCategoryWhileAdding(DataHelper.randomString());

        Log.info("Get CurrentUrl of this page  ");
        String actualURL = DriverHelper.getWebDriver().getCurrentUrl();
        Log.info("CurrentUrl:  " + actualURL);

        Log.info("Verify CurrentURL and ExpectedURL ");
        Assert.assertEquals(actualURL, categoryPage.getExpectedURL(), "Actual URL is not same expected url");
    }
}
