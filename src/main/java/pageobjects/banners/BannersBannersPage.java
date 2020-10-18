package pageobjects.banners;

import common.Constant;
import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.BasePage;

public class BannersBannersPage extends BasePage {
    private By bannerName = By.id("jform_name");
    private By client = By.cssSelector("#jform_cid_chzn .chzn-single");
    private String valueClient = "//div[@id='jform_cid_chzn']/a/span[.='%s']";
    private By successfulMessage = By.cssSelector(".alert-message");

    //Elements
    private WebElement getBannerName() {
        return DriverHelper.getWebDriver().findElement(bannerName);
    }
    private WebElement getClient() {
        return DriverHelper.getWebDriver().findElement(client);
    }
    //Method
    public void selectBannersPage() {
        clickOnSideBarNav(Constant.COMPONENTS, Constant.BANNERS, Constant.BANNERS);
    }
    private WebElement getValueClient(String value) {
        return DriverHelper.getWebDriver().findElement(By.xpath(String.format(valueClient, value)));
    }
    private void enterBannerName(String name) {
        getBannerName().sendKeys(name);
    }

    private void selectValueClient(String value) {
        selectContentNavTab(Constant.BANNER_DETAILS);
        getClient().click();
        getValueClient(value).click();
    }

    public String getTextSuccessfulMessage() {
        return getText(DriverHelper.getWebDriver().findElement(successfulMessage));
    }

    public void createNewBannerUsingSaveAndNew(String categoryName, String category, String client) {
        enterBannerName(categoryName);
        selectValueCategory(category);
        selectValueClient(client);
        clickSaveAndNewButton();
    }

    public void createNewBannerUsingSaveAndClose(String categoryName, String category, String client) {
        enterBannerName(categoryName);
        selectValueCategory(category);
        selectValueClient(client);
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
