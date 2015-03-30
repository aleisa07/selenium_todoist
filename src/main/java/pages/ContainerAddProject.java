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
public class ContainerAddProject {

    WebDriver driver;
    WebDriverWait wait;
    private By AddProjectTxt = By.xpath("//textarea[contains(@placeholder,'Project name')]");
    private By ColorSelectorrBtn = By.id("color_selector");
    private By AddProjectBtn = By.xpath("//span[contains(.,'Add Project')]");
    private By specificColor = By.xpath("html/body/div[6]/table/tbody/tr/td/ul/li/a[1]/img");


    public ContainerAddProject(WebDriver driver)
        {
            this.driver = driver;
            this.wait = DriverManager.getInstance().getWait();
            wait.until(ExpectedConditions.visibilityOfElementLocated(AddProjectTxt));
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

    public void clickAddProjectBtn()
    {

        driver.findElement(AddProjectBtn).click();

    }

    public AddTaskContainer clickOverProject(String projectName) {

        driver.findElement(By.xpath("//tr/td[contains(., '" + projectName + "')]")).click();
        return new AddTaskContainer(driver);

    }

    public void selectProjectColor(String optionColor) {

        driver.findElement(By.id("color_selector")).click();
        WebElement colorMenuElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.colors")));
        colorMenuElement.findElement(By.xpath("//a[contains(@style, '" + ColorProject.ORANGE.getRGB() + "')]")).click();
    }

}
