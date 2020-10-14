package pageobjects;

import common.Constant;
import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BannersClientsPage extends BannersPage {
    //Locators
    private By client = By.cssSelector("#nav-empty .menu-banners-clients");
    private By helpButton = By.cssSelector("#toolbar-help .btn-small");
    private By clientName = By.id("jform_name");
    private By contactName = By.id("jform_contact");
    private By contactEmail = By.id("jform_email");
    private By successfulMessage = By.cssSelector(".alert-message");
    //Elements
    private WebElement getClientPage() {
        return DriverHelper.getWebDriver().findElement(client);
    }

    private WebElement getHelpButton() {
        return DriverHelper.getWebDriver().findElement(helpButton);
    }

    private WebElement getClientName() {
        return DriverHelper.getWebDriver().findElement(clientName);
    }

    private WebElement getContactName() {
        return DriverHelper.getWebDriver().findElement(contactName);
    }

    private WebElement getContactEmail() {
        return DriverHelper.getWebDriver().findElement(contactEmail);
    }

    //Method
    private void selectOnClientPage() {
        clickOnMenuLevel3Tab(Constant.COMPONENTS, Constant.BANNERS, Constant.CLIENTS);
    }

    private void clickHelpButton() {
        getHelpButton().click();
    }

    private void enterClientName(String name) {
        getClientName().sendKeys(name);
    }

    private void enterContactEmail(String email) {
        getContactEmail().sendKeys(email);
    }

    private void enterContactName(String contactName) {
        getContactName().sendKeys(contactName);
    }
    public String getTextSuccessfulMessage() {
        return getTextTrim(DriverHelper.getWebDriver().findElement(successfulMessage));
    }

//    public Boolean isBannerClientHelpDisplayed() {
//        try {
//            return ().isDisplayed();
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }

    public void createNewClient(String clientName, String contactName, String contactEmail) {
        selectOnClientPage();
        clickNewButton();
        enterClientName(clientName);
        enterContactName(contactName);
        enterContactEmail(contactEmail);
        clickSaveAndCloseButton();
    }

}
