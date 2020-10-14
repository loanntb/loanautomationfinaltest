package pageobjects;

import helper.DataHelper;
import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage extends BasePage {
    //Locators
    private By contactMenu = By.cssSelector(".dropdown-toggle.menu-contact");
    private By titleContact = By.id("jform_name");
    private By alia = By.id("jform_alias");
    private By successfulMessage = By.cssSelector(".alert-message");

    //Element
    private WebElement getContactMenu() {
        return DriverHelper.getWebDriver().findElement(contactMenu);
    }

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
        clickOnTab(menuTab.COMPONENTS);
        getContactMenu().click();
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
