package testcases;

import common.Constant;
import common.Log;
import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.ArticlePage;
import pageobjects.LoginPage;

public class ArticleTests extends BaseTest {
    private ArticlePage articlePage = new ArticlePage();
    private LoginPage loginPage = new LoginPage();

    @BeforeMethod(description = "Pre-Condition: User can create new article with valid information ")
    public void articlePre() {
        Log.info("Login using new account");
        loginPage.login(Constant.USER_NAME, Constant.PASSWORD);

        Log.info("Create a new article");
        articlePage.createNewArticle(DataHelper.randomString(), DataHelper.randomString(), DataHelper.randomString(), Constant.PUBLISHED_STATUS, Constant.SAMPLE_DATA_ARTICLES_CATEGORY);

        Log.info("Verify successful message");
        Assert.assertEquals(articlePage.getTextSuccessfulMessage(), "Article saved.", "Cannot create a article");
    }

    @Test(testName = "TC_JOOMLA_CONTACTS_004", description = "Verify user can unpublish a published article ")
    public void tcJOOMLACONTACTS004() {
        Log.info("Verify user can unpublish a published article");
        articlePage.unpublishArticle();

        Log.info("Verify successful message ");
        Assert.assertEquals(articlePage.getTextSuccessfulMessage(), "1 article unpublished.", "Cannot  unpublished a article.");
    }

}
