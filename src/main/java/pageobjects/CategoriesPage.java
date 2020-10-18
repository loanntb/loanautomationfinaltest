package pageobjects;

import common.Constant;
import common.Log;
import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.banners.BannersPage;

public class CategoriesPage extends BannersPage {
    //Locators
    private By titleCategory = By.id("jform_title");
    private By successfulMessage = By.cssSelector(".alert-message");


    //Element
    private WebElement getTitleCategory() {
        return DriverHelper.getWebDriver().findElement(titleCategory);
    }


    //Method
    public String getTextSuccessfulMessage() {
        return getText(DriverHelper.getWebDriver().findElement(successfulMessage));
    }

    public void selectCategoryMenu() {
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
        enterTitle(title);
        clickSaveAndCloseButton();
    }

    /***
     *  archive the first Category in the article page
     */
    public void archiveCategory(String value) {
        clickCheckbox(value);
        clickArchiveButton();
    }

    /***
     * Cancel Category adding action while adding a new create
     */
    public void cancelCategoryWhileAdding(String title) {
        enterTitle(title);
        clickCancelButton();
    }

    public String getCategoriesViewURL() {
        Log.info("ExpectedURL: " + DriverHelper.getCurrentURL());
        return DriverHelper.getCurrentURL();
    }

}
