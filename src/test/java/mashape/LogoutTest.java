package mashape;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContextMenuSettings;
import pages.Dashboard;
import pages.Home;
import pages.LoginModal;

/**
 * Created by Silvia Coca on 3/23/2015.
 */
public class LogoutTest {
    String expectedUser = "Aleisa08";
    String expectedemail = "scoca@pros.com";
    String password = "aleisa08";
    Home homepage;
    Dashboard dashboard;
    ContextMenuSettings contextMenuSettings;


    @BeforeMethod
    public void setUp() {
        homepage = new Home();
        dashboard = homepage.loginAs(expectedemail, password);
    }


    @Test
    public void test1LoginApplication() throws Exception {

        contextMenuSettings = dashboard.clickSettings();
        contextMenuSettings.clickLogoutMenu();
        Assert.assertTrue(homepage.isLoginDisplayed());
        dashboard.CloseConnection();

    }


}