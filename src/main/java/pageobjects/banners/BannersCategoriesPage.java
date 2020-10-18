package pageobjects.banners;

import common.Constant;
import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.BasePage;

public class BannersCategoriesPage extends BasePage {
    private By categoryName = By.cssSelector("input#jform_title");
    private By successfulMessage = By.cssSelector(".alert-message");

    //Elements
    private WebElement getCategoryName() {
        return DriverHelper.getWebDriver().findElement(categoryName);
    }

    //Method
    public void selectOnCategoryPage() {
        clickOnSideBarNav(Constant.COMPONENTS, Constant.BANNERS, Constant.CATEGORIES);
    }

    private void enterCategoryName(String name) {
        getCategoryName().sendKeys(name);
    }

    public String getTextSuccessfulMessage() {
        return getText(DriverHelper.getWebDriver().findElement(successfulMessage));
    }

    public void createNewCategory(String categoryName) {
        enterCategoryName(categoryName);
        clickSaveAndCloseButton();
    }
}
