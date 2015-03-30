package pages;

import framework.selenium.Commons;
import framework.selenium.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.bind.annotation.W3CDomHandler;

/**
 * Created by Silvia Coca on 3/19/2015.
 */
public class LoginModal {

    private WebDriver driver;
    private WebDriverWait wait;
    private By frameName = By.name("GB_frame");
    private By frameId = By.id("GB_frame");
    private By emailTxt = By.id("email");
    private By passwordTxt = By.id("password");
    private By loginLnk = By.linkText("Login");

    public LoginModal(WebDriver driver) {
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public void fillEmail(String email) {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
            driver.findElement(emailTxt).clear();
            driver.findElement(emailTxt).sendKeys(email);
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public void fillPassword(String password) {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
            driver.findElement(passwordTxt).clear();
            driver.findElement(passwordTxt).sendKeys(password);
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public Dashboard clickLoginBtn() {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
            driver.findElement(loginLnk).click();
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
        return new Dashboard(driver);
    }


    public void setEmailTxt(String email)
    {
        fillEmail(email);
    }
    public  void setPasswordTxt(String password)
    {
        fillPassword(password);
    }

    public Dashboard loginAs(String username, String password) {
        setEmailTxt(username);
        setPasswordTxt(password);
        return clickLoginBtn();

    }
}
