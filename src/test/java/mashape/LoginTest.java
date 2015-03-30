package mashape;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ContextMenuSettings;
import pages.Dashboard;
import pages.Home;
import pages.LoginModal;


/**
 * Created by Silvia Coca on 3/18/2015.
 */
public class LoginTest {

    Dashboard dashboard;
    ContextMenuSettings contextMenuSettings;
    Home homepage;
    LoginModal loginModal;

    @Test
    public void test1LoginApplication() throws Exception {
     String expectedUser = "Aleisa08";
     String expectedemail = "scoca@pros.com";
     String password = "aleisa08";

        Home homepage = new Home();
        LoginModal loginModal = homepage.clickLogin();
        loginModal.fillEmail(expectedemail);
        loginModal.fillPassword(password);
        dashboard = loginModal.clickLoginBtn();


        Assert.assertTrue(dashboard.isLblProjectDisplayed());

    }






}
