package pageobjects;

import common.Constant;
import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlesPage extends BasePage {
    //Locators
    private By articleMenu = By.cssSelector(".dropdown-toggle.menu-article");
    private By titleArticle = By.id("jform_title");
    private By alia = By.id("jform_alias");
    private By contentArticleTab = By.id("jform_articletext_ifr");
    private By successfulMessage = By.cssSelector(".alert-message");

    //Element
    private WebElement getTitleArticle() {
        return DriverHelper.getWebDriver().findElement(titleArticle);
    }

    private WebElement getAlia() {
        return DriverHelper.getWebDriver().findElement(alia);
    }

    private WebElement getContentArticleTab() {
        return DriverHelper.getWebDriver().findElement(contentArticleTab);
    }


    //Method
    public String getTextSuccessfulMessage() {
        return getTextTrim(DriverHelper.getWebDriver().findElement(successfulMessage));
    }

    public void selectOnArticleMenu() {
        clickOnMenuLevel2Tab(Constant.CONTENT, Constant.ARTICLES);
    }


    private void enterTitle(String title) {
        getTitleArticle().sendKeys(title);
    }

    private void enterContent(String content) {
        getContentArticleTab().sendKeys(content);
    }

    private void enterAlia(String alia) {
        getAlia().sendKeys(alia);
    }


    /***
     *  Create a new article
     * @param title
     * @param content
     */
    public void createNewArticle(String title, String content, String alia, String status, String category) {
        enterTitle(title);
        enterContent(content);
        enterAlia(alia);
        selectStatus(status);
        selectValueCategory(category);
        clickSaveAndCloseButton();
    }

    /***
     *  Publish the first article in the article page
     */
    public void unpublishArticle() {
        clickCheckbox();
        clickUnpublishButton();
    }

}
