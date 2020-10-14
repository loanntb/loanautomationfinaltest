package pageobjects;

import common.Constant;
import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BannersPage extends BasePage {
    //Locators
    private By bannerMenu = By.cssSelector(".dropdown-toggle.menu-banners");
    private By titleBanner = By.id("jform_name");
    private By alia = By.id("jform_alias");
    private By successfulMessage = By.cssSelector(".alert-message");

    //Element
    private WebElement getBannerMenu() {
        return DriverHelper.getWebDriver().findElement(bannerMenu);
    }

    private WebElement getTitleBanner() {
        return DriverHelper.getWebDriver().findElement(titleBanner);
    }

    private WebElement getAlia() {
        return DriverHelper.getWebDriver().findElement(alia);
    }

    //Method
    public String getTextSuccessfulMessage() {
        return getTextTrim(DriverHelper.getWebDriver().findElement(successfulMessage));
    }

    private void selectOnBannerMenu() {
        clickOnMenuLevel2Tab(Constant.COMPONENTS, Constant.BANNERS);
    }
    private void enterTitle(String title) {
        getTitleBanner().sendKeys(title);
    }
    private void enterAlia(String alia) {
        getAlia().sendKeys(alia);
    }


    /***
     * Create a new banner
     * @param title
     * @param alia
     */
    public void createNewBanner(String title, String alia, String status, String category) {
        selectOnBannerMenu();
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
    public void unpublishBanner() {
        clickCheckbox();
        clickUnpublishButton();
    }
}
