package pageobjects;

import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePage extends BasePage {
    //Locators
    private By articleMenu = By.cssSelector(".dropdown-toggle.menu-article");
    private By titleArticle = By.id("jform_title");
    private By contentArticleTab = By.id("jform_articletext_ifr");
    private By successfulMessage = By.cssSelector(".alert-message");

    //Element
    private WebElement getArticleMenu() {
        return DriverHelper.getWebDriver().findElement(articleMenu);
    }

    private WebElement getTitleArticle() {
        return DriverHelper.getWebDriver().findElement(titleArticle);
    }

    private WebElement getContentArticleTab() {
        return DriverHelper.getWebDriver().findElement(contentArticleTab);
    }

    //Method
    public String getTextSuccessfulMessage() {
        return getTextTrim(DriverHelper.getWebDriver().findElement(successfulMessage));
    }
    private void selectOnArticleMenu() {
        clickOnTab(menuTab.CONTENT);
        getArticleMenu().click();
    }


    private void enterTitle(String title) {
        getTitleArticle().sendKeys(title);
    }

    private void enterContent(String content) {
        getContentArticleTab().sendKeys(content);
    }


    /***
     *  Create a new article
     * @param title
     * @param content
     */
    public void createNewArticle(String title, String content, String status, String category){
        selectOnArticleMenu();
        clickNewButton();
        enterTitle(title);
        enterContent(content);
        selectStatus(status);
        selectValueCategory(category);
        clickSaveAndCloseButton();
    }

    /***
     *  Publish the first article in the article page
     */
    public void publishArticle() {
        clickCheckbox();
        clickPublishButton();
    }

}
