package pageobjects;

import common.Constant;
import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BannersBannersPage extends BasePage{
    private By clientName = By.id("jform_name");
    private By contactName = By.id("jform_contact");
    private By contactEmail = By.id("jform_email");
    private By successfulMessage = By.cssSelector(".alert-message");

    //Elements
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

    public void createNewClient(String clientName, String contactName, String contactEmail) {
        selectOnClientPage();
        clickNewButton();
        enterClientName(clientName);
        enterContactName(contactName);
        enterContactEmail(contactEmail);
        clickSaveAndCloseButton();
    }
}
