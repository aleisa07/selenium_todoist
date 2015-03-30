package pages;

import framework.selenium.Commons;
import framework.selenium.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Silvia Coca on 3/18/2015.
 */
public class Home {

    private WebDriver driver;
    private By loginLink = By.linkText("Login");

    public Home() {
        driver = DriverManager.getInstance().getWebDriver();
        String baseUrl = "https://en.todoist.com/";
        driver.get(baseUrl);
    }

    public LoginModal clickLogin() {
        driver.findElement(loginLink).click();
        return new LoginModal(driver);
    }

    public Dashboard loginAs(String email, String password) {
        try {
            Dashboard dashboard = new Dashboard(driver);
            if (!dashboard.isLblProjectDisplayed()) {
                //dashboard.logout();
                System.out.print("Project lbl is displayed");
                LoginModal loginModal = clickLogin();
                loginModal.loginAs(email, password);
            }
        } catch (WebDriverException e) {
            LoginModal loginModal = clickLogin();
            loginModal.loginAs(email, password);
        }
        return new Dashboard(driver);
    }


}
