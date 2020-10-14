package pageobjects;

import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class BasePage {
    public enum menuTab {
        CONTENT, COMPONENTS;
    }

    //Locators
    private By contentTab = By.xpath("//ul[@id='menu']//a[contains(text(),'Content')]");
    private By componentsTab = By.xpath("//ul[@id='menu']//a[contains(text(),'Components ')]");
    private By newButton = By.id("toolbar-new");
    private By saveAndCloseButton = By.xpath("//div[@id='toolbar-save']/button[@class='btn btn-small button-save']");
    private By publishButton = By.id("toolbar-publish");
    private By unpublishButton = By.id("toolbar-unpublish");
    private By checkBox = By.cssSelector("tr:first-child input[name='cid[]']");
    private By status = By.cssSelector(".chzn-color-state.chzn-single");
    private String elementStatus = "//div[@class='chzn-drop']//li[contains(text(),'%s')]";
    private By category = By.cssSelector("#jform_catid_chzn .chzn-single");
    private String valueCategory = "//div[@id='jform_catid_chzn']//span[contains(text(), '%s')]";

    //Element
    private WebElement getContentTab(){
        return DriverHelper.getWebDriver().findElement(contentTab);
    }
    private WebElement getComponentsTab(){
        return DriverHelper.getWebDriver().findElement(componentsTab);
    }
    private WebElement getSaveAndCloseButton() {
        return DriverHelper.getWebDriver().findElement(saveAndCloseButton);
    }

    private WebElement getNewButton() {
        return DriverHelper.getWebDriver().findElement(newButton);
    }

    private WebElement getPublishButton() {
        return DriverHelper.getWebDriver().findElement(publishButton);
    }
    private WebElement getUnpublishButton() {
        return DriverHelper.getWebDriver().findElement(unpublishButton);
    }

    private WebElement getCheckBox() {
        return DriverHelper.getWebDriver().findElement(checkBox);
    }

    private WebElement getStatus() {
        return DriverHelper.getWebDriver().findElement(status);
    }
    private WebElement getElementStatus(String status){
        return DriverHelper.getWebDriver().findElement(By.xpath(String.format(elementStatus, status)));
    }
    private WebElement getCategory() {
        return DriverHelper.getWebDriver().findElement(category);
    }
    private WebElement getValueCategory(String value){
        return DriverHelper.getWebDriver().findElement(By.xpath(String.format(valueCategory, value)));
    }

    //Methods

    /***
     * Clicking on Menu Tabs
     * @param tabName
     */
    public void clickOnTab(menuTab tabName) {
        switch (tabName) {
            case CONTENT:
                getContentTab().click();
                break;
            case COMPONENTS:
                getComponentsTab().click();
                break;
            default:
                break;
        }
    }

    public void clickNewButton() {
        getNewButton().click();
    }
    public void clickSaveAndCloseButton() {
        getSaveAndCloseButton().click();
    }

    public void clickCheckbox() {
        getCheckBox().click();
    }

    public void clickPublishButton() {
        getPublishButton().click();
    }
    public void clickUnpublishButton() {
        getUnpublishButton().click();
    }
    public void selectStatus(String status){
        getStatus().click();
        getElementStatus(status).click();
    }
    public void selectValueCategory(String value){
        getCategory().click();
        getValueCategory(value).click();
    }
    /***
     * Get text and trim space
     * @param element
     * @return
     */
    public String getTextTrim(WebElement element) {
        return element.getText().trim();
    }


}
