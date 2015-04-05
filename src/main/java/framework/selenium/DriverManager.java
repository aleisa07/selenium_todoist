package framework.selenium;

import framework.utils.Constants;
import framework.utils.Environment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class DriverManager {

    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private static DriverManager instance = null;
    private String browser = Environment.getInstance().getEnvSetting("browser");

    private DriverManager() {
        initializeWebDriver();
    }

    public static DriverManager getInstance() {
        if (instance == null || instance.driver == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public String getBrowser() {
        return browser;
    }

    /**
     * Get the Web driver
     *
     * @return
     */
    public WebDriver getWebDriver() {
        return driver;
    }

    /**
     * Get the Web Driver wait
     *
     * @return
     */
    public WebDriverWait getWait() {
        return webDriverWait;
    }

    /**
     * Quite the Driver and set to null the Web Driver
     */
    public void quitDriver() {
        try {
            driver.quit();
        } catch (Exception e) {
        }
        driver = null;
    }

    private void initializeWebDriver() {
        if (browser.equalsIgnoreCase(Constants.Browsers.FIREFOX.toString())) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase(Constants.Browsers.CHROME.toString())) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase(Constants.Browsers.IE.toString())) {
            System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase(Constants.Browsers.SAFARI.toString())) {
            driver = new SafariDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT_NORMAL, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, Constants.TIMEOUT_NORMAL);
    }

    public void takeScreenShot(String name) {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("reports/html/screenshot/" + name + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
