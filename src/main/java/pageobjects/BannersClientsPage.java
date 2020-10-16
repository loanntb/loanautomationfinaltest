package pageobjects;

import common.Constant;
import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class BannersClientsPage extends BasePage {
    //Locators
    private By helpButton = By.cssSelector("#toolbar-help .btn-small");
    private By clientName = By.id("jform_name");
    private By contactName = By.id("jform_contact");
    private By contactEmail = By.id("jform_email");
    private By successfulMessage = By.cssSelector(".alert-message");
    private By errorMessage = By.cssSelector(".alert-danger div");


    //Elements
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

    private WebElement getErrorMessage(){
        return DriverHelper.getWebDriver().findElement(errorMessage);
    }

    //Method
    private void selectOnClientPage() {
        clickOnMenuLevel3Tab(Constant.COMPONENTS, Constant.BANNERS, Constant.CLIENTS);
    }

    public void clickHelpButton() {
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

    public String getTextErrorMessage() {
        return getTextTrim(DriverHelper.getWebDriver().findElement(errorMessage));
    }

    /***
     * Create a new client
     * @param clientName
     * @param contactName
     * @param contactEmail
     */
    public void createNewClient(String clientName, String contactName, String contactEmail) {
        selectOnClientPage();
        clickNewButton();
        enterClientName(clientName);
        enterContactName(contactName);
        enterContactEmail(contactEmail);
        clickSaveAndCloseButton();
    }

    public boolean isTitleClientHelperEqual(String value){
        if(getTextTitleClientHelper(value) == value){
            return true;
        }else {
            return false;
        }

    }

    public String getColorErrorMessage(){
        String colorString =  getErrorMessage().getCssValue("color").trim();
        return getColorMessage(colorString);
    }

    public void findClientBannerHelperPage(){
        selectOnClientPage();
        clickHelpButton();
    }

}
