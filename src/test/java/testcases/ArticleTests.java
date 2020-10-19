package testcases;

import common.Constant;
import common.Log;
import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.ArticlesPage;
import pageobjects.banners.BannersPage;
import pageobjects.LoginPage;

public class ArticleTests extends BaseTest {
    private ArticlesPage articlesPage = new ArticlesPage();
    private LoginPage loginPage = new LoginPage();
    private BannersPage bannersPage = new BannersPage();

    @BeforeMethod(description = "Pre-Condition: Login with a valid account and redirect to articles page ")
    public void articlePre() {
        Log.info("Login using new account");
        loginPage.login(Constant.USER_NAME, Constant.PASSWORD);

        Log.info("Open articles page");
        articlesPage.selectArticleMenu();
    }

    @Test(testName = "TC_JOOMLA_ARTICLE_004", description = "Verify user can unpublish a published article")
    public void tcJoomlaArticle004() {
        Log.info("Verify user can unpublish a published article");
        String title = DataHelper.randomString();

        Log.info("Click new button");
        articlesPage.clickNewButton();

        Log.info("Create a new article");
        articlesPage.createNewArticle(title, DataHelper.randomString(), DataHelper.randomString(), Constant.PUBLISHED_STATUS, Constant.SAMPLE_DATA_ARTICLES_CATEGORY);

        Log.info("Verify successful message");
        Assert.assertEquals(articlesPage.getTextSuccessfulMessage(), "Article saved.", "Cannot create a article");

        Log.info("Sort the article table by ID descending");
        bannersPage.selectArrowIDColumn();

        Log.info("Verify user can unpublish a published article");
        articlesPage.unpublishArticle(title);

        Log.info("Verify successful message ");
        Assert.assertEquals(articlesPage.getTextSuccessfulMessage(), "1 article unpublished.", "Cannot  unpublished a article.");
    }

    @Test(testName = "TC_JOOMLA_ARTICLE_011", description = "User can sort the contact table by ID column")
    public void tcJoomlaArticle011() {
        Log.info("User can sort the article table by ID column");

        Log.info("Click on ID column");
        articlesPage.clickIDColumn();

        Log.info("Verify Items ascending sorted the article table by ID column");
        Assert.assertTrue(articlesPage.checkIdAscending(), "Items ascending sorted  is incorrectly");

        Log.info("Click on ID column");
        articlesPage.clickIDColumn();

        Log.info("Verify Items reverse sorted the contact table by ID column");
        Assert.assertTrue(articlesPage.checkIdReverse(), "Items reverse sorted  is incorrectly");
    }


}
