package pageobjects;

import common.Constant;
import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
    private void selectOnBannersPage() {
        clickOnMenuLevel3Tab(Constant.COMPONENTS, Constant.BANNERS, Constant.BANNERS);
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
        return getTextTrim(DriverHelper.getWebDriver().findElement(successfulMessage));
    }

    public void createNewBanner(String categoryName, String category, String client) {
        selectOnBannersPage();
        clickNewButton();
        enterBannerName(categoryName);
        selectValueCategory(category);
        selectValueClient(client);
        clickSaveAndCloseButton();
    }
}
