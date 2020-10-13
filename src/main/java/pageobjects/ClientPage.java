package pageobjects;

import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ClientPage extends BannerPage {
    //Locators
    private By clientHelp = By.cssSelector("#nav-empty .menu-banners-clients");
    private By helpButton = By.cssSelector("#toolbar-help .btn-small");

    //Elements
    private WebElement getClientHelp() {
        return DriverHelper.getWebDriver().findElement(clientHelp);
    }
    private WebElement getHelpButton() {
        return DriverHelper.getWebDriver().findElement(helpButton);
    }
    //Method

    private void selectOnClientHelp() {
        getClientHelp().click();
    }
    private void clickHelpButton(){
        getHelpButton().click();
    }

    public Boolean isBannerClientHelpDisplayed() {
        try {
            return ().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
