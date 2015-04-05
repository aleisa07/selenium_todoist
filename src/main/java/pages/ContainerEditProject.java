package pages;

import framework.selenium.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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


    public void clickSaveProjectBtn()
    {
        try{
        driver.findElement(SaveProjectBtn).click();
        Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.print("exception on clickSaveProjectBtn");
        }

    }

    public void selectProjectColor(String optionColor) {

        driver.findElement(By.id("color_selector")).click();
        WebElement colorMenuElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.colors")));
        colorMenuElement.findElement(By.xpath("//a[contains(@style, '" + ColorProject.LIGHTGREEN.getRGB() + "')]")).click();
    }

}
