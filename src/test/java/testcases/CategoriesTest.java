package testcases;

import common.Constant;
import common.Log;
import helper.DataHelper;
import helper.DriverHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.CategoriesPage;
import pageobjects.LoginPage;

public class CategoriesTest extends BaseTest {
    private CategoriesPage categoriesPage = new CategoriesPage();
    private LoginPage loginPage = new LoginPage();


    @BeforeMethod(description = "Pre-Condition: Log in with a valid account and redirect category manager page ")
    public void categoryPre() {
        Log.info("Login using new account");
        loginPage.login(Constant.USER_NAME, Constant.PASSWORD);

        Log.info("Open categories manager page");
        categoriesPage.selectOnCategoryMenu();
    }

    @Test(testName = "TC_JOOMLA_CATEGORY_MANAGER_005", description = "Verify that user can archive a category ")
    public void tcJoomplaCategoryManager005() {
        Log.info("Verify that user can archive a category");

        Log.info("Click on the new button");
        categoriesPage.clickNewButton();

        Log.info("Create a new article");
        categoriesPage.createNewCategory(DataHelper.randomString());

        Log.info("Verify successful message");
        Assert.assertEquals(categoriesPage.getTextSuccessfulMessage(), "Category saved.", "Cannot create a Category");

        Log.info("Sort the Category table by ID descending");
        categoriesPage.selectArrowIDColumn();
        Log.info("Verify that user can archive a category");
        categoriesPage.archiveCategory();

        Log.info("Verify successful message ");
        Assert.assertEquals(categoriesPage.getTextSuccessfulMessage(), "1 category archived.", "Cannot  unpublish a archived.");
    }

    @Test(testName = "TC_JOOMLA_CATEGORY_MANAGER_012", description = "Verify that user can cancel adding action while adding a new create")
    public void tcJoomplaCategoryManager012() {
        Log.info("Verify that user can cancel adding action while adding a new create");

        Log.info("Click on the new button");
        categoriesPage.clickNewButton();

        categoriesPage.cancelCategoryWhileAdding(DataHelper.randomString());

        Log.info("Get CurrentUrl of this page  ");
        String actualURL = DriverHelper.getCurrentURL();
        Log.info("CurrentUrl:  " + actualURL);

        Log.info("Verify CurrentURL and ExpectedURL ");
        Assert.assertEquals(actualURL, categoriesPage.getCategoriesViewURL(), "Actual URL is not same expected url");
    }
}
