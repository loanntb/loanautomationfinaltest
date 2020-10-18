package pageobjects.banners;

import common.Constant;
import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.BasePage;

public class BannersPage extends BasePage {
    //Locators
    private By titleBanner = By.id("jform_name");
    private By alia = By.id("jform_alias");
    private By successfulMessage = By.cssSelector(".alert-message");

    //Element

    private WebElement getTitleBanner() {
        return DriverHelper.getWebDriver().findElement(titleBanner);
    }

    private WebElement getAlia() {
        return DriverHelper.getWebDriver().findElement(alia);
    }

    //Method
    public String getTextSuccessfulMessage() {
        return getText(DriverHelper.getWebDriver().findElement(successfulMessage));
    }

    public void selectOnBannerMenu() {
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
        enterTitle(title);
        enterAlia(alia);
        selectStatus(status);
        selectValueCategory(category);
        clickSaveAndCloseButton();
    }

    /***
     *  Unpublish the first Banner in the Banner page
     */
    public void unpublishBanner(String value) {
        clickCheckbox(value);
        clickUnpublishButton();
    }
}
