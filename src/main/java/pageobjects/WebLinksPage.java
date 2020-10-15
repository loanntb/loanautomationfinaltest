package pageobjects;

import common.Constant;
import common.Log;
import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebLinksPage extends BasePage {
    //Locators
    private By titleWebLinks = By.id("jform_title");
    private By urlWebLinks = By.id("jform_url");
    private By successfulMessage = By.cssSelector(".alert-message");

    //Element
    private WebElement getTitleWebLinks() {
        return DriverHelper.getWebDriver().findElement(titleWebLinks);
    }
    private WebElement getUrlWebLinks() {
        return DriverHelper.getWebDriver().findElement(urlWebLinks);
    }

    //Method
    public String getTextSuccessfulMessage() {
        return getTextTrim(DriverHelper.getWebDriver().findElement(successfulMessage));
    }

    private void selectOnWebLinksMenu() {
        clickOnMenuLevel2Tab(Constant.COMPONENTS, Constant.WEBLINKS);
    }


    private void enterTitle(String title) {
        getTitleWebLinks().sendKeys(title);
    }
    private void enterUrlWebLinks(String url) {
        getUrlWebLinks().sendKeys(url);
    }

    /***
     *  Create a new article
     * @param title
     */
    public void createNewWebLinks(String title, String url) {
        selectOnWebLinksMenu();
        clickNewButton();
        enterTitle(title);
        enterUrlWebLinks(url);
        clickSaveAndCloseButton();
    }

    /***
     *  archive the first Category in the article page
     */
    public void archiveWebLinks() {
        clickCheckbox();
        clickArchiveButton();
    }

    public void selectPagingWebLinksControl(String value){
        selectOnWebLinksMenu();
        selectValuePagingControl(value);
    }
    public String getExpectedURL() {
        Log.info("ExpectedURL: " + DriverHelper.getWebDriver().getCurrentUrl());
        return DriverHelper.getWebDriver().getCurrentUrl();
    }
}
