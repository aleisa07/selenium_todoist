package pages;

import framework.selenium.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Silvia Coca on 3/20/2015.
 */
public class ModalDeleteProject {

    WebDriver driver;
    WebDriverWait wait;
    private By DeleteModalBtn = By.linkText("Ok");

    public ModalDeleteProject(WebDriver driver)
        {
            this.driver = driver;
            this.wait = DriverManager.getInstance().getWait();
            wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteModalBtn));
        }

    public void clickDeleteProjectBtn()
    {
        driver.findElement(DeleteModalBtn).click();
    }

}
