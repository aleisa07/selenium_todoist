package pages;

import framework.selenium.Commons;
import framework.selenium.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Silvia Coca on 3/23/2015.
 */
public class AccountContainer {

    WebDriver driver;
    WebDriverWait wait;

    private By frameSettingsName = By.name("GB_frame");
    private By frameSettingsId = By.id("GB_frame");
    private By editFullNameLink = By.xpath("//dl[contains(.,'Full name')]");
    private By editLink = By.linkText("edit");
    private By fullNameTextField = By.xpath("//input[@type='text']");
    private By saveLink = By.linkText("save");

    public AccountContainer(WebDriver driver) {

        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameSettingsName));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameSettingsId));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public void clickEditLink(String nameAccount) {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameSettingsName));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameSettingsId));
            wait.until(ExpectedConditions.visibilityOfElementLocated(editFullNameLink));
            driver.findElement(editLink).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(editFullNameLink));
            driver.findElement(fullNameTextField).clear();
            driver.findElement(fullNameTextField).sendKeys(nameAccount);
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public void clickSaveAccount() {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameSettingsName));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameSettingsId));
            driver.findElement(saveLink).click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
    }


    public boolean isUserEditedDisplayed(String userName) {
        boolean isDisplayed = false;
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameSettingsName));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameSettingsId));
            isDisplayed = Commons.isElementPresent(By.xpath("//span[contains(.,'" + userName + "')]"));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
        return isDisplayed;
    }


    public void closedModalDialog() {
        try {
            driver.findElement(By.xpath("//img[@class='cmp_small_close']")).click();
        } catch (Exception e) {
            System.out.print("Error close modal dialog");
        }
    }


}




