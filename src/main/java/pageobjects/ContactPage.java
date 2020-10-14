package pageobjects;

import common.Constant;
import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage extends BasePage {
    //Locators
    private By titleContact = By.id("jform_name");
    private By alia = By.id("jform_alias");
    private By successfulMessage = By.cssSelector(".alert-message");

    //Element

    private WebElement getTitleArticle() {
        return DriverHelper.getWebDriver().findElement(titleContact);
    }

    private WebElement getAlia() {
        return DriverHelper.getWebDriver().findElement(alia);
    }

    //Method
    public String getTextSuccessfulMessage() {
        return getTextTrim(DriverHelper.getWebDriver().findElement(successfulMessage));
    }

    private void selectOnContactMenu() {
        clickOnMenuLevel2Tab(Constant.COMPONENTS, Constant.CONTACTS);
    }

    private void enterTitle(String title) {
        getTitleArticle().sendKeys(title);
    }
    private void enterAlia(String alia) {
        getAlia().sendKeys(alia);
    }

    /***
     *  Create a new contact
     * @param title
     * @param alia
     * @param status
     * @param category
     */
    public void createNewContact(String title, String alia, String status, String category) {
        selectOnContactMenu();
        clickNewButton();
        enterTitle(title);
        enterAlia(alia);
        selectStatus(status);
        selectValueCategory(category);
        clickSaveAndCloseButton();
    }

    /***
     *  Unpublish the first article in the article page
     */
    public void unpublishContact() {
        clickCheckbox();
        clickUnpublishButton();
    }
}
