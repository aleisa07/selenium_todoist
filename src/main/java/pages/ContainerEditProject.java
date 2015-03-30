package pages;

import framework.selenium.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Silvia Coca on 3/20/2015.
 */
public class ContainerEditProject {

    WebDriver driver;
    WebDriverWait wait;
    private By AddProjectTxt = By.xpath("//textarea[contains(@placeholder,'Project name')]");
    private By ColorSelectorrBtn = By.id("color_selector");
    private By SaveProjectBtn = By.xpath("//span[contains(.,'Save')]");
    private By specificColor = By.xpath("html/body/div[6]/table/tbody/tr/td/ul/li/a[5]/img");
    //private expectedName =

    public ContainerEditProject(WebDriver driver)
        {
            this.driver = driver;
            this.wait = DriverManager.getInstance().getWait();
            wait.until(ExpectedConditions.visibilityOfElementLocated(SaveProjectBtn));
        }

    public void setProjectName(String project_name)
    {
        driver.findElement(AddProjectTxt).clear();
        driver.findElement(AddProjectTxt).sendKeys(project_name);

    }

    public void ClickSelectColorProject()
    {
        driver.findElement(ColorSelectorrBtn).click();
        driver.findElement(specificColor).click();

    }

    public void clickSaveProjectBtn()
    {

        driver.findElement(SaveProjectBtn).click();

    }

}
