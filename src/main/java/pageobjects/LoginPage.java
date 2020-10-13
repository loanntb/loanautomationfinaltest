package pageobjects;

import helper.DataHelper;
import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {
    //Locators
    private By emailID = By.id("mod-login-username");
    private By passwordID = By.id("mod-login-password");
    private By loginButton = By.cssSelector(".login-button");


    //Element
    private WebElement getLoginButton() {
        return DriverHelper.getWebDriver().findElement(loginButton);
    }
    private WebElement getEmail(){
        return DriverHelper.getWebDriver().findElement(emailID);
    }
    private WebElement getPassword(){
        return DriverHelper.getWebDriver().findElement(passwordID);
    }
    private void clickLoginButton(){
        getLoginButton().click();
    }
    private void enterEmail(String email) {
        getEmail().sendKeys(email);
    }
    private void enterPassword(String password) {
        getPassword().sendKeys(password);
    }

    //Method
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }



}
