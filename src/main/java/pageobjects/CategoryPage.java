package pageobjects;

import common.Constant;
import common.Log;
import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CategoryPage extends BannerPage {
    //Locators
    private By categoryMenu = By.cssSelector("ul li:nth-of-type(4)  .dropdown-menu.scroll-menu  .dropdown-toggle.menu-category");
    private By titleCategory = By.id("jform_title");
    private By successfulMessage = By.cssSelector(".alert-message");


    //Element
    private WebElement getCategoryMenu() {
        return DriverHelper.getWebDriver().findElement(categoryMenu);
    }

    private WebElement getTitleCategory() {
        return DriverHelper.getWebDriver().findElement(titleCategory);
    }


    //Method
    public String getTextSuccessfulMessage() {
        return getTextTrim(DriverHelper.getWebDriver().findElement(successfulMessage));
    }

    private void selectOnCategoryMenu() {
        clickOnMenuLevel2Tab(Constant.CONTENT, Constant.CATEGORIES);
    }


    private void enterTitle(String title) {
        getTitleCategory().sendKeys(title);
    }


    /***
     *  Create a new article
     * @param title
     */
    public void createNewCategory(String title) {
        selectOnCategoryMenu();
        clickNewButton();
        enterTitle(title);
        clickSaveAndCloseButton();
    }

    /***
     *  archive the first Category in the article page
     */
    public void archiveCategory() {
        clickCheckbox();
        clickArchiveButton();
    }

    /***
     * Cancel Category adding action while adding a new create
     */
    public void cancelCategoryWhileAdding(String title) {
        selectOnCategoryMenu();
        clickNewButton();
        enterTitle(title);
        clickCancelButton();
    }

    public String getExpectedURL() {
        Log.info("ExpectedURL: " + DriverHelper.getWebDriver().getCurrentUrl());
        return DriverHelper.getWebDriver().getCurrentUrl();
    }

}
